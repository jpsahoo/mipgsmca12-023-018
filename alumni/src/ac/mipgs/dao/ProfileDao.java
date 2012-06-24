package ac.mipgs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDao extends Dao {

	private static final String GET_PHOTO = "select PHOTO from ALUMNI_DETAILS where id = ?";
	
	public static byte[] getPhoto(String id) throws SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement(GET_PHOTO);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		byte[] imageData = null;
		if (rs.next()) {
			imageData = rs.getBytes(1);
		}
		return imageData;
	}
}
