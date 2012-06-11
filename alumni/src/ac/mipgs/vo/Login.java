package ac.mipgs.vo;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String fullName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return fullName;
	}
}
