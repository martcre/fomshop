package de.jfpgmc.ui.userinfo;

import java.util.Observable;
import java.util.Observer;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Window.Notification;

import de.jfpgmc.dto.User;
import de.jfpgmc.dto.UserRoleEnum;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.exception.UserSecurityException;
import de.jfpgmc.util.I18n;

/**
 * Control of the UserInfo component.
 * 
 * @author Martin Cremer
 */
public class UserInfoControl extends CustomComponent implements IUserInfo, Observer {

	private static final long serialVersionUID = 2941800054179841594L;
	private IUserInfoDelegate delegate;
	private UserInfoView view;
	private ViewDelegate viewDelegate;
	
	/**
	 * Constructor for UserInfoControl.
	 * 
	 * @param delegate
	 */
	public UserInfoControl(IUserInfoDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}

	/**
	 * Register to the userContext to get notified when the context changes.
	 */
	@Override
	public void attach() {
		FomShopApplication.getInstance().getUserContext().addObserver(this);
		super.attach();
	}

	/**
	 * Unregister from the context as this component will be removed from the view.
	 */
	@Override
	public void detach() {
		super.detach();
		FomShopApplication.getInstance().getUserContext().deleteObserver(this);
	}
	
	/**
	 * Listen to context changes. When the user is null, offer a login and public options, when user
	 * is not null, show name and offer logout.
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o.equals(FomShopApplication.getInstance().getUserContext())) {
			handleContextMode();
		}
	}
	
	/**
	 * If the user is null, offer login, if not null, offer logout.
	 */
	private void handleContextMode() {
		User user = FomShopApplication.getInstance().getUserContext().getUser();
		if (user == null) {
			//	Public Setup:
			getView().getLoginLayout().setVisible(true);
			getView().getPrivateLayout().setVisible(false);
			getView().getUserName().setValue("");
			getView().getLinkLayoutPrivate().setVisible(false);
			getView().getLinkLayoutPublic().setVisible(true);
			getView().getEmail().setValue("");
			getView().getPassword().setValue("");
			getView().getLinkLayoutAdmin().setVisible(false);
		} else {
			//	Private Setup:
			getView().getLoginLayout().setVisible(false);
			getView().getPrivateLayout().setVisible(true);
			getView().getLinkLayoutPrivate().setVisible(true);
			
			if (user.getUserRoleEnum().equals(UserRoleEnum.ADMINISTRATOR)) {
				getView().getLinkLayoutAdmin().setVisible(true);
			} else {
				getView().getLinkLayoutAdmin().setVisible(false);
			}
			
			getView().getLinkLayoutPublic().setVisible(false);
			getView().getUserName().setValue(I18n.getString("WELCOME") + " " + user.getAlias());
		}
	}
	
		
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IUserInfoDelegate getDelegate() {
		return delegate;
	}
	
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private UserInfoView getView() {
		if (view == null) {
			view = new UserInfoView();
			view.setWidth("100%");
			view.getRegisterButton().addListener(getViewDelegate());
			view.getLoginButton().addListener(getViewDelegate());
			view.getLogoutButton().addListener(getViewDelegate());
			view.getOpenAdminOrderButton().addListener(getViewDelegate());
			view.getOpenArticleListingButton().addListener(getViewDelegate());			
			handleContextMode();
		}
		return view;
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
	
	private class ViewDelegate implements Button.ClickListener {
		private static final long serialVersionUID = 5112004721056874348L;

		/**
		 * Handle all user interactions from buttons.
		 */
		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton().equals(getView().getRegisterButton())) {
				getDelegate().processOpenRegisterUser();
			} else if (event.getButton().equals(getView().getLoginButton())) {
				String email = (String) getView().getEmail().getValue();
				String password = (String) getView().getPassword().getValue();

				try {
					getDelegate().processLogin(email, password);
				} catch (UserSecurityException e) {
					FomShopApplication
							.getInstance()
							.getMainWindow()
							.showNotification(
									I18n.getString("USER_SECURITY_EXCEPTION_TITLE"),
									Notification.TYPE_WARNING_MESSAGE);
				}
			} else if (event.getButton().equals(getView().getLogoutButton())) {
				getDelegate().processLogout();
			} else if (event.getButton().equals(getView().getOpenAdminOrderButton())) {
				getDelegate().processOpernAdminOrder();
			} else if (event.getButton().equals(getView().getOpenArticleListingButton())) {
				getDelegate().processArticleListing();
			}
		}
	}




}
