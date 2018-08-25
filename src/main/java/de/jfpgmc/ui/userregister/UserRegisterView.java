package de.jfpgmc.ui.userregister;

import com.vaadin.data.Item;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of the UserRegister component.
 * 
 * @author Patrick Giezen
 *
 */
public class UserRegisterView extends CustomComponent {

	private static final long serialVersionUID = -9037530900140687722L;
	private VerticalLayout mainLayout;
	private Form userRegisterForm;
	
	private Button buttonResetForm;
	private Button buttonRegister;
	private static final String COMMON_FIELD_WIDTH = "12em";
	private static final String COMMON_SHORTFIELD_WIDTH = "6em";
	
	/**
	 * Constructor for UserRegisterView.
	 *
	 */
	public UserRegisterView() {
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
			
			Label title = new Label(I18n.getString("USER_REGISTER_TITLE"));
			title.addStyleName(ChameleonTheme.LABEL_H1);
			
			mainLayout.addComponent(title);
			
			mainLayout.addComponent(getUserRegisterForm());
		}
		return mainLayout;
	}
	
	/**
	 * Get userRegisterForm, build if null.
	 * 
	 * @return the userRegisterForm
	 */
	public Form getUserRegisterForm() {
		if (userRegisterForm == null) {
			userRegisterForm = new Form();
			userRegisterForm.setWriteThrough(false);
			userRegisterForm.setImmediate(false);
			
			userRegisterForm.setFormFieldFactory(new UserRegisterFieldFactory());
			
			userRegisterForm.getFooter().addComponent(getButtonResetForm());
			userRegisterForm.getFooter().addComponent(getButtonRegister());
		}
		return userRegisterForm;
	}
	

	/**
	 * Get buttonRegister, build if null.
	 * 
	 * @return the buttonRegister
	 */
	public Button getButtonRegister() {
		if (buttonRegister == null) {
			buttonRegister = new Button(I18n.getString("REGISTER"));
		}
		return buttonRegister;
	}
	
	/**
	 * Get buttonResetForm, build if null.
	 * 
	 * @return the buttonResetForm
	 */
	public Button getButtonResetForm() {
		if (buttonResetForm == null) {
			buttonResetForm = new Button(I18n.getString("RESET"));
		}
		return buttonResetForm;
	}
	
	/**
	 * Factory to create the fields for the UserRegister Form.
	 *
	 *
	 */
	private class UserRegisterFieldFactory extends DefaultFieldFactory {
		private static final long serialVersionUID = 1442361353857233081L;

		@Override
		public Field createField(Item item, Object propertyId,
				Component uiContext) {
			Field field;
			/**
			 * defines textfields with validators
			 */
			if("firstName".equals(propertyId)) {
				TextField tf = new TextField();
                tf.setRequired(true);
                tf.setRequiredError("Vorname");
                tf.setWidth(COMMON_FIELD_WIDTH);
                tf.addValidator(new StringLengthValidator(
                        "First Name must be 3-25 characters", 3, 25, false));
                field = tf;
            } else if ("lastName".equals(propertyId)) {
				TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("Nachname");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "Last Name must be 3-50 characters", 3, 50, false));
	            field = tf;
        	} else if ("email".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("eMail Adresse");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "email must be 6-50 characters", 6, 50, false));
	            field = tf;
	            /**
				 * defines passwordfields with validators
				 */
        	} else if ("password".equals(propertyId)) {
                PasswordField pf = new PasswordField();
                pf.setRequired(true);
                pf.setRequiredError("Passwort (mind. 6 Zeichen)");
                pf.setWidth(COMMON_FIELD_WIDTH);
                pf.addValidator(new StringLengthValidator(
                        "Password must be 6-20 characters", 6, 20, false));
                field = pf;
        	} else if ("passwordChallenge".equals(propertyId)) {
                PasswordField pf = new PasswordField();
                pf.setRequired(true);
                pf.setRequiredError("Passwort wiederholen");
                pf.setWidth(COMMON_FIELD_WIDTH);
                pf.addValidator(new StringLengthValidator(
                        "Password must be 6-20 characters", 6, 20, false));
                field = pf;
            	/**
    			 * defines textfields with validators
    			 */
        	} else if ("street".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("Straße");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "street must be 2-50 characters", 2, 50, false));
	            field = tf;
        	} else if ("zipCode".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("Postleitzahl");
	            tf.setWidth(COMMON_SHORTFIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "zipCode must be 5 characters", 5, 5, false));
	            field = tf;
        	} else if ("city".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("Stadt");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "city must be 2-20 characters", 2, 20, false));   
	            field = tf;
        	} else if ("country".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequired(true);
	            tf.setRequiredError("Land");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "country must be 2-20 characters", 2, 20, false));
	            field = tf;
        	} else if ("phone".equals(propertyId)) {
	            TextField tf = new TextField();
	            tf.setRequiredError("Telefonnummer");
	            tf.setWidth(COMMON_FIELD_WIDTH);
	            tf.addValidator(new StringLengthValidator(
                    "phone must be 3-20 characters", 3, 20, false));
	            field = tf;
        	} else {
        		field = super.createField(item, propertyId, uiContext);
        	}
			
			field.setCaption(I18n.getString((String) propertyId));
			
			if (field.getClass().isAssignableFrom(TextField.class)
					|| field.getClass().isAssignableFrom(PasswordField.class)) {
				((AbstractTextField) field).setNullRepresentation("");
			}
			
			return field;
		}
	}
}
