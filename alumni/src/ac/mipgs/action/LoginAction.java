package ac.mipgs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import ac.mipgs.common.Constants;
import ac.mipgs.factory.ServiceFactory;
import ac.mipgs.service.LoginService;
import ac.mipgs.vo.Login;
import ac.mipgs.vo.UserSession;

public class LoginAction extends DispatchAction {
	

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm) form;
		Login login = loginForm.getLogin();
		
		//Test comment
		
		UserSession userSession = null;
		LoginService loginService = ServiceFactory.getLoginService();
		
		String forwardName = null;
		try {
			userSession = loginService.login(login);
		} catch (Exception e) {
			forwardName = "failed";
		}
		if (userSession ==null)
			forwardName = "failed";
		else {
			session.setAttribute(Constants.LOGIN_INFO, userSession);
			forwardName = "success";
		}
		
		/*ActionMessages messages = new ActionMessages();
		ActionMessage message = new ActionMessage("message", userSession.getFullName());
		messages.add("message", message);
		saveMessages(request, messages);*/
		
		return mapping.findForward(forwardName);
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.LOGIN_INFO);
		session.invalidate();
		
		/*ActionMessages messages = new ActionMessages();
		ActionMessage message = new ActionMessage("message", "You are logged out.");
		messages.add("messages", message);
		saveMessages(request, messages);*/
		request.setAttribute(Constants.MESSAGE, "You are logged out.");
		
		return mapping.findForward("success");
	}
}
