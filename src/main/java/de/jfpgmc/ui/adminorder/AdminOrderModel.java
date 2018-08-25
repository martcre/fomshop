package de.jfpgmc.ui.adminorder;

import java.io.Serializable;

import org.activiti.engine.task.Task;

import com.vaadin.data.util.BeanItemContainer;

/**
 * Model of AdminOrder component.
 * 
 * @author Martin Cremer
 *
 */
public class AdminOrderModel implements Serializable {
	private static final long serialVersionUID = 8743578206409357324L;
	private BeanItemContainer<Task> taskContainer;

	/**
	 * Get taskContainer.
	 * 
	 * @return the taskContainer
	 */
	public BeanItemContainer<Task> getTaskContainer() {
		return taskContainer;
	}

	/**
	 * Set taskContainer.
	 * 
	 * @param taskContainer the taskContainer to set
	 */
	public void setTaskContainer(BeanItemContainer<Task> taskContainer) {
		this.taskContainer = taskContainer;
	}
}
