package ac.mipgs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ac.mipgs.vo.Login;
import ac.mipgs.vo.UserSession;

public class LoginDao extends Dao {
	
	private static final String DO_LOGIN  = new StringBuffer("select ")
		.append("  first_name ")
		.append(", last_name ")
		.append(", id ")
		.append(" from alumni_details ")
		.append(" where ")
		.append(" user_name=?")
		.append(" and password=? ")
		.toString();

	public static UserSession login(Login login) throws SQLException {
		UserSession userSession = null;
		
		PreparedStatement pstmt = connection.prepareStatement(DO_LOGIN);
		int index = 1;
		pstmt.setString(index++, login.getUserName());
		pstmt.setString(index++, login.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		String fullName = null;
		if (rs.next()) {
			userSession = new UserSession();
			String lName = rs.getString("last_name");
			String fName = rs.getString("first_name");
			fullName = new StringBuffer(lName).append(" ").append(fName).toString();
			
			userSession.setFullName(fullName);
			userSession.setUserName(login.getUserName());
			userSession.setId(rs.getString("id"));
		}
		return userSession;
	}
}
