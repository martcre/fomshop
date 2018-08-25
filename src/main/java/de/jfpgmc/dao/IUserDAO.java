package de.jfpgmc.dao;

import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;

/**
 * Interface for an UserDAO.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
public interface IUserDAO {

	/**
	 * Create User user.
	 * 
	 * @param user the user to create
	 * @return the created user
	 */
	public User createUser(User user);
	
	/**
	 * Update User user.
	 * 
	 * @param user the user to update
	 * @return the updated user
	 */
	public User updateUser(User user);
	
	/**
	 * Delete User user.
	 * 
	 * @param user the user
	 */
	public void deleteUser(User user);

	/**
	 * Find an User by email.
	 * 
	 * @param email the email
	 * @return the user
	 */
	public User findUserByEmail(String email);
	
	/**
	 * Find an User by alias.
	 * 
	 * @param alias the alias
	 * @return the user
	 */
	public User findUserByAlias(String alias);
	
	/**
	 * Create Customer customer.
	 * 
	 * @param customer the customer to create
	 * @return the created customer
	 */
	public Customer createCustomer(Customer customer);
	
	/**
	 * Update Customer customer.
	 * 
	 * @param customer the customer to update
	 * @return the updated customer
	 */
	public Customer updateCustomer(Customer customer);
	
	/**
	 * Delete Customer customer.
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
	
	
	/**
	 * Find a Customer by the corresponding user.
	 * 
	 * @param user the corresponding user
	 * @return the customer
	 */
	public Customer findCustomerByUser(User user);
	
}
