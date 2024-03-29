package ac.mipgs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ac.mipgs.vo.Address;
import ac.mipgs.vo.Alumni;
import ac.mipgs.vo.Course;
import ac.mipgs.vo.Registration;
import ac.mipgs.vo.StudentValidator;

public class RegistrationDao extends Dao{
	
	private static final String INSERT_ALUMNI_DETAILS = new StringBuffer("insert into alumni_details ")
			.append("(id, ")
			.append("first_name, ")
			.append("last_name, ")
			.append("gender, ")
			.append("email_id, ")
			.append("mobile_number, ")
			.append("telephone_number, ")
			.append("user_name, ")
			.append("password, ")
			.append("dob, ")
			.append("photo, ")
			.append("type) ")
			.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();
	private static final String INSERT_ADDRESS_DETAILS = new StringBuffer("insert into address_tbl ")
			.append("(id, ")
			.append("addr_line_1, ")
			.append("addr_line_2, ")
			.append("city, ")
			.append("state, ")
			.append("country, ")
			.append("pincode) ")
			.append("values (?, ?, ?, ?, ?, ?, ?)").toString();
	private static final String INSERT_COURSE_DETAILS = new StringBuffer("insert into course_details ")
			.append("(id, ")
			.append("graduation, ")
			.append("course, ")
			.append("year) ")
			.append("values (?, ?, ?, ?)").toString();
	private static final String INSERT_ORGANIZATION_DETAILS = new StringBuffer("insert into ORGANIZATION_DETAILS ")
			.append(" (id ")
			.append(" ,passout_year ")
			.append(" ,empl_nature ")
			.append(" ,org_name ")
			.append(" ,designation ")
			.append(" ,empl_city ")
			.append(" ,work_country ")
			.append(" ,platform) ")
			.append(" values (?, ?, ?, ?, ?, ?, ?, ?) ")
			.toString();
	private static final String IS_USER_EXISTS = "select 1 from ALUMNI_DETAILS where user_name = ?";
	private static final String IS_STUDENT_EXISTS = "select 1 from STUDENT_DATA where full_name like ? and roll_number = ?";
	private static final String UPDATE_ALUMNI_DETAILS = new StringBuffer("update ALUMNI_DETAILS set ")
			.append("  first_name = ?")
			.append(" ,last_name = ?")
			.append(" ,gender = ?")
			.append(" ,email_id= ?")
			.append(" ,mobile_number= ?")
			.append(" ,telephone_number = ?")
			.append(" ,dob = ?")
			.append(" ,photo = ?")
			.append(" where id = ?")
			.toString();
	private static final String UPDATE_COURSE_DETAILS = new StringBuffer("update COURSE_DETAILS set ")
			.append("  graduation = ?")
			.append(" ,course = ?")
			.append(" ,year = ?")
			.append(" where id = ?")
			.toString();
	private static final String UPDATE_ADDRESS_DETAILS = new StringBuffer("update ADDRESS_TBL set ")
			.append("  addr_line_1 = ?")
			.append(" ,addr_line_2 = ?")
			.append(" ,city = ?")
			.append(" ,state = ?")
			.append(" ,country = ?")
			.append(" ,pincode = ?")
			.append(" where id = ?")
			.toString();
	private static final String UPDATE_ORGANIZATION_DETAILS = new StringBuffer("update ORGANIZATION_DETAILS set ")
			.append("  passout_year = ?")
			.append(" ,empl_nature = ?")
			.append(" ,org_name = ?")
			.append(" ,empl_city = ?")
			.append(" ,work_country = ?")
			.append(" ,platform = ?")
			.append(" ,designation = ?")
			.append(" where id = ?")
			.toString();
	
