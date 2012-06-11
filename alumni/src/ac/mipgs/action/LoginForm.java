package ac.mipgs.action;

import org.apache.struts.action.ActionForm;

import ac.mipgs.vo.Login;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Login login = new Login();
	
	public void setLogin(Login login) {
		this.login = login;
	}
	public Login getLogin() {
		return login;
	}
}
