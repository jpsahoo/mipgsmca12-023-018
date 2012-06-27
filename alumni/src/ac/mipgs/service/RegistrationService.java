package ac.mipgs.service;

import java.sql.Connection;

import ac.mipgs.dao.Dao;
import ac.mipgs.dao.ProfileDao;
import ac.mipgs.dao.RegistrationDao;
import ac.mipgs.vo.Registration;
import ac.mipgs.vo.StudentValidator;

public class RegistrationService {

	public void registerStudent(Registration registration) throws Exception {
		
		Connection connection = null;
		try {
			connection = Dao.getDBConnection();
			
			String id = Dao.getRegistrationID();
			registration.setId(id);
			registration.getAddress().setId(id);
			registration.getCourse().setId(id);
			
			RegistrationDao.insertAlumniDetails(registration);
			RegistrationDao.insertAddressDetails(registration.getAddress());
			RegistrationDao.insertCourseDetails(registration.getCourse());
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw new Exception("Failed to save registration details");
		} finally {
			Dao.close();
		}
	}
	
	public boolean isUserExists(String userName) throws Exception {
		try {
			Dao.getDBConnection();
			return RegistrationDao.isUserExists(userName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to save registration details");
		} finally {
			Dao.close();
		}
	}
	
	public void registerAlumni(Registration registration) throws Exception {
		
		Connection connection = null;
		try {
			connection = Dao.getDBConnection();
			
			String id = Dao.getRegistrationID();
			registration.setId(id);
			registration.getAddress().setId(id);
			registration.getCourse().setId(id);
			registration.getAlumni().setId(id);
			
			RegistrationDao.insertAlumniDetails(registration);
			RegistrationDao.insertAddressDetails(registration.getAddress());
			RegistrationDao.insertCourseDetails(registration.getCourse());
			RegistrationDao.insertOrganizationDetails(registration.getAlumni());
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw new Exception("Failed to save registration details");
		} finally {
			Dao.close();
		}
	}
	
	public void updateStudentDetails(Registration registration) throws Exception {
		Connection connection = null;
		try {
			connection = Dao.getDBConnection();
			
			String id = registration.getId();
			registration.getAddress().setId(id);
			registration.getCourse().setId(id);
			
			byte[] photo = registration.getPhoto();
			if (photo == null || photo.length == 0) {
				photo = ProfileDao.getPhoto(id);
				registration.setPhoto(photo);
			}
			
			RegistrationDao.updateAlumniDetails(registration);
			RegistrationDao.updateAddressDetails(registration.getAddress());
			RegistrationDao.updateCourseDetails(registration.getCourse());
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw new Exception("Failed to update registration details");
		} finally {
			Dao.close();
		}
	}
	
	public void updateAlumniDetails(Registration registration) throws Exception {
		Connection connection = null;
		try {
			connection = Dao.getDBConnection();
			
			String id = registration.getId();
			registration.getAddress().setId(id);
			registration.getCourse().setId(id);
			registration.getAlumni().setId(id);
			
			byte[] photo = registration.getPhoto();
			if (photo == null || photo.length == 0) {
				photo = ProfileDao.getPhoto(id);
				registration.setPhoto(photo);
			}
			
			RegistrationDao.updateAlumniDetails(registration);
			RegistrationDao.updateAddressDetails(registration.getAddress());
			RegistrationDao.updateCourseDetails(registration.getCourse());
			RegistrationDao.updateOrganizationDetails(registration.getAlumni());
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw new Exception("Failed to update registration details");
		} finally {
			Dao.close();
		}
	}
	
	public boolean validateStudent(StudentValidator validator) throws Exception {
		try {
			Dao.getDBConnection();
			return RegistrationDao.isStudentExists(validator);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
