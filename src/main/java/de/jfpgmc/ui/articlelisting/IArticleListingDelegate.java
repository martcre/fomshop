package de.jfpgmc.ui.articlelisting;

import java.util.List;

import de.jfpgmc.dto.Article;

/**
 * Interface of all methods needed by an ArticleListing.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleListingDelegate {

	
	/**
	 * Process edit the Article.
	 * 
	 * @param article the Article
	 */
	public void processEditArticle(Article article);
	
	/**
	 * Process to create a new Article.
	 */
	public void processCreateArticle();
	
	/**
	 * Process to delete the Article.
	 * 
	 * @param article the Article
	 */
	public void processDeleteArticle(Article article);
	
	/**
	 * Fetch articles
	 * 
	 * @return the articles
	 */
	public List<Article> fetchArticles();
}
