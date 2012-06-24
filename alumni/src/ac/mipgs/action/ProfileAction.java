package ac.mipgs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ac.mipgs.factory.ServiceFactory;
import ac.mipgs.service.ProfileService;
import ac.mipgs.vo.Registration;

public class ProfileAction extends DispatchAction {

	public ActionForward getPhoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		ProfileService service = ServiceFactory.getProfileService();
		byte[] imageData = service.getPhoto(id);
		
		if (imageData == null) {
			imageData = getDefaultImage(request);
		}
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		os.write(imageData);
		os.close();
		
		return null;
	}
	
	private byte[] getDefaultImage(ServletRequest request) {
		byte[] imageData = null;
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/images/profile_default.png");
		File file = new File(path);
		try {
			FileInputStream in = new FileInputStream(file);
			imageData = new byte[in.available()];
			in.read(imageData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageData;
	}
	
	public ActionForward gotoProfile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegistrationForm rForm = (RegistrationForm) form;
		String id = rForm.getRegistration().getId();
		
		ProfileService service = ServiceFactory.getProfileService();
		Registration registration = service.getProfile(id);
		rForm.setRegistration(registration);
		
		rForm.setFromAction("gotoProfile");
		rForm.setType(registration.getType());
		
		return mapping.findForward("success");
	}
}
