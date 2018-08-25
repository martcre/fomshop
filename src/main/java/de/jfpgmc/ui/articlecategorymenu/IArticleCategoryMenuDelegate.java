package de.jfpgmc.ui.articlecategorymenu;

import java.util.List;

import de.jfpgmc.dto.Category;

/**
 * Interface of all methods needed by an ArticleCategoryMenu.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public interface IArticleCategoryMenuDelegate {
	
	/**
	 * Process the selection of a category.
	 * 
	 * @param category the selected category
	 */
	public void processCategorySelection(Category category);
	
	/**
	 * Fetch a list of all root categories which shall be shown within the ArticleCategoryMenu.
	 * 
	 * @return the list of root categories
	 */
	public List<Category> fetchRootCategories();
	
}
