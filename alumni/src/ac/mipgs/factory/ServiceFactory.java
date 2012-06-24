package ac.mipgs.factory;

import ac.mipgs.service.AlumniSearchService;
import ac.mipgs.service.LoginService;
import ac.mipgs.service.ProfileService;
import ac.mipgs.service.RegistrationService;

public class ServiceFactory {

	public static RegistrationService getRegistrationService() {
		return new RegistrationService();
	}
	
	public static LoginService getLoginService() {
		return new LoginService();
	}
	
	public static AlumniSearchService getAlumniSearchService() {
		return new AlumniSearchService();
	}
	
	public static ProfileService getProfileService() {
		return new ProfileService();
	}
}
