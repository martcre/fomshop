package de.jfpgmc.ui.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import de.jfpgmc.dto.Basket;
import de.jfpgmc.dto.BasketEntry;

/**
 * BasketContext contains the current basket.
 * 
 * @author Martin Cremer
 */
public class BasketContext extends Observable implements Serializable{
	private static final long serialVersionUID = -1665989636760773628L;
	private Basket basket;

	/**
	 * Constructor for BasketContext.
	 */
	public BasketContext() {
		basket = new Basket();
		basket.setBasketEntries(new ArrayList<BasketEntry>());
	}
	
	/**
	 * Trigger that the basket has changed.
	 */
	public void basketUpdated() {
		setChanged();
	}
	
	/**
	 * Get basket.
	 * 
	 * @return the basket
	 */
	public Basket getBasket() {
		return basket;
	}
}
