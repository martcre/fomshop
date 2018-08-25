package de.jfpgmc.service;

import java.util.List;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.Category;

/**
 * Interface of the ArticleService.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
public interface IArticleService {
	
	/**
	 * Find all root categories.
	 * 
	 * @return the list of root categories.
	 */
	public List<Category> findRootCategories();
	

	/**
	 * Find all articles for a category.
	 * 
	 * @param category the category to compare with
	 * @return the list of articles
	 */
	public List<Article> findArticlesInCategory(Category category);


	/**
	 * Find all articles.
	 * 
	 * @return the list of articles
	 */
	public List<Article> findAllArticles();
	
}
