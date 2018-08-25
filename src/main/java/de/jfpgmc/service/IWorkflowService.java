package de.jfpgmc.service;

import java.util.List;

import org.activiti.engine.task.Task;

import de.jfpgmc.dto.Order;

/**
 * Interface of the WorkflowService.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IWorkflowService {

	
	/**
	 * Start an order process.
	 * @param order the order to start the process for
	 */
	public void startOrderProcess(Order order);

	/**
	 * Fetch a list of all current order Tasks.
	 * 
	 * @return the list of tasks for the order process
	 */
	public List<Task> fetchOrderTasks();

	/**
	 * Signal accept of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processAcceptOrder(Task task);

	/**
	 * Signal decline of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processDeclineOrder(Task task);

	/**
	 * Signal payment of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processPaymentOrder(Task task);

	/**
	 * Signal sent of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processSentOrder(Task task);

}
