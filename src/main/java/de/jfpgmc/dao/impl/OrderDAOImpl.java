package de.jfpgmc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.jfpgmc.dao.IOrderDAO;
import de.jfpgmc.dto.Order;

/**
 * Implementation of the IOrderDAO. Contains methods to orders.
 * 
 * @author Martin Cremer
 * 
 */
public class OrderDAOImpl implements IOrderDAO, Serializable {

	private static final long serialVersionUID = -2810486632745318238L;
	protected EntityManager entityManager;
	
	/**
	 * Setter for the JPA entityManager.
	 * 
	 * @param entityManager the entityManager
	 */
	@PersistenceContext(unitName = "fomshop")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order createOrder(Order order) {
		entityManager.persist(order);
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order updateOrder(Order order) {
		Order updatedOrder = entityManager.merge(order);
		return updatedOrder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order findOrderById(long id) {
		return entityManager.find(Order.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> fetchOrders() {
		try {
			Query query = entityManager.createQuery("SELECT o FROM Order o");
			return query.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Order>();
		}
	}

}
