package ac.mipgs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ac.mipgs.common.Constants;
import ac.mipgs.vo.UserSession;

public class NavigationAction extends DispatchAction {
	
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
	
	public ActionForward navigateRegistration(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*String registrationType = (String) request.getAttribute("type");
		System.out.println("in navigateRegistration ---> " + registrationType);
		request.setAttribute(REGISTRATION_TYPE, registrationType);*/
		return mapping.findForward("success");
	}
	public ActionForward showRegistrationLinks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
	public ActionForward studentValidation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
	public ActionForward showAlumniSearchForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AuthenticatingForm aForm = (AuthenticatingForm) form;
		UserSession session = (UserSession) request.getSession().getAttribute(Constants.LOGIN_INFO);
		aForm.setUserSession(session);
		
		return mapping.findForward("success");
	}
	public ActionForward navigateAboutUs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
	public ActionForward navigateSMedia(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("success");
	}
}
