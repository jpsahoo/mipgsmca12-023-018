package ac.mipgs.action;

import org.apache.struts.action.ActionForm;

import ac.mipgs.vo.StudentValidator;

public class StudentValidatorForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private StudentValidator validator = new StudentValidator();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setValidator(StudentValidator validator) {
		this.validator = validator;
	}
	public StudentValidator getValidator() {
		return validator;
	}
}
