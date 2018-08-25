package de.jfpgmc.ui.userinfo;

import de.jfpgmc.ui.exception.UserSecurityException;

/**
 * Interface of all methods needed by an UserInfo.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
public interface IUserInfoDelegate {

	/**
	 * Process the login with name and password.
	 * 
	 * @param email the login email
	 * @param password the login password
	 * @throws UserSecurityException when the login fails
	 */
	public void processLogin(String email, String password) throws UserSecurityException;
	
	/**
	 * Process the logout of the user.
	 */
	public void processLogout();
	
	/**
	 * Process open registration of a new user.
	 */
	public void processOpenRegisterUser();

	/**
	 * Process open AdminOrder.
	 */
	public void processOpernAdminOrder();
	
	/**
	 * Process open ArticleListing.
	 */
	public void processArticleListing();
}
