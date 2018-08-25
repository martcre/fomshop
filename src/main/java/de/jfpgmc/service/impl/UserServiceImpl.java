package de.jfpgmc.service.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import de.jfpgmc.dao.IUserDAO;
import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;
import de.jfpgmc.service.IUserService;
import de.jfpgmc.ui.exception.DisallowedPasswordException;
import de.jfpgmc.ui.exception.UserEmailAddressInUseException;

/**
 * Implementation if the UserService.
 * 
 * @author Martin Cremer
 *
 */
public class UserServiceImpl implements IUserService, Serializable {
	
	private static final long serialVersionUID = 3172437002876567940L;
	/**
	 * Injected by spring.
	 */
	private IUserDAO userDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void registerCustomer(Customer customer) throws UserEmailAddressInUseException,
			DisallowedPasswordException {
		User user = customer.getUser();
		if (userDAO.findUserByEmail(user.getEmail()) != null) {
			throw new UserEmailAddressInUseException();
		} else {
			userDAO.createUser(user);
			userDAO.createCustomer(customer);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public User fetchUserByEmailAndPassword(String email, String password) {
		return userDAO.findUserByEmail(email);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByUser(User user) {
		return userDAO.findCustomerByUser(user);
	}
	
	/**
	 * Injection point for userDAO.
	 * 
	 * @param userDAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
