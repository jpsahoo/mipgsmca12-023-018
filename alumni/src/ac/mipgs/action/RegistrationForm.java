package ac.mipgs.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import ac.mipgs.vo.Registration;

public class RegistrationForm extends ActionForm {

	private Registration registration = new Registration();
	private FormFile photo;
	private String type;
	
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}
	public FormFile getPhoto() {
		return photo;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
