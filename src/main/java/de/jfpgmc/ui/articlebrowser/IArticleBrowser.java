package de.jfpgmc.ui.articlebrowser;

import java.util.List;

import de.jfpgmc.dto.Article;

/**
 * Interface of all valid methods to interact with an ArticleBrowser.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleBrowser {

	/**
	 * Show a list of articles within the browser.
	 * 
	 * @param title the title to show
	 * @param articles the list of articles
	 */
	public void  showArticles(String title, List<Article> articles);
}
