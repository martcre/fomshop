package de.jfpgmc.ui.articleviewer;

import de.jfpgmc.dto.Article;



/**
 * Interface of all valid methods to interact with an ArticleViewer.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleViewer {

	/**
	 * Show an Article within the ArticleViewer.
	 * 
	 * @param article the article to show
	 */
	public void showArticle(Article article);
}
