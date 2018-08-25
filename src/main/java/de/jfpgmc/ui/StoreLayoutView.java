package de.jfpgmc.ui;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

/**
 * Basic layout for the shop. It has different areas, where components can be
 * set. Makes use of the 960gs framework to position the containers.
 * 
 * @author Martin Cremer
 * 
 */
@SuppressWarnings("serial")
public class StoreLayoutView extends CustomComponent implements
		ComponentContainer {

	private CssLayout mainLayout;
	private CssLayout headerLayout;
	private CssLayout bodyLayout;
	private CssLayout footerLayout;

	private CssLayout headerArea;
	private CssLayout headerNavigationArea;
	private CssLayout menuArea;
	private CssLayout mainArea;
	private CssLayout widgetArea;
	private CssLayout footerArea;

	/**
	 * Constructor for StoreLayoutView.
	 */
	public StoreLayoutView() {
		setCompositionRoot(getMainLayout());
	}

	/**
	 * Get mainLayout, build if null.
	 * 
	 * @return the mainLayout
	 */
	private CssLayout getMainLayout() {
		if (mainLayout == null) {
			mainLayout = new CssLayout();
			mainLayout.setStyleName("mainLayout");
			mainLayout.addComponent(getHeaderLayout());
			mainLayout.addComponent(getBodyLayout());
			mainLayout.addComponent(getFooterLayout());
		}
		return mainLayout;
	}

	/**
	 * Get headerLayout, build if null.
	 * 
	 * @return the headerLayout
	 */
	private CssLayout getHeaderLayout() {
		if (headerLayout == null) {
			headerLayout = new CssLayout();
			headerLayout.setStyleName("container_12 headerLayout");
			headerLayout.addComponent(getHeaderArea());
			headerLayout.addComponent(getHeaderNavigationArea());
			headerLayout.addComponent(getMenuArea());
		}
		return headerLayout;
	}

	/**
	 * Get bodyLayout, build if null.
	 * 
	 * @return the bodyLayout
	 */
	private CssLayout getBodyLayout() {
		if (bodyLayout == null) {
			bodyLayout = new CssLayout();
			bodyLayout.setStyleName("container_12 bodyLayout");
			bodyLayout.addComponent(getMainArea());
			bodyLayout.addComponent(getWidgetArea());
		}
		return bodyLayout;
	}

	/**
	 * Get footerLayout, build if null.
	 * 
	 * @return the footerLayout
	 */
	private CssLayout getFooterLayout() {
		if (footerLayout == null) {
			footerLayout = new CssLayout();
			footerLayout.setStyleName("container_12 footerLayout");
			footerLayout.addComponent(getFooterArea());
		}
		return footerLayout;
	}

	/**
	 * Get headerArea, build if null.
	 * 
	 * @return the headerArea
	 */
	public CssLayout getHeaderArea() {
		if (headerArea == null) {
			headerArea = new CssLayout();
			headerArea.setStyleName("grid_8 headerArea");
		}
		return headerArea;
	}

	/**
	 * Get headerNavigationArea, build if null.
	 * 
	 * @return the headerNavigationArea
	 */
	public CssLayout getHeaderNavigationArea() {
		if (headerNavigationArea == null) {
			headerNavigationArea = new CssLayout();
			headerNavigationArea.setStyleName("grid_4 headerNavigationArea");
		}
		return headerNavigationArea;
	}

	/**
	 * Get menuArea, build if null.
	 * 
	 * @return the menuArea
	 */
	public CssLayout getMenuArea() {
		if (menuArea == null) {
			menuArea = new CssLayout();
			menuArea.setStyleName("grid_12 menuArea");
		}
		return menuArea;
	}

	/**
	 * Get mainArea, build if null.
	 * 
	 * @return the mainArea
	 */
	public CssLayout getMainArea() {
		if (mainArea == null) {
			mainArea = new CssLayout();
			mainArea.setStyleName("grid_8 mainArea");
		}
		return mainArea;
	}

	/**
	 * Get widgetArea, build if null.
	 * 
	 * @return the widgetArea
	 */
	public CssLayout getWidgetArea() {
		if (widgetArea == null) {
			widgetArea = new CssLayout();
			widgetArea.setStyleName("grid_4 widgetArea");
		}
		return widgetArea;
	}

	/**
	 * Get footerArea, build if null.
	 * 
	 * @return the footerArea
	 */
	public CssLayout getFooterArea() {
		if (footerArea == null) {
			footerArea = new CssLayout();
			footerArea.setStyleName("grid_12 footerArea");
		}
		return footerArea;
	}
}
