package de.jfpgmc.ui.userregister;

import de.jfpgmc.dto.Customer;
import de.jfpgmc.ui.exception.DisallowedPasswordException;
import de.jfpgmc.ui.exception.UserEmailAddressInUseException;

/**
 * Interface of all methods needed by an UserRegister.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IUserRegisterDelegate {
	
	/**
	 * Process the register of the user.
	 * 
	 * @param customer the customer to register
	 * @throws UserEmailAddressInUseException when users mail address is already used
	 * @throws DisallowedPasswordException when the password is not allowed or invalid
	 */
	public void processRegisterCustomer(Customer customer)
			throws UserEmailAddressInUseException, DisallowedPasswordException;
	
}
