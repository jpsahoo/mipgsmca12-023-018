package ac.mipgs.vo;

import java.io.Serializable;
import java.util.List;

public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String fullName;
	private String id;
	
	private List<Integer> appIds;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<Integer> getAppIds() {
		return appIds;
	}
	public void setAppIds(List<Integer> appIds) {
		this.appIds = appIds;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
}
