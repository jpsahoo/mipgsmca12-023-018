package ac.mipgs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ac.mipgs.common.Constants;
import ac.mipgs.factory.ServiceFactory;
import ac.mipgs.service.LoginService;
import ac.mipgs.service.RegistrationService;
import ac.mipgs.vo.Login;
import ac.mipgs.vo.Registration;
import ac.mipgs.vo.UserSession;

public class RegistrationAction extends DispatchAction {
	
	private static final String REGISTRATION_TYPE_STUDENT = "student";
	private static final String REGISTRATION_TYPE_ALUMNI = "alumni";
	
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegistrationForm registrationForm = (RegistrationForm) form;
		String regType = registrationForm.getType();
		
		Registration registration = registrationForm.getRegistration();
		
		RegistrationService service = ServiceFactory.getRegistrationService();
		try {
			if (service.isUserExists(registration.getUserName())) {
				request.setAttribute(Constants.ERROR_KEY, "User already exists, try with different user name");
				return mapping.findForward("success");
			}
			if (REGISTRATION_TYPE_ALUMNI.equals(regType)) {
				service.registerAlumni(registration);
			} else if (REGISTRATION_TYPE_STUDENT.equals(regType)) {
				service.registerStudent(registration);
			}
		} catch (Exception e) {
			return mapping.findForward("failed");
		}
		UserSession userSession = loginAfterRegistration(registration.getUserName(), registration.getPassword());
		HttpSession session = request.getSession();
		session.setAttribute(Constants.LOGIN_INFO, userSession);
		return mapping.findForward("success");
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
}
