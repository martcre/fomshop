package de.jfpgmc.ui.articlecategorymenu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import de.jfpgmc.dto.Category;

/**
 * Control of ArticleCategoryMenu component.
 * 
 * @author Martin Cremer
 *
 */
public class ArticleCategoryMenuControl extends CustomComponent implements IArticleCategoryMenu {

	private static final long serialVersionUID = -3055321850289275549L;
	private IArticleCategoryMenuDelegate delegate;
	private ArticleCategoryMenuView view;
	private ArticleCategoryMenuModel model;
	private ViewDelegate viewDelegate;
	
	/**
	 * Constructor.
	 * 
	 * @param delegate
	 */
	public ArticleCategoryMenuControl(IArticleCategoryMenuDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	
	/**
	 * Get view, build if null.
	 * 
	 * TODO Child elements are not displayed
	 * 
	 * @return the view
	 */
	private ArticleCategoryMenuView getView() {
		if (view == null) {
			view = new ArticleCategoryMenuView();
			getModel().getMenuItem2category().clear();
			getModel().getCategory2menuItem().clear();
			
			List<Category> rootCategories = getDelegate().fetchRootCategories();
			Queue<Category> categoriesQueue = new LinkedList<Category>(rootCategories);
			while (!categoriesQueue.isEmpty()) {
				Category currentCategory = categoriesQueue.poll();
				if (currentCategory != null) {
					
					MenuItem currentMenuItem;
					if (currentCategory.getParentCategory() == null) {
						//	this category is a root category:
						currentMenuItem = view.getMenuBar().addItem(currentCategory.getCaption(), getViewDelegate());
						categoriesQueue.addAll(currentCategory.getChildCategories());
					} else {
						//	this category has a parent catgory:
						MenuItem parentMenuItem = getModel().getCategory2menuItem().get(currentCategory.getParentCategory());
						currentMenuItem = parentMenuItem.addItem(currentCategory.getCaption(), getViewDelegate());
					}
					
					//	remember mappings for linking children and determine event sources:
					getModel().getCategory2menuItem().put(currentCategory, currentMenuItem);
					getModel().getMenuItem2category().put(currentMenuItem, currentCategory);
				}
			}
			
		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private ArticleCategoryMenuModel getModel() {
		if (model == null) {
			model = new ArticleCategoryMenuModel();
			model.setMenuItem2category(new HashMap<MenuItem, Category>());
			model.setCategory2menuItem(new HashMap<Category, MenuItem>());
		}
		return model;
	}
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IArticleCategoryMenuDelegate getDelegate() {
		return delegate;
	}
	
	/**
	 * Get viewDelegate, build if null.
	 * 
	 * @return the viewDelegate
	 */
	public ViewDelegate getViewDelegate() {
		if (viewDelegate == null) {
			viewDelegate = new ViewDelegate();
		}
		return viewDelegate;
	}
	
	/**
	 * Handle user interaction.
	 * @author Martin Cremer
	 */
	private class ViewDelegate implements MenuBar.Command {
		private static final long serialVersionUID = -5520892419567483759L;

		/**
		 * Handle the selection of a category.
		 */
		@Override
		public void menuSelected(MenuItem selectedItem) {
			Category category = getModel().getMenuItem2category().get(selectedItem);
			
			if (category != null) {
				getDelegate().processCategorySelection(category);
			}
		}
		
	}
}
