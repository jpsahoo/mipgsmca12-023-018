package ac.mipgs.service;

import ac.mipgs.common.Constants;
import ac.mipgs.dao.Dao;
import ac.mipgs.dao.ProfileDao;
import ac.mipgs.vo.Address;
import ac.mipgs.vo.Alumni;
import ac.mipgs.vo.Course;
import ac.mipgs.vo.Registration;

public class ProfileService {

	public byte[] getPhoto(String id) {
		
		byte[] imageData = null;
		try {
			Dao.getDBConnection();
			imageData = ProfileDao.getPhoto(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageData;
	}
	
	public Registration getProfile(String id) throws Exception {
		Registration registration = null;
		try {
			Dao.getDBConnection();
			registration = ProfileDao.getProfile(id);
			
			if (registration != null) {
				Address address = ProfileDao.getAddressDetails(id);
				Course course = ProfileDao.getCourseDetails(id);
				registration.setAddress(address);
				registration.setCourse(course);
				if (Constants.REGISTRATION_TYPE_ALUMNI.equals(registration.getType())) {
					Alumni alumni = ProfileDao.getAlumniDetails(id);
					registration.setAlumni(alumni);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Login Failed");
		} finally {
			Dao.close();
		}
		return registration;
	}
}
