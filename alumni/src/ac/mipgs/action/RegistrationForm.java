package ac.mipgs.action;

import org.apache.struts.action.ActionForm;

import ac.mipgs.vo.Registration;

public class RegistrationForm extends ActionForm {

	private Registration registration = new Registration();
	private String type;
	
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
