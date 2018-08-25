package de.jfpgmc.dao;

import java.util.List;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.Category;

/**
 * Declares the methods of an ArticleDAO.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleDAO {

	/**
	 * Create a new category.
	 * 
	 * @param category the category to create
	 * @return the created category
	 */
	public Category create(Category category);
	
	/**
	 * Update a category.
	 * 
	 * @param category the category to update.
	 * @return the updated category
	 */
	public Category update(Category category);
	
	/**
	 * Delete a category by id.
	 * @param categoryId the id of the category to delete
	 */
	public void delete(long categoryId);
	
	/**
	 * Find all categories which does not have a parent.
	 * 
	 * @return the root categories
	 */
	public List<Category> findRootCategories();
	
	/**
	 * Find all articles within a category
	 * 
	 * @param category the category to compare with
	 * @return the articles
	 */
	public List<Article> findArticlesInCategory(Category category);

	/**
	 * Find all articles.
	 * 
	 * @return all articles
	 */
	public List<Article> findAllArticles();
	
}
