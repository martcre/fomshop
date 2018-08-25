package de.jfpgmc.ui.userregister;

import java.io.Serializable;

import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Window.Notification;

import de.jfpgmc.dto.Customer;
import de.jfpgmc.dto.User;
import de.jfpgmc.dto.UserRoleEnum;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.exception.DisallowedPasswordException;
import de.jfpgmc.ui.exception.NoPasswordMatchException;
import de.jfpgmc.ui.exception.UserEmailAddressInUseException;
import de.jfpgmc.util.I18n;

/**
 * Control of the UserRegister component.
 * 
 * @author Patrick Giezen
 *
 */
public class UserRegisterControl extends CustomComponent implements IUserRegister {

	private static final long serialVersionUID = 8968058592906708721L;
	private IUserRegisterDelegate delegate;
	private UserRegisterView view;
	private ViewDelegate viewDelegate;
	private BeanItem<UserRegisterModel> model;
	
	/**
	 * Constructor for UserRegisterControl.
	 * 
	 * @param delegate the delegate
	 */
	public UserRegisterControl(IUserRegisterDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private UserRegisterView getView() {
		if (view == null) {
			view = new UserRegisterView();
			//Determines which properties are shown, and in which order:
			  /**
			   *  TODO order set
			   */
			view.getUserRegisterForm().setItemDataSource(getModel());
		    view.getUserRegisterForm().setVisibleItemProperties(new Object[] {
		            "firstName", "lastName", "email", "password", "passwordChallenge", 
		            "street", "zipCode", "city", "country", "phone"});
			view.getButtonRegister().addListener(getViewDelegate());
			view.getButtonResetForm().addListener(getViewDelegate());
			view.getUserRegisterForm().setItemDataSource(getModel());
			
			

		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private BeanItem<UserRegisterModel> getModel() {
		if (model == null) {
			model = new BeanItem<UserRegisterModel>(new UserRegisterModel());
		}
		return model;
	}
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IUserRegisterDelegate getDelegate() {
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
	 * Process registration of an user.
	 * 
	 * @throws DisallowedPasswordException 
	 * @throws UserEmailAddressInUseException 
	 */
	private void processRegisterUser() {
		String firstName = (String) getModel().getItemProperty("firstName").getValue();
		String lastName = (String) getModel().getItemProperty("lastName").getValue();
		String email = (String) getModel().getItemProperty("email").getValue();
		String password = (String) getModel().getItemProperty("password").getValue();
		String passwordChallenge = (String) getModel().getItemProperty("passwordChallenge").getValue();
		String city = (String) getModel().getItemProperty("city").getValue();;
		String country = (String) getModel().getItemProperty("country").getValue();;
		String phone = (String) getModel().getItemProperty("phone").getValue();;
		String street = (String) getModel().getItemProperty("street").getValue();;
		String zipCode = (String) getModel().getItemProperty("zipCode").getValue();;
		
		User newUser = new User();
		newUser.setAlias(email);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setUserRoleEnum(UserRoleEnum.CUSTOMER);
		
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUser(newUser);
		customer.setCity(city);
		customer.setCountry(country);
		customer.setPhone(phone);
		customer.setStreet(street);
		customer.setZipCode(zipCode);
		/**
		 * throw exception, if password and passwordChallenge don´t match
		 */
		try {
			if (!password.equals(passwordChallenge)){
				throw new NoPasswordMatchException();
			}
			getDelegate().processRegisterCustomer(customer);
			/**
			 * displays feedback in the lower right corner for successful registration 
			 */
			FomShopApplication.getInstance().getMainWindow().showNotification("REGISTRATION_SUCCESS", Notification.TYPE_TRAY_NOTIFICATION);
		} catch (UserEmailAddressInUseException e) {
			getView().getUserRegisterForm().setComponentError(new UserError(I18n.getString(e.getClass().getName())));
		} catch (DisallowedPasswordException e) {
			getView().getUserRegisterForm().setComponentError(new UserError(I18n.getString(e.getClass().getName())));
		} catch (NoPasswordMatchException e) {
			getView().getUserRegisterForm().setComponentError(new UserError(I18n.getString(e.getClass().getName())));
		}
	}
	
	/**
	 * ViewDelegate to handle user interaction.
	 * 
	 * @author Martin
	 * @version $Id: $
	 *
	 */
	private class ViewDelegate implements Button.ClickListener, Serializable {
		private static final long serialVersionUID = -5227992359170767255L;

		/**
		 * Handle button clicks.
		 * 
		 * {@inheritDoc}
		 */
		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton().equals(getView().getButtonRegister())) {
				getView().getUserRegisterForm().commit();
				processRegisterUser();
			} else if (event.getButton().equals(getView().getButtonResetForm())) {
				getModel().getItemProperty("email").setValue(null);
				getModel().getItemProperty("password").setValue(null);
				getModel().getItemProperty("passwordChallenge").setValue(null);
				getModel().getItemProperty("firstName").setValue(null);
				getModel().getItemProperty("lastName").setValue(null);
				getModel().getItemProperty("city").setValue(null);
				getModel().getItemProperty("country").setValue(null);
				getModel().getItemProperty("phone").setValue(null);
				getModel().getItemProperty("street").setValue(null);
				getModel().getItemProperty("zipCode").setValue(null);
				getView().getUserRegisterForm().discard();
			}
		}
		
	}
}