	public static void insertAlumniDetails(Registration registration) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(INSERT_ALUMNI_DETAILS);
		int index = 1;
		pstmt.setString(index++, registration.getId());
		pstmt.setString(index++, registration.getFirstName());
		pstmt.setString(index++, registration.getLastName());
		pstmt.setString(index++, registration.getGender());
		pstmt.setString(index++, registration.getEmailId());
		pstmt.setString(index++, registration.getMobileNumber());
		pstmt.setString(index++, registration.getTelephoneNumber());
		pstmt.setString(index++, registration.getUserName());
		pstmt.setString(index++, registration.getPassword());
		pstmt.setString(index++, registration.getDob());
		pstmt.setBytes(index++, registration.getPhoto());
		pstmt.setString(index++, registration.getType());
		pstmt.executeUpdate();
	}
	
	public static void insertAddressDetails(Address address) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(INSERT_ADDRESS_DETAILS);
		int index = 1;
		pstmt.setString(index++, address.getId());
		pstmt.setString(index++, address.getAddrLine1());
		pstmt.setString(index++, address.getAddrLine2());
		pstmt.setString(index++, address.getCity());
		pstmt.setString(index++, address.getState());
		pstmt.setString(index++, address.getCountry());
		pstmt.setString(index++, address.getPincode());
		pstmt.executeUpdate();
	}
	
	public static void insertCourseDetails(Course course) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(INSERT_COURSE_DETAILS);
		int index=1;
		pstmt.setString(index++, course.getId());
		pstmt.setString(index++, course.getGraduation());
		pstmt.setString(index++, course.getCourse());
		pstmt.setString(index++, course.getYear());
		pstmt.executeUpdate();
	}
	
	public static void insertOrganizationDetails(Alumni alumni) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(INSERT_ORGANIZATION_DETAILS);
		int index=1;
		pstmt.setString(index++, alumni.getId());
		pstmt.setString(index++, alumni.getPassOutYear());
		pstmt.setString(index++, alumni.getEmplNature());
		pstmt.setString(index++, alumni.getOrgName());
		pstmt.setString(index++, alumni.getDesignation());
		pstmt.setString(index++, alumni.getEmplCity());
		pstmt.setString(index++, alumni.getWorkCountry());
		pstmt.setString(index++, alumni.getPlatform());
		
		pstmt.executeUpdate();
	}

	public static boolean isUserExists(String userName) throws SQLException{
		PreparedStatement pstmt = connection.prepareStatement(IS_USER_EXISTS);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		return rs.next(); 
		
	}
	
	public static boolean isStudentExists(StudentValidator validator) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(IS_STUDENT_EXISTS);
		pstmt.setString(1, "%" + validator.getName() + "%");
		pstmt.setString(2, validator.getRollNumber());
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
	
	public static void updateAlumniDetails(Registration registration) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_ALUMNI_DETAILS);
		int index = 1;
		pstmt.setString(index++, registration.getFirstName());
		pstmt.setString(index++, registration.getLastName());
		pstmt.setString(index++, registration.getGender());
		pstmt.setString(index++, registration.getEmailId());
		pstmt.setString(index++, registration.getMobileNumber());
		pstmt.setString(index++, registration.getTelephoneNumber());
		pstmt.setString(index++, registration.getDob());
		pstmt.setBytes(index++, registration.getPhoto());
		pstmt.setString(index++, registration.getId());
		pstmt.executeUpdate();
	}
	
	public static void updateAddressDetails(Address address) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_ADDRESS_DETAILS);
		int index = 1;
		pstmt.setString(index++, address.getAddrLine1());
		pstmt.setString(index++, address.getAddrLine2());
		pstmt.setString(index++, address.getCity());
		pstmt.setString(index++, address.getState());
		pstmt.setString(index++, address.getCountry());
		pstmt.setString(index++, address.getPincode());
		pstmt.setString(index++, address.getId());
		pstmt.executeUpdate();
	}
	
	public static void updateCourseDetails(Course course) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_COURSE_DETAILS);
		int index=1;
		pstmt.setString(index++, course.getGraduation());
		pstmt.setString(index++, course.getCourse());
		pstmt.setString(index++, course.getYear());
		pstmt.setString(index++, course.getId());
		pstmt.executeUpdate();
	}
	
	public static void updateOrganizationDetails(Alumni alumni) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_ORGANIZATION_DETAILS);
		int index=1;
		pstmt.setString(index++, alumni.getPassOutYear());
		pstmt.setString(index++, alumni.getEmplNature());
		pstmt.setString(index++, alumni.getOrgName());
		pstmt.setString(index++, alumni.getEmplCity());
		pstmt.setString(index++, alumni.getWorkCountry());
		pstmt.setString(index++, alumni.getPlatform());
		pstmt.setString(index++, alumni.getDesignation());
		pstmt.setString(index++, alumni.getId());
		
		pstmt.executeUpdate();
	}
}
