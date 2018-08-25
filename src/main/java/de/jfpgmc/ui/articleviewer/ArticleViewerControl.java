package de.jfpgmc.ui.articleviewer;

import java.io.Serializable;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.ArticleVariant;
import de.jfpgmc.util.I18n;

/**
 * Control of ArticleViewer component.
 * 
 * @author Patrick Giezen
 *
 */
public class ArticleViewerControl extends CustomComponent implements IArticleViewer {

	private static final long serialVersionUID = 7494326908496670472L;
	private IArticleViewerDelegate delegate;
	private ArticleViewerView view;
	private ArticleViewerModel model;
	private ViewDelegate viewDelegate;
	
	/**
	 * Constructor for ArticleViewerControl.
	 * 
	 * @param delegate
	 */
	public ArticleViewerControl(IArticleViewerDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void showArticle(Article article) {
		getView().getArticleTitle().setValue(article.getCaption());
		getView().getArticleDescription().setValue(article.getDescription());
		
		getModel().getArticleVariants().removeAllItems();
		getModel().getArticleVariants().addAll(article.getArticleVariants());
	}
	
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IArticleViewerDelegate getDelegate() {
		return delegate;
	}

	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private ArticleViewerView getView() {
		if (view == null) {
			view = new ArticleViewerView();
			view.getArticleVariants().setContainerDataSource(getModel().getArticleVariants());
			
			view.getArticleVariants().addGeneratedColumn("addToBasket", new Table.ColumnGenerator() {
				private static final long serialVersionUID = 1873403352354579536L;
				@SuppressWarnings("unchecked")
				@Override
				public Object generateCell(Table source, Object itemId, Object columnId) {
					final Item articleVariantItem = source.getItem(itemId);
					final Button order = new Button(I18n.getString("ADD_TO_BASKET"));
					order.setDisableOnClick(true);
					order.addListener(new Button.ClickListener() {
						private static final long serialVersionUID = -4368933626494340453L;
						@Override
						public void buttonClick(ClickEvent event) {
							ArticleVariant articleVariant = ((BeanItem<ArticleVariant>) articleVariantItem).getBean();
							getViewDelegate().processAddToBasket(articleVariant, 1);
							order.setEnabled(true);
						}
					});
					return order;
				}
			});
			
			view.getArticleVariants().setVisibleColumns(new String[]{
					"caption",
					"description",
					"netPrice",
					"stockStatus",
					"addToBasket"
					});
			
			view.getArticleVariants().setColumnHeaders(new String[]{
					I18n.getString("CAPTION"),
					I18n.getString("DESCRIPTION"),
					I18n.getString("NET_PRICE"),
					I18n.getString("STOCK_STATUS"),
					""
					});
			

			
		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private ArticleViewerModel getModel() {
		if (model == null) {
			model = new ArticleViewerModel();
			model.setArticleVariants(new BeanContainer<Long, ArticleVariant>(ArticleVariant.class));
			model.getArticleVariants().setBeanIdProperty("id");
		}
		return model;
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
	 * Delegate to handle User interaction.
	 *
	 */
	private class ViewDelegate implements Serializable {
		private static final long serialVersionUID = -7915137097738798901L;

		public void processAddToBasket(ArticleVariant articleVariant, int amount) {
			getDelegate().processChooseArticleVariant(articleVariant, amount);
		}
		
	}
}
