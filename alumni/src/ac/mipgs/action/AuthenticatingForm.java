package ac.mipgs.action;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

import ac.mipgs.vo.UserSession;

public class AuthenticatingForm extends ActionForm implements Serializable {

	protected static final long serialVersionUID = 1L;

	private UserSession userSession = new UserSession();
	
	public UserSession getUserSession() {
		return userSession;
	}
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
}
