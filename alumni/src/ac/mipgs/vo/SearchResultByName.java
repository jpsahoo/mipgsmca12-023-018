package ac.mipgs.vo;

import java.io.Serializable;

public class SearchResultByName implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String course;
	private String passoutYear;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPassoutYear() {
		return passoutYear;
	}
	public void setPassoutYear(String passoutYear) {
		this.passoutYear = passoutYear;
	}
}
