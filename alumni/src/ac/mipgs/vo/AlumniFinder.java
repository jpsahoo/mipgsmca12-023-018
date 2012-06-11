package ac.mipgs.vo;

import java.io.Serializable;

public class AlumniFinder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String course;
	private String platform;
	private String searchType;
	
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
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchType() {
		return searchType;
	}
}
