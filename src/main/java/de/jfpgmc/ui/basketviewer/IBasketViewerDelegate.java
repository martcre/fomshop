package de.jfpgmc.ui.basketviewer;

import de.jfpgmc.dto.ArticleVariant;

/**
 * Interface of all methods needed by a BasketViewer.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IBasketViewerDelegate {

	/**
	 * Process change the amount of an ArticleVariant.
	 * 
	 * @param articleVariant the ArticleVariant
	 * @param newAmount the new amount
	 */
	public void processSetArticleVariantAmount(ArticleVariant articleVariant, int newAmount);
	
	/**
	 * Process order the basket.
	 */
	public void processOrderBasket();
	
	/**
	 * Process dispose the basket.
	 */
	public void processDisposeBasket();
	
	
}
