package de.jfpgmc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.transaction.annotation.Transactional;

import de.jfpgmc.dao.IOrderDAO;
import de.jfpgmc.dto.Order;
import de.jfpgmc.service.IOrderService;
import de.jfpgmc.service.IWorkflowService;

/**
 * Implementation of the OrderService.
 * 
 * @author Martin Cremer
 *
 */
public class OrderServiceImpl implements Serializable, IOrderService {

	private static final long serialVersionUID = 428844625581483234L;
	/**
	 * Injected by spring.
	 */
	private IOrderDAO orderDAO;
	/**
	 * Injected by spring
	 */
	private IWorkflowService workflowService;
	
	/**
	 * Create the order in the database and start the ordering process within the workflow engine.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void createAndSubmitOrder(Order order) {
		Order createdOrder = orderDAO.createOrder(order);
		workflowService.startOrderProcess(createdOrder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Task> fetchOrderTasks() {
		return workflowService.fetchOrderTasks();
	}

	/**
	 * Set workflowService.
	 * 
	 * @param workflowService the workflowService to set
	 */
	public void setWorkflowService(IWorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	
	/**
	 * Set orderDAO.
	 * 
	 * @param orderDAO the orderDAO to set
	 */
	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
}
