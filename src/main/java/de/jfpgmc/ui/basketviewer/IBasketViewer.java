package de.jfpgmc.ui.basketviewer;

import de.jfpgmc.dto.Basket;

/**
 * Interface of all valid methods to interact with a BasketViewer.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IBasketViewer {
	
	/**
	 * Show the details of a basket.
	 * 
	 * @param basket the basket to show
	 */
	public void showBasket(Basket basket);
}
