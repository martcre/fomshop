package de.jfpgmc.ui.articlebrowser;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import de.jfpgmc.util.I18n;

/**
 * Get ArticleItemView, build if null.
 * 
 * @author Patrick Giezen
 * @return the ArticleItemView
 */

public class ArticleItemView extends CustomComponent {

	private static final long serialVersionUID = -4405265015264644848L;

	private VerticalLayout mainLayout;
	private Label title;
	private Button buttonOpen;

	/**
	 * Constructor for ArticleItemView.
	 * 
	 */

	public ArticleItemView() {
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

			mainLayout.addComponent(getTitle());

			mainLayout.addComponent(getButtonOpen());
		}
		return mainLayout;
	}

	/**
	 * Get ButtonOpen, build if null.
	 * 
	 * @return the ButtonOpen
	 */
	public Button getButtonOpen() {
		if (buttonOpen == null) {
			buttonOpen = new Button(I18n.getString("OPEN"));
		}
		return buttonOpen;
	}
	
	/**
	 * Get Title, build if null.
	 * 
	 * @return title
	 */
	public Label getTitle() {
		if (title == null) {
			title = new Label();
		}
		return title;
	}
}
