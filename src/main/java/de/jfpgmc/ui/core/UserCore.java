package de.jfpgmc.ui.core;

import java.io.Serializable;

import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.adminorder.AdminOrderControl;
import de.jfpgmc.ui.articlelisting.ArticleListingControl;
import de.jfpgmc.ui.exception.DisallowedPasswordException;
import de.jfpgmc.ui.exception.UserEmailAddressInUseException;
import de.jfpgmc.ui.exception.UserSecurityException;
import de.jfpgmc.ui.userinfo.IUserInfoDelegate;
import de.jfpgmc.ui.userregister.IUserRegisterDelegate;
import de.jfpgmc.ui.userregister.UserRegisterControl;

/**
 * Delegate implementing {@link IUserInfoDelegate}, {@link IUserInfoDelegate},
 * {@link IUserRegisterDelegate}.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
public class UserCore implements Serializable, IUserInfoDelegate, IUserRegisterDelegate {

	private static final long serialVersionUID = -8933882899705229734L;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processRegisterCustomer(Customer customer)
			throws UserEmailAddressInUseException, DisallowedPasswordException {
		FomShopApplication.getInstance().getUserService().registerCustomer(customer);		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processLogin(String email, String password)
			throws UserSecurityException {
		
		User user = FomShopApplication.getInstance().getUserService().fetchUserByEmailAndPassword(email, password);
		if (user != null && user.getPassword().equals(password)) {
			FomShopApplication.getInstance().getUserContext().initUser(user);
			FomShopApplication.getInstance().getUserContext().notifyObservers();
		} else {
			throw new UserSecurityException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processLogout() {
		FomShopApplication.getInstance().getUserContext().disposeUser();
		FomShopApplication.getInstance().getUserContext().notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processOpenRegisterUser() {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getLayoutView().getMainArea().removeAllComponents();
			FomShopApplication.getInstance().getLayoutView().getMainArea().addComponent(new UserRegisterControl(FomShopApplication.getInstance().getUserCore()));
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processOpernAdminOrder() {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getLayoutView().getMainArea().removeAllComponents();
			FomShopApplication.getInstance().getLayoutView().getMainArea().addComponent(new AdminOrderControl(FomShopApplication.getInstance().getAdminCore()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processArticleListing() {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getLayoutView().getMainArea().removeAllComponents();
			FomShopApplication.getInstance().getLayoutView().getMainArea().addComponent(new ArticleListingControl(FomShopApplication.getInstance().getArticleCore()));
		}
	}
}
