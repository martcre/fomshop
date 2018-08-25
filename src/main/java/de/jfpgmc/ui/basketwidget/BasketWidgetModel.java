package de.jfpgmc.ui.basketwidget;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

import de.jfpgmc.dto.BasketEntry;

/**
 * Model of BasketWidget component.
 * 
 * @author Patrick Giezen
 *
 */
public class BasketWidgetModel implements Serializable {

	private static final long serialVersionUID = -6707731609980960182L;

	private BeanItemContainer<BasketEntry> basketContainer;

	/**
	 * Gets the basketContainer
	 * 
	 * @return the basketContainer
	 */
	public BeanItemContainer<BasketEntry> getBasketContainer() {
		return basketContainer;
	}

	/**
	 * Sets the basketcontainer
	 * 
	 * @param basketContainer
	 *            the basketContainer to set
	 */
	public void setBasketContainer(
			BeanItemContainer<BasketEntry> basketContainer) {
		this.basketContainer = basketContainer;
	}

}
