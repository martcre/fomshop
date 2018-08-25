package de.jfpgmc.service;

import java.util.List;

import org.activiti.engine.task.Task;

import de.jfpgmc.dto.Order;

/**
 * Interface of the OrderService.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IOrderService {

	/**
	 * Create the Order order and start the order process.
	 * 
	 * @param order the order to create and submit
	 */
	public void createAndSubmitOrder(Order order);

	/**
	 * Fetch a list of all order tasks.
	 * 
	 * @return the list of order tasks
	 */
	public List<Task> fetchOrderTasks();
	
}
