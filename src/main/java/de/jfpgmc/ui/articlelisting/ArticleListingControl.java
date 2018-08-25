package de.jfpgmc.ui.articlelisting;

import java.io.Serializable;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.ArticleVariant;
import de.jfpgmc.util.I18n;

/**
 * Control of ArticleListing component.
 * 
 * @author Patrick Giezen
 *
 */
public class ArticleListingControl extends CustomComponent implements IArticleListing{

	private static final long serialVersionUID = 3701386046633029367L;
	private IArticleListingDelegate delegate;
	private ArticleListingView view;
	private ArticleListingModel model;
	private ViewDelegate viewDelegate;
		
	/**
	 * Constructor for ArticleListingControl
	 * 
	 * @param delegate
	 */
		public ArticleListingControl(IArticleListingDelegate delegate) {
			this.delegate = delegate;
			setCompositionRoot(getView());
	}

	/**
	 * Refresh the article list.
	 */
	private void refreshProcessList() {
			List<Article> articles = getDelegate().fetchArticles();
			getModel().getArticleContainer().removeAllItems();
			getModel().getArticleVariantContainer().removeAllItems();
			getModel().getArticleContainer().addAll(articles);
		}	
		
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private ArticleListingView getView() {
		if (view == null) {
			view = new ArticleListingView();
			view.setWidth("100%");
			
			view.getArticleTable().setContainerDataSource(getModel().getArticleContainer());

			
			
			
			view.getArticleVariants().setContainerDataSource(getModel().getArticleVariantContainer());
			
			
			view.getArticleVariants().addGeneratedColumn("deletearticle",
					new Table.ColumnGenerator() {
						private static final long serialVersionUID = -1072294692208417980L;

						@Override
						public Object generateCell(Table source, Object itemId,
								Object columnId) {
							// final Item articleVariantItem =
							// source.getItem(itemId);
							final Button delete = new Button(I18n
									.getString("DELETE_ARTICLE"));
							delete.setDisableOnClick(true);
							delete.addListener(new Button.ClickListener() {
								private static final long serialVersionUID = -6195868714158167987L;

								@Override
								public void buttonClick(ClickEvent event) {
									/**
									 * ArticleVariant articleVariant =
									 * ((BeanItem<ArticleVariant>)
									 * articleVariantItem).getBean();
									 * getViewDelegate
									 * ().processdeletearticle(articleVariant,
									 * 1); delete.setEnabled(true);
									 */
								}
							});
							return delete;
						}
					});


			view.getRefreshProcessList().addListener(getViewDelegate());

			// Initial read:
			refreshProcessList();
		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private ArticleListingModel getModel() {
		if (model == null) {
			model = new ArticleListingModel();
			model.setArticleContainer(new BeanItemContainer<Article>(Article.class));
			model.setArticleVariantContainer(new BeanItemContainer<ArticleVariant>(ArticleVariant.class));
		}
		return model;
	}
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IArticleListingDelegate getDelegate() {
		return delegate;
	}

	/**
	 * Get viewDelegate, build if null.
	 * 
	 * @return the viewDelegate
	 */
	private ViewDelegate getViewDelegate() {
		if (viewDelegate == null) {
			viewDelegate = new ViewDelegate();
		}
		return viewDelegate;
	}
	
	/**
	 * ViewDelegate to handle User events.
	 * 
	 *
	 */
	private class ViewDelegate implements Serializable, ClickListener {
		private static final long serialVersionUID = 1533975344478810154L;

		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton().equals(getView().getRefreshProcessList())) {
				refreshProcessList();
			}
		}	
	}
}

		
		
