package de.jfpgmc.ui.adminorder;

import java.util.List;

import org.activiti.engine.task.Task;

/**
 * Interface of all methods needed by an AdminOrder.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IAdminOrderDelegate {

	/**
	 * Process the acceptance of an order.
	 * 
	 * @param task the corresponding task.
	 */
	public void processAcceptOrder(Task task);
	
	/**
	 * Process the rejection of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processDeclineOrder(Task task);
	
	/**
	 * Process the payment of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processPaymentOrder(Task task);
	
	/**
	 * Process the sent of an order.
	 * 
	 * @param task the corresponding task
	 */
	public void processSentOrder(Task task);
	
	/**
	 * Fetch all ordering tasks.
	 * 
	 * @return the list of order tasks
	 */
	public List<Task> fetchOrderTasks();
}
