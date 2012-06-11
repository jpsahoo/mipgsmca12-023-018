package ac.mipgs.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Dao {
	
	private static String url = null;
	private static String driverClass = null;
	private static String user = null;
	private static String password = null;
	
	protected static Connection connection;
	public static void setConnection(Connection connection) {
		Dao.connection = connection;
	}
	
	static {
		Properties props = new Properties();
		try {
			
			props.load(Dao.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			url = props.getProperty("jdbc_url");
			driverClass = props.getProperty("driver_class");
			user = props.getProperty("user_name");
			password = props.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() throws Exception {
		if( driverClass == null || user == null || url == null || password == null)
			return connection;
		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		return connection;
	}
	
	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getRegistrationID() throws SQLException {
		
		String sql = "select REGISTRATION_SEQ.nextval AS ID from dual";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String id = null;
		if (rs.next()) {
			id = rs.getString("id");
		}
		return id;
	}
}
