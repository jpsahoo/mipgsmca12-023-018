package ac.mipgs.service;

import ac.mipgs.dao.Dao;
import ac.mipgs.dao.ProfileDao;

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
}
