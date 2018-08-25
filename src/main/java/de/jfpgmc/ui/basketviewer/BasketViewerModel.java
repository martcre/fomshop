package de.jfpgmc.ui.basketviewer;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

import de.jfpgmc.dto.BasketEntry;

/**
 * Model of BasketViewer component.
 * 
 * @author Patrick Giezen
 *
 */

public class BasketViewerModel implements Serializable {

	private static final long serialVersionUID = -9052788871181825409L;

	private BeanItemContainer<BasketEntry> basketContainer;

	/**
	 * Get the BasketContainer
	 * 
	 * @return the basketContainer
	 */
	public BeanItemContainer<BasketEntry> getBasketContainer() {
		return basketContainer;
	}

	/**
	 * Set the basketContainer
	 * 
	 * @param basketContainer
	 *            the basketContainer to set
	 */
	public void setBasketContainer(
			BeanItemContainer<BasketEntry> basketContainer) {
		this.basketContainer = basketContainer;
	}
}
