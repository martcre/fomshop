package de.jfpgmc.ui.articlebrowser;

import de.jfpgmc.dto.Article;

/**
 * Interface of all methods needed by an ArticleBrowser.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleBrowserDelegate {

	/**
	 * Process the selection of an article.
	 * 
	 * @param article the article
	 */
	public void processArticleSelection(Article article);
}
