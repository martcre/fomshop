package de.jfpgmc.ui.adminorder;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of AdminOrder component.
 * 
 * @author Martin Cremer
 */
public class AdminOrderView extends CustomComponent {

	private static final long serialVersionUID = -1121079387732311208L;
	
	private VerticalLayout mainLayout;
	private Label componentTitle;
	private Table taskTable;
	private Button refreshProcessList;
	
	/**
	 * Constructor for AdminOrderView.
	 *
	 */
	public AdminOrderView() {
		setCompositionRoot(getMainLayout());
	}
	
	/**
	 * Get mainLayout, build if null.
	 * 
	 * @return the mainLayout
	 */
	private VerticalLayout getMainLayout() {
		if (mainLayout == null) {
			mainLayout = new VerticalLayout();
			mainLayout.setWidth("100%");
			mainLayout.setSpacing(true);
			
			mainLayout.addComponent(getComponentTitle());
			mainLayout.addComponent(getRefreshProcessList());
			mainLayout.addComponent(getTaskTable());
		}
		return mainLayout;
	}
	
	/**
	 * Get componentTitle, build if null.
	 * 
	 * @return the componentTitle
	 */
	public Label getComponentTitle() {
		if (componentTitle == null) {
			componentTitle = new Label();
			componentTitle.addStyleName(ChameleonTheme.LABEL_H3);
		}
		return componentTitle;
	}
	
	/**
	 * Get refreshProcessList, build if null.
	 * 
	 * @return the refreshProcessList
	 */
	public Button getRefreshProcessList() {
		if (refreshProcessList == null) {
			refreshProcessList = new Button(I18n.getString("REFRESH_PROCESS_LIST"));
		}
		return refreshProcessList;
	}
	
	/**
	 * Get taskTable, build if null.
	 * 
	 * @return the taskTable
	 */
	public Table getTaskTable() {
		if (taskTable == null) {
			taskTable = new Table();
			taskTable.setWidth("100%");
			taskTable.setHeight("300px");
			taskTable.addStyleName(ChameleonTheme.TABLE_STRIPED);
		}
		return taskTable;
	}

}
