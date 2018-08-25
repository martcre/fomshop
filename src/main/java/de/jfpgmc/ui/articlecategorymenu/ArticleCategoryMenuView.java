package de.jfpgmc.ui.articlecategorymenu;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;

/**
 * View of ArticleCategoryMenu component.
 * 
 * @author Martin Cremer
 */
public class ArticleCategoryMenuView extends CustomComponent {

	private static final long serialVersionUID = 2110451082531008782L;
	private MenuBar menuBar;
	
	/**
	 * Constructor.
	 */
	public ArticleCategoryMenuView() {
		setCompositionRoot(getMenuBar());
	}
	
	/**
	 * Get menuBar, build if null.
	 * 
	 * @return the menuBar
	 */
	public MenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new MenuBar();
		}
		return menuBar;
	}
}
