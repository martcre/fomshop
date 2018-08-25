package de.jfpgmc.ui.adminorder;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.task.Task;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * Control of AdminOrder component.
 * 
 * @author Martin Cremer
 */
public class AdminOrderControl extends CustomComponent implements IAdminOrder {

	private static final long serialVersionUID = -874065889594232454L;
	private IAdminOrderDelegate delegate;
	private AdminOrderView view;
	private AdminOrderModel model;
	private ViewDelegate viewDelegate;
	
	/**
	 * Constructor for AdminOrderControl.
	 * 
	 * @param delegate
	 */
	public AdminOrderControl(IAdminOrderDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	/**
	 * Refresh the process list.
	 */
	private void refreshProcessList() {
		List<Task> tasks = getDelegate().fetchOrderTasks();
		getModel().getTaskContainer().removeAllItems();
		getModel().getTaskContainer().addAll(tasks);
	}
	
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private AdminOrderView getView() {
		if (view == null) {
			view = new AdminOrderView();
			view.setWidth("100%");
			view.getRefreshProcessList().addListener(getViewDelegate());
			view.getTaskTable().setContainerDataSource(getModel().getTaskContainer());
			view.getTaskTable().addGeneratedColumn("action", new ColumnGenerator() {
				private static final long serialVersionUID = 5144279663419972972L;
				@Override
				public Object generateCell(Table source, Object itemId, Object columnId) {
					@SuppressWarnings("unchecked")
					final Task task = ((BeanItem<Task>)source.getItem(itemId)).getBean();
					String taskDefenitionKey = task.getTaskDefinitionKey();
					
					if (taskDefenitionKey.equals("userHandleOrder")) {
						
						/*
						 * Button to accept an order:
						 */
						Button acceptOrder = new Button(I18n.getString("ACCEPT_ORDER"));
						acceptOrder.addStyleName(ChameleonTheme.BUTTON_SMALL);
						acceptOrder.addListener(new ClickListener() {
							private static final long serialVersionUID = 979682529403660977L;
							@Override
							public void buttonClick(ClickEvent event) {
								getDelegate().processAcceptOrder(task);
								refreshProcessList();
							}
						});
						
						/*
						 * Button to reject an order:
						 */
						Button rejectOrder = new Button(I18n.getString("REJECT_ORDER"));
						rejectOrder.addStyleName(ChameleonTheme.BUTTON_SMALL);
						rejectOrder.addListener(new ClickListener() {
							private static final long serialVersionUID = -3136190890667132441L;
							@Override
							public void buttonClick(ClickEvent event) {
								getDelegate().processDeclineOrder(task);
								refreshProcessList();
							}
						});
						HorizontalLayout layout = new HorizontalLayout();
						layout.setSizeUndefined();
						layout.addComponent(acceptOrder);
						layout.addComponent(rejectOrder);
						return layout;
						
					} else if (taskDefenitionKey.equals("userPaymentPending")) {
						
						/*
						 * Button to declare an order as paid:
						 */
						Button paymentReceived = new Button(I18n.getString("PAYMENT_RECEIVED"));
						paymentReceived.addStyleName(ChameleonTheme.BUTTON_SMALL);
						paymentReceived.addListener(new ClickListener() {
							private static final long serialVersionUID = -8644086395304585264L;
							@Override
							public void buttonClick(ClickEvent event) {
								getDelegate().processPaymentOrder(task);
								refreshProcessList();
							}
						});
						return paymentReceived;
						
					} else if (taskDefenitionKey.equals("userSendOrder")) {
						
						/*
						 * Button to declare an order as sent:
						 */
						Button orderSent = new Button(I18n.getString("ORDER_SENT"));
						orderSent.addStyleName(ChameleonTheme.BUTTON_SMALL);
						orderSent.addListener(new ClickListener() {
							private static final long serialVersionUID = -1518877242699935530L;
							@Override
							public void buttonClick(ClickEvent event) {
								getDelegate().processSentOrder(task);
								refreshProcessList();
							}
						});
						return orderSent;
					}
					
					return null;
				}
			});
			view.getTaskTable().setVisibleColumns(new String[] {"name", "createTime", "action"});
			
			
			//	Initial read:
			refreshProcessList();
		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private AdminOrderModel getModel() {
		if (model == null) {
			model = new AdminOrderModel();
			model.setTaskContainer(new BeanItemContainer<Task>(Task.class));
		}
		return model;
	}
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IAdminOrderDelegate getDelegate() {
		return delegate;
	}

	/**
	 * Get viewDelegate, build if null.
	 * 
	 * @return the viewDelegate
	 */
	private ViewDelegate getViewDelegate() {
		if (viewDelegate == null) {
			viewDelegate = new ViewDelegate();
		}
		return viewDelegate;
	}
	
	/**
	 * ViewDelegate to handle User events.
	 * 
	 * @author Martin Cremer
	 */
	private class ViewDelegate implements Serializable, ClickListener {
		private static final long serialVersionUID = 1427309673734397498L;

		/**
		 * Handle Button.ClickEvents for buttons within the view.
		 */
		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton().equals(getView().getRefreshProcessList())) {
				//	Handle the refreshProcessList button:
				refreshProcessList();
			}
		}
		
	}
}
