package de.jfpgmc.ui.articleeditor;

import de.jfpgmc.dto.Article;

/**
 * Interface of all methods needed by an ArticleEditor.
 * 
 * @author Martin
 * @version $Id: $
 *
 */
public interface IArticleEditorDelegate {

	/**
	 * Process update of the article.
	 * 
	 * @param article the article
	 */
	public void processUpdateArticle(Article article);
}
