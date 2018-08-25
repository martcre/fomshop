package de.jfpgmc.ui.articlecategorymenu;

import java.io.Serializable;
import java.util.Map;

import com.vaadin.ui.MenuBar.MenuItem;

import de.jfpgmc.dto.Category;

/**
 * Model for ArticleCategoryMenu component.
 * 
 * @author Martin Cremer
 */
public class ArticleCategoryMenuModel implements Serializable {
	private static final long serialVersionUID = -7492694560780056133L;
	private Map<MenuItem, Category> menuItem2category;
	private Map<Category, MenuItem> category2menuItem;

	/**
	 * Get category2menuItem.
	 * 
	 * @return the category2menuItem
	 */
	public Map<Category, MenuItem> getCategory2menuItem() {
		return category2menuItem;
	}

	/**
	 * Set category2menuItem.
	 * 
	 * @param category2menuItem
	 *            the category2menuItem to set
	 */
	public void setCategory2menuItem(Map<Category, MenuItem> category2menuItem) {
		this.category2menuItem = category2menuItem;
	}

	/**
	 * Get menuItem2category.
	 * 
	 * @return the menuItem2category
	 */
	public Map<MenuItem, Category> getMenuItem2category() {
		return menuItem2category;
	}

	/**
	 * Set menuItem2category.
	 * 
	 * @param menuItem2category
	 *            the menuItem2category to set
	 */
	public void setMenuItem2category(Map<MenuItem, Category> menuItem2category) {
		this.menuItem2category = menuItem2category;
	}

}
