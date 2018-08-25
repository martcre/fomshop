package de.jfpgmc.service.impl;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.transaction.annotation.Transactional;

import de.jfpgmc.dto.Order;
import de.jfpgmc.service.IWorkflowService;

/**
 * Implementation of the WorkflowService.
 * 
 * @author Martin Cremer
 * 
 */
public class WorkflowServiceImpl implements IWorkflowService {

	private static final String ORDER_ID = "ORDER_ID";
	private static final String PROCESS_KEY = "Fomshoporder";
	private static final String DECISION_ACCEPT_ORDER = "DECISION_ACCEPT_ORDER";

	/**
	 * Injected by spring.
	 */
	private RuntimeService runtimeService;
	/**
	 * Injected by spring
	 */
	private TaskService taskService;

	/**
	 * Start the ordering process for the specified order.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void startOrderProcess(Order order) {
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey(PROCESS_KEY);
		runtimeService.setVariable(processInstance.getId(), ORDER_ID,
				order.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Task> fetchOrderTasks() {
		return taskService.createTaskQuery().processDefinitionKey(PROCESS_KEY)
				.list();
	}

	/**
	 * Set the decision variable to true and complete the task.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void processAcceptOrder(Task task) {
		runtimeService.setVariable(task.getExecutionId(),
				DECISION_ACCEPT_ORDER, true);
		taskService.complete(task.getId());
	}

	/**
	 * Set the decision variable to false and complete the task.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void processDeclineOrder(Task task) {
		runtimeService.setVariable(task.getExecutionId(),
				DECISION_ACCEPT_ORDER, false);
		taskService.complete(task.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processPaymentOrder(Task task) {
		taskService.complete(task.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processSentOrder(Task task) {
		taskService.complete(task.getId());
	}

	/**
	 * Set runtimeService.
	 * 
	 * @param runtimeService
	 *            the runtimeService to set
	 */
	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	/**
	 * Set taskService.
	 * 
	 * @param taskService
	 *            the taskService to set
	 */
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
}
