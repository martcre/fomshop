package de.jfpgmc.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.jfpgmc.dao.IUserDAO;
import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;

/**
 * Implementation of the IUserDAO. Contains methods to manage user and customers.
 * 
 * @author Martin Cremer
 * 
 */
public class UserDAOImpl implements IUserDAO, Serializable {

	private static final long serialVersionUID = 6699626640764132967L;
	protected EntityManager entityManager;

	/**
	 * Setter for the JPA entityManager.
	 * 
	 * @param entityManager
	 *            the entityManager
	 */
	@PersistenceContext(unitName = "fomshop")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User createUser(User user) {
		entityManager.persist(user);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateUser(User user) {
		User updatedUser = entityManager.merge(user);
		return updatedUser;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUser(User user) {
		User userToDelete = entityManager.find(User.class, user.getId());
		entityManager.remove(userToDelete);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserByEmail(String email) {
		try {
			Query query = entityManager
					.createQuery("SELECT u FROM User u WHERE u.email = :email ");
			query.setParameter("email", email);
			return (User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserByAlias(String alias) {
		try {
			Query query = entityManager
					.createQuery("SELECT u FROM User u WHERE u.alias = :alias ");
			query.setParameter("alias", alias);
			return (User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer createCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = entityManager.merge(customer);
		return updatedCustomer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		Customer customerToDelete = entityManager.find(Customer.class,
				customer.getId());
		entityManager.remove(customerToDelete);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByUser(User user) {
		try {
			Query query = entityManager
					.createQuery("SELECT c FROM Customer c WHERE c.user = :user ");
			query.setParameter("user", user);
			return (Customer) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
