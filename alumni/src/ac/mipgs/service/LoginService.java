package ac.mipgs.service;

import java.sql.Connection;
import java.sql.SQLException;

import ac.mipgs.dao.Dao;
import ac.mipgs.dao.LoginDao;
import ac.mipgs.vo.Login;
import ac.mipgs.vo.UserSession;

public class LoginService {

	public UserSession login(Login login) throws Exception {
		UserSession userSession = null;
		Connection connection = null;
		try {
			connection = Dao.getDBConnection();
			userSession = LoginDao.login(login);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Login Failed");
		} finally {
			Dao.close();
		}
		return userSession;
	}
}
