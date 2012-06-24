package ac.mipgs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ac.mipgs.vo.AlumniFinder;
import ac.mipgs.vo.SearchResultByName;
import ac.mipgs.vo.SearchResultByPlatform;

public class AlumniSearchDao extends Dao {

	private static final String SEARCH_BY_NAME = new StringBuffer("select ")
		.append("a.first_name || ' ' || a.last_name as full_name ")
		.append(", c.course ")
		.append(", o.passout_year ")
		.append("  from alumni_details a ")
		.append(", course_details c ")
		.append(", organization_details o ")
		.append("  where lower(a.first_name || ' ' || a.last_name) like ? ")
		.append("  and a.id = c.id ")
		.append("  and a.id=o.id")
		.append("  AND c.course=?").toString();
	private static final String SEARCH_BY_PLATFORM = new StringBuffer("select ")
		.append("a.first_name || ' ' || a.last_name as full_name ")
		.append(", a.email_id ")
		.append(", o.org_name ")
		.append(", c.course ")
		.append(", o.passout_year ")
		.append(", o.platform ")
		.append("  from alumni_details a ")
		.append(", course_details c ")
		.append(", organization_details o ")
		.append("  where a.id = c.id ")
		.append("  and a.id=o.id")
		.append("  AND lower(o.platform) like ?").toString();
	private static final String SEARCH_BY_PASSOUT_YEAR = new StringBuffer("select ")
		.append("a.first_name || ' ' || a.last_name as full_name ")
		.append(", a.email_id ")
		.append(", o.org_name ")
		.append(", c.course ")
		.append(", o.passout_year ")
		.append(", o.platform ")
		.append("  from alumni_details a ")
		.append(", course_details c ")
		.append(", organization_details o ")
		.append("  where a.id = c.id ")
		.append("  and a.id=o.id")
		.append("  AND o.passout_year like ?")
		.append("  AND c.course=?").toString();
	
	public static SearchResultByName[] searchByName(AlumniFinder finder) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(SEARCH_BY_NAME);
		
		String name = finder.getName().toLowerCase();
		
		pstmt.setString(1, "%" + name + "%");
		pstmt.setString(2, finder.getCourse());
		
		ResultSet rs = pstmt.executeQuery();
		
		List<SearchResultByName> resultList = new ArrayList<SearchResultByName>();
		
		while (rs.next()) {
			SearchResultByName obj = new SearchResultByName();
			obj.setName(rs.getString("full_name"));
			obj.setCourse(rs.getString("course"));
			obj.setPassoutYear(Long.toString(rs.getLong("passout_year")));
			resultList.add(obj);
		}
		return resultList.toArray(new SearchResultByName[0]);
	}

	public static SearchResultByName[] searchByPlatform(AlumniFinder finder) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(SEARCH_BY_PLATFORM);
		
		String platform = finder.getPlatform().toLowerCase();
		pstmt.setString(1, "%" + platform + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		List<SearchResultByPlatform> resultList = new ArrayList<SearchResultByPlatform>();
		
		while (rs.next()) {
			SearchResultByPlatform obj = new SearchResultByPlatform();
			
			obj.setName(rs.getString("full_name"));
			obj.setEmailId(rs.getString("email_id"));
			obj.setOrgName(rs.getString("org_name"));
			obj.setCourse(rs.getString("course"));
			obj.setPassoutYear(Long.toString(rs.getLong("passout_year")));
			obj.setPlatform(rs.getString("platform"));
			resultList.add(obj);
		}
		return resultList.toArray(new SearchResultByName[0]);
	}
	
	public static SearchResultByName[] searchByPassoutYear(AlumniFinder finder) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(SEARCH_BY_PASSOUT_YEAR);
		
		pstmt.setLong(1, Long.parseLong(finder.getPassoutYear()));
		pstmt.setString(2, finder.getCourse());
		
		ResultSet rs = pstmt.executeQuery();
		
		List<SearchResultByPlatform> resultList = new ArrayList<SearchResultByPlatform>();
		
		while (rs.next()) {
			SearchResultByPlatform obj = new SearchResultByPlatform();
			
			obj.setName(rs.getString("full_name"));
			obj.setEmailId(rs.getString("email_id"));
			obj.setOrgName(rs.getString("org_name"));
			obj.setCourse(rs.getString("course"));
			obj.setPassoutYear(Long.toString(rs.getLong("passout_year")));
			obj.setPlatform(rs.getString("platform"));
			resultList.add(obj);
		}
		return resultList.toArray(new SearchResultByName[0]);
	}
	

}
