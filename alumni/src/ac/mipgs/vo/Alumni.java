package ac.mipgs.vo;

import java.io.Serializable;

public class Alumni implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String passOutYear;
	private String emplNature;
	private String orgName;
	private String designation;
	private String emplCity;
	private String workCountry;
	private String platform;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassOutYear(String passOutYear) {
		this.passOutYear = passOutYear;
	}
	public String getPassOutYear() {
		return passOutYear;
	}
	public String getEmplNature() {
		return emplNature;
	}
	public void setEmplNature(String emplNature) {
		this.emplNature = emplNature;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmplCity() {
		return emplCity;
	}
	public void setEmplCity(String emplCity) {
		this.emplCity = emplCity;
	}
	public String getWorkCountry() {
		return workCountry;
	}
	public void setWorkCountry(String workCountry) {
		this.workCountry = workCountry;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
