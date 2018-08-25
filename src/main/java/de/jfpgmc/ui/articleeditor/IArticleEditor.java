package de.jfpgmc.ui.articleeditor;

import de.jfpgmc.dto.Article;

/**
 * Interface of all valid methods to interact with an ArticleEditor.
 * 
 * @author Martin
 * @version $Id: $
 *
 */
public interface IArticleEditor {

	/**
	 * Open the Article for edit.
	 * 
	 * @param article the Article to edit
	 */
	public void editArticle(Article article);
}
