package de.jfpgmc.ui.basketwidget;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of BasketWidget component.
 * 
 * @author Patrick Giezen
 *
 */

public class BasketWidgetView extends CustomComponent {

	private static final long serialVersionUID = -1189702496711824819L;
	private VerticalLayout mainLayout;
	private Label title;
	private Table basket;
	private Button openBasketViewer;
	
	/**
	 * Constructor for BasketWidgetView.
	 *
	 */
	public BasketWidgetView() {
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
			mainLayout.addComponent(getTitle());
			mainLayout.addComponent(getOpenBasketViewer());
			mainLayout.addComponent(getBasket());
		}
		return mainLayout;
	}
	
	/**
	 * Gets the title for the Basket Widget
	 * 
	 * @return the title
	 */
	private Label getTitle() {
		if (title == null) {
			title = new Label(I18n.getString("BASKET_WIDGET"));
			title.addStyleName(ChameleonTheme.LABEL_H3);
		}
		return title;
	}
	
	/**
	 * Get basket, build if null.
	 * 
	 * @return the basket
	 */
	public Table getBasket() {
		if (basket == null) {
			basket = new Table();
			basket.setWidth("100%");
		}
		return basket;
	}
	
	/**
	 * Get openBasketViewer, build if null.
	 * 
	 * @return the openBasketViewer
	 */
	public Button getOpenBasketViewer() {
		if (openBasketViewer == null) {
			openBasketViewer = new Button(I18n.getString("OPEN_BASKET_VIEWER"));
			openBasketViewer.addStyleName(ChameleonTheme.BUTTON_LINK);
		}
		return openBasketViewer;
	}
}
