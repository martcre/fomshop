package de.jfpgmc.ui.core;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.task.Task;

import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.adminorder.IAdminOrderDelegate;

/**
 * Delegate implementing {@link IAdminOrderDelegate}.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
public class AdminCore implements Serializable, IAdminOrderDelegate {
	private static final long serialVersionUID = 4388288255883209970L;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Task> fetchOrderTasks() {
		return FomShopApplication.getInstance().getOrderService().fetchOrderTasks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processAcceptOrder(Task task) {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getWorkflowService().processAcceptOrder(task);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processDeclineOrder(Task task) {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getWorkflowService().processDeclineOrder(task);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processPaymentOrder(Task task) {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getWorkflowService().processPaymentOrder(task);
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processSentOrder(Task task) {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getWorkflowService().processSentOrder(task);
		}
	}

}
