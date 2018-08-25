package de.jfpgmc.dao;

import java.util.List;

import de.jfpgmc.dto.Order;

/**
 * Declares the methods of an OrderDAO.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 *
 */
public interface IOrderDAO {
	
	/**
	 * Create a new order.
	 * 
	 * @param order the order to create
	 * @return the created order
	 */

	public Order createOrder(Order order);
	
	/**
	 * Update an order
	 * 
	 * @param order the order to update
	 * @return the updated order
	 */
	
	public Order updateOrder(Order order);
	
	/**
	 * Find an order by Id
	 * 
	 * @param id Find the prder by Id
	 * @return the order
	 */
	
	public Order findOrderById(long id);
	
	/**
	 * Find all orders.
	 * 
	 * @return all orders
	 */

	public List<Order> fetchOrders();
}
