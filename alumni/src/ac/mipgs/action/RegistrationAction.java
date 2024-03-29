package ac.mipgs.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import ac.mipgs.common.Constants;
import ac.mipgs.factory.ServiceFactory;
import ac.mipgs.service.LoginService;
import ac.mipgs.service.RegistrationService;
import ac.mipgs.vo.Login;
import ac.mipgs.vo.Registration;
import ac.mipgs.vo.UserSession;

public class RegistrationAction extends DispatchAction {
	
	private static final int MAX_FILE_SIZE = 100*1024; // 100KB
	private static final String VALIDATE_ERROR = "VALIDATE_ERROR";
	
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegistrationForm registrationForm = (RegistrationForm) form;
		Registration registration = registrationForm.getRegistration();
		
		FormFile photo = registrationForm.getPhoto();
		if (photo != null && photo.getFileSize() > MAX_FILE_SIZE) {
			request.setAttribute(Constants.ERROR_KEY, "File size is more than 100KB, please upload Photo with lesser size.");
			return mapping.findForward("success");
		}
		
		byte[] photoData = readPhoto(photo.getInputStream());
		registration.setPhoto(photoData);
		registration.setType(registrationForm.getType());
		
		RegistrationService service = ServiceFactory.getRegistrationService();
		try {
			String regType = registration.getType();
			String id = registration.getId();
			if (id == null || "".equals(id)) {
				if (service.isUserExists(registration.getUserName())) {
					request.setAttribute(Constants.ERROR_KEY, "User already exists, try with different user name");
					return mapping.findForward("success");
				}
				if (Constants.REGISTRATION_TYPE_ALUMNI.equals(regType)) {
					service.registerAlumni(registration);
				} else if (Constants.REGISTRATION_TYPE_STUDENT.equals(regType)) {
					service.registerStudent(registration);
				}
				UserSession userSession = loginAfterRegistration(registration.getUserName(), registration.getPassword());
				HttpSession session = request.getSession();
				session.setAttribute(Constants.LOGIN_INFO, userSession);
				registrationForm.setFromAction("registration_save");
			} else {
				if (Constants.REGISTRATION_TYPE_ALUMNI.equals(regType)) {
					service.updateAlumniDetails(registration);
				} else if (Constants.REGISTRATION_TYPE_STUDENT.equals(regType)) {
					service.updateStudentDetails(registration);
				}
				registrationForm.setFromAction("registration_update");
			}
		} catch (Exception e) {
			return mapping.findForward("failed");
		}
		
		return mapping.findForward("success");
	}
	
	private byte[] readPhoto(InputStream is) {
		byte[] photoData = null;
		try {
			photoData = new byte[is.available()];
			is.read(photoData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return photoData;
	}
	
	private UserSession loginAfterRegistration(String userName, String password) {
		
		LoginService loginService = ServiceFactory.getLoginService();
		UserSession userSession = null;
		try {
			Login login = new Login();
			login.setUserName(userName);
			login.setPassword(password);
			
			userSession = loginService.login(login);
		} catch (Exception e) {
			
		}
		return userSession;
	}
	
	public ActionForward validateStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StudentValidatorForm studentValidatorForm = (StudentValidatorForm) form;
		if (Constants.REGISTRATION_TYPE_STUDENT.equals(studentValidatorForm.getType())) {
			RegistrationService service = ServiceFactory.getRegistrationService();
			if (!service.validateStudent(studentValidatorForm.getValidator())) {
				request.setAttribute(VALIDATE_ERROR, "Student doesn't exists");
				return mapping.findForward("failed");
			}
		}
		return mapping.findForward("success");
	}
}
