package ac.mipgs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ac.mipgs.vo.Address;
import ac.mipgs.vo.Alumni;
import ac.mipgs.vo.Course;
import ac.mipgs.vo.Registration;

public class ProfileDao extends Dao {

	private static final String GET_PHOTO = "select PHOTO from ALUMNI_DETAILS where id = ?";
	private static final String GET_PROFILE = new StringBuffer("select ")
			.append("  first_name")
			.append(", last_name")
			.append(", email_id")
			.append(", mobile_number")
			.append(", telephone_number")
			.append(", dob")
			.append(", gender")
			.append(", type")
			.append(" from alumni_details where id = ?")
			.toString();
	private static final String GET_PROFILE_COURSE = new StringBuffer("select ")
			.append("  graduation")
			.append(", course")
			.append(", year")
			.append(" from course_details where id = ?")
			.toString();
	private static final String GET_PROFILE_ADDRESS = new StringBuffer("select ")
			.append("  addr_line_1")
			.append(", addr_line_2")
			.append(", city")
			.append(", state")
			.append(", country")
			.append(", pincode")
			.append(" from address_tbl where id = ?")
			.toString();
	private static final String GET_PROFILE_ORGANIZATION = new StringBuffer("select ")
			.append("  passout_year")
			.append(", empl_nature")
			.append(", org_name")
			.append(", empl_city")
			.append(", work_country")
			.append(", platform")
			.append(", designation")
			.append(" from organization_details where id = ?")
			.toString();
	
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
	
	public static Registration getProfile(String id) throws SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement(GET_PROFILE);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		Registration registration = null;
		if (rs.next()) {
			registration = new Registration();
			registration.setId(id);
			registration.setFirstName(rs.getString("first_name"));
			registration.setLastName(rs.getString("last_name"));
			registration.setEmailId(rs.getString("email_id"));
			registration.setMobileNumber(rs.getString("mobile_number"));
			registration.setTelephoneNumber(rs.getString("telephone_number"));
			registration.setDob(rs.getString("dob"));
			registration.setGender(rs.getString("gender"));
			registration.setType(rs.getString("type"));
		}
		return registration;
	}

	public static Address getAddressDetails(String id) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(GET_PROFILE_ADDRESS);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		Address address = null;
		if (rs.next()) {
			address = new Address();
			address.setAddrLine1(rs.getString("addr_line_1"));
			address.setAddrLine2(rs.getString("addr_line_2"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setCountry(rs.getString("country"));
			address.setPincode(rs.getString("pincode"));
			
		}
		return address;
	}

	public static Course getCourseDetails(String id) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(GET_PROFILE_COURSE);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Course course = null;
		if (rs.next()) {
			course = new Course();
			course.setGraduation(rs.getString("graduation"));
			course.setCourse(rs.getString("course"));
			course.setYear(rs.getString("year"));
		}
		return course;
	}

	public static Alumni getAlumniDetails(String id) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(GET_PROFILE_ORGANIZATION);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Alumni alumni = null;
		if (rs.next()) {
			alumni = new Alumni();
			alumni.setPassOutYear(rs.getString("passout_year"));
			alumni.setEmplNature(rs.getString("empl_nature"));
			alumni.setOrgName(rs.getString("org_name"));
			alumni.setEmplCity(rs.getString("empl_city"));
			alumni.setWorkCountry(rs.getString("work_country"));
			alumni.setPlatform(rs.getString("platform"));
			alumni.setDesignation(rs.getString("designation"));
		}
		return alumni;
	}
}
