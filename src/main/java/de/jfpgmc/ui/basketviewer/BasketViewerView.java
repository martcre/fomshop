package de.jfpgmc.ui.basketviewer;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of BasketViewer component.
 * 
 * @author Patrick Giezen
 *
 */
public class BasketViewerView extends CustomComponent {

	private static final long serialVersionUID = 6496798004118145138L;

	private VerticalLayout mainLayout;
	private Table basket;
	private Button orderButton;
	private Button disposeButton;
	private TextField email;
	private PasswordField password;
	
	/**
	 * Constructor for BasketViewerView.
	 * 
	 */
	public BasketViewerView() {
		setCompositionRoot(getMainLayout());
	}
	
	/**
	 * Get mainLayout, build if null
	 * 
	 * @return the mainLayout
	 */
	private VerticalLayout getMainLayout() {
		if (mainLayout == null) {
			mainLayout = new VerticalLayout();
			mainLayout.setSpacing(true);
			
			Label title = new Label(I18n.getString("WARENKORB"));
			title.addStyleName(ChameleonTheme.LABEL_H3);
			mainLayout.addComponent(title);
			mainLayout.addComponent(getBasket());
			mainLayout.addComponent(getOrderButton());
			mainLayout.addComponent(getDisposeButton());
		}
		return mainLayout;
	}
	
	/**
	 * Get basket, build if null
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
	 * Get email, build if null.
	 * 
	 * @return the email
	 */
	public TextField getEmail() {
		if (email == null) {
			email = new TextField();
			email.setWidth("100%");
			email.setNullRepresentation("");
			email.setInputPrompt(I18n.getString("USER"));
		}
		return email;
	}
	
	/**
	 * Get password, build if null.
	 * 
	 * @return the password
	 */
	public PasswordField getPassword() {
		if (password == null) {
			password = new PasswordField();
			password.setWidth("100%");
			password.setNullRepresentation("");
			password.setInputPrompt(I18n.getString("PASSWORD"));
		}
		return password;
	}
	
	/**
	 * Get the orderButton, build if null.
	 * 
	 * @return the orderButton
	 */
	public Button getOrderButton() {
		if (orderButton == null) {
			orderButton = new Button(I18n.getString("ORDER"));
		}
		return orderButton;
	}
	
	/**
	 * Get the disposeButton, build if null.
	 * 
	 * @return the disposeButton
	 */
	public Button getDisposeButton() {
		if (disposeButton == null) {
			disposeButton = new Button(I18n.getString("DISPOSE"));
		}
		return disposeButton;
	}
}
