package de.jfpgmc.ui.userinfo;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of the UserInfo component.
 * 
 * @author Martin Cremer
 */
public class UserInfoView extends CustomComponent {

	private static final long serialVersionUID = 5791195733649113563L;

	private VerticalLayout mainLayout;

	private HorizontalLayout privateLayout;
	private Label userName;

	private HorizontalLayout loginLayout;
	private TextField email;
	private PasswordField password;
	private Button loginButton;

	private HorizontalLayout linkLayoutPublic;
	private Button registerButton;

	private HorizontalLayout linkLayoutPrivate;
	private Button logoutButton;

	private HorizontalLayout linkLayoutAdmin;
	private Button openAdminOrderButton;
	private Button openArticleListingButton;

	/**
	 * Constructor for UserInfoView.
	 */
	public UserInfoView() {
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
			mainLayout.setMargin(true);
			mainLayout.setSpacing(true);

			mainLayout.setWidth("100%");

			mainLayout.addComponent(getLoginLayout());
			mainLayout.addComponent(getPrivateLayout());

			mainLayout.addComponent(getLinkLayoutPublic());
			mainLayout.addComponent(getLinkLayoutPrivate());
			mainLayout.addComponent(getLinkLayoutAdmin());
		}
		return mainLayout;
	}

	/**
	 * Get linkLayoutPublic, build if null.
	 * 
	 * @return the linkLayoutPublic
	 */
	public HorizontalLayout getLinkLayoutPublic() {
		if (linkLayoutPublic == null) {
			linkLayoutPublic = new HorizontalLayout();
			linkLayoutPublic.setSpacing(true);
			linkLayoutPublic.addComponent(getRegisterButton());
			linkLayoutPublic.setWidth("100%");
		}
		return linkLayoutPublic;
	}

	/**
	 * Get registerButton, build if null.
	 * 
	 * @return the registerButton
	 */
	public Button getRegisterButton() {
		if (registerButton == null) {
			registerButton = new Button(I18n.getString("REGISTER"));
			registerButton.addStyleName(ChameleonTheme.BUTTON_LINK);
		}
		return registerButton;
	}

	/**
	 * Get loginLayout, build if null.
	 * 
	 * @return the loginLayout
	 */
	public HorizontalLayout getLoginLayout() {
		if (loginLayout == null) {
			loginLayout = new HorizontalLayout();
			loginLayout.setSpacing(true);
			loginLayout.setWidth("100%");

			loginLayout.addComponent(getEmail());
			loginLayout.addComponent(getPassword());
			loginLayout.addComponent(getLoginButton());

			loginLayout.setExpandRatio(getEmail(), 0.35f);
			loginLayout.setExpandRatio(getPassword(), 0.35f);
			loginLayout.setExpandRatio(getLoginButton(), 0.3f);

			loginLayout.setComponentAlignment(getEmail(), Alignment.TOP_LEFT);
			loginLayout
					.setComponentAlignment(getPassword(), Alignment.TOP_LEFT);
			loginLayout.setComponentAlignment(getLoginButton(),
					Alignment.TOP_LEFT);
		}
		return loginLayout;
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
	 * Get loginButton, build if null.
	 * 
	 * @return the loginButton
	 */
	public Button getLoginButton() {
		if (loginButton == null) {
			loginButton = new Button(I18n.getString("LOGIN"));
			loginButton.addStyleName(ChameleonTheme.BUTTON_SMALL);
			loginButton.setWidth("100%");
		}
		return loginButton;
	}

	/**
	 * Get privateLayout, build if null.
	 * 
	 * @return the privateLayout
	 */
	public HorizontalLayout getPrivateLayout() {
		if (privateLayout == null) {
			privateLayout = new HorizontalLayout();

			privateLayout.addComponent(getUserName());
		}
		return privateLayout;
	}

	/**
	 * Get userName, build if null.
	 * 
	 * @return the userName
	 */
	public Label getUserName() {
		if (userName == null) {
			userName = new Label();
		}
		return userName;
	}

	/**
	 * Get linkLayoutPrivate, build if null.
	 * 
	 * @return the linkLayoutPrivate
	 */
	public HorizontalLayout getLinkLayoutPrivate() {
		if (linkLayoutPrivate == null) {
			linkLayoutPrivate = new HorizontalLayout();
			linkLayoutPrivate.addComponent(getLogoutButton());
			linkLayoutPrivate.addComponent(getLogoutButton());
		}
		return linkLayoutPrivate;
	}

	/**
	 * Get logoutButton, build if null.
	 * 
	 * @return the logoutButton
	 */
	public Button getLogoutButton() {
		if (logoutButton == null) {
			logoutButton = new Button(I18n.getString("LOGOUT"));
			logoutButton.addStyleName(ChameleonTheme.BUTTON_LINK);
		}
		return logoutButton;
	}

	/**
	 * Get linkLayoutAdmin, build if null.
	 * 
	 * @return the linkLayoutAdmin
	 */
	public HorizontalLayout getLinkLayoutAdmin() {
		if (linkLayoutAdmin == null) {
			linkLayoutAdmin = new HorizontalLayout();
			linkLayoutAdmin.addComponent(getOpenAdminOrderButton());
			linkLayoutAdmin.addComponent(getOpenArticleListingButton());
		}
		return linkLayoutAdmin;
	}

	/**
	 * Get openAdminOrderButton, build if null.
	 * 
	 * @return the openAdminOrderButton
	 */
	public Button getOpenAdminOrderButton() {
		if (openAdminOrderButton == null) {
			openAdminOrderButton = new Button(
					I18n.getString("OPEN_ADMIN_ORDER"));
			openAdminOrderButton.addStyleName(ChameleonTheme.BUTTON_LINK);
		}
		return openAdminOrderButton;
	}

	/**
	 * Get OpenArticleListingButton, build if null
	 * 
	 * @return the openArticleListingButton
	 */
	public Button getOpenArticleListingButton() {
		if (openArticleListingButton == null) {
			openArticleListingButton = new Button(
					I18n.getString("OPEN_ARTICLE_LISTING"));
			openArticleListingButton.addStyleName(ChameleonTheme.BUTTON_LINK);
		}
		return openArticleListingButton;
	}
}
