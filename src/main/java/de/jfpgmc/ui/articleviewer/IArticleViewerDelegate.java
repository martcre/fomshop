package de.jfpgmc.ui.articleviewer;

import de.jfpgmc.dto.ArticleVariant;

/**
 * Interface of all methods needed by an ArticleViewer.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleViewerDelegate {
	
	/**
	 * Process choosing an article variant with a specific amount.
	 * 
	 * @param articleVariant the article variant
	 * @param amount the amount
	 */
	public void processChooseArticleVariant(ArticleVariant articleVariant, int amount);
	
}
