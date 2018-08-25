package de.jfpgmc.service;

import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;
import de.jfpgmc.ui.exception.DisallowedPasswordException;
import de.jfpgmc.ui.exception.UserEmailAddressInUseException;

/**
 * Interface of a UserService.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IUserService {

	/**
	 * Register a new Customer and also create the inherited user.
	 * 
	 * @param customer the customer to create
	 * @throws UserEmailAddressInUseException when the email of the user is already in use
	 * @throws DisallowedPasswordException when the provided password was not accepted
	 */
	public void registerCustomer(Customer customer) throws UserEmailAddressInUseException, DisallowedPasswordException;

	/**
	 * Lookup a user with a name (email address) and password, use for checking the user credential.
	 * 
	 * @param name the username or email address
	 * @param password the password
	 * @return the user or null, if not successfully logged in
	 */
	public User fetchUserByEmailAndPassword(String name, String password);
	
	/**
	 * Find the corresponding customer for a user.
	 * 
	 * @param user the user
	 * @return the customer
	 */
	public Customer findCustomerByUser(User user);
	
}
