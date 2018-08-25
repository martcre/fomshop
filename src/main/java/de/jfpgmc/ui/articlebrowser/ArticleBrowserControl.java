package de.jfpgmc.ui.articlebrowser;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;

import de.jfpgmc.dto.Article;

/**
 * Control of ArticleBrowser component.
 * 
 * @author Patrick Giezen
 *
 */

public class ArticleBrowserControl extends CustomComponent implements IArticleBrowser {

	
	private static final long serialVersionUID = -6094277165560483793L;
	private IArticleBrowserDelegate delegate;
	private ArticleBrowserView view;
	
	/**
	 * Constructor for ArticleBrowserControl
	 * 
	 * @param delegate
	 */
	public ArticleBrowserControl(IArticleBrowserDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	/**
	 * Get delegate
	 * 
	 * @return the delegate
	 */
	private IArticleBrowserDelegate getDelegate() {
		return delegate;
	}
	
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private ArticleBrowserView getView() {
		if (view == null) {
			view = new ArticleBrowserView();
		}
		return view;
	}

	/**
	 *  
	 * {@inheritDoc}
	 */
	@Override
	public void showArticles(String title, List<Article> articles) {
		getView().getTitle().setValue(title);
		
		getView().getArticles().removeAllComponents();
		
		for (Article article : articles) {
			final Article finalarticle = article;
			ArticleItemView itemview = new ArticleItemView();
			itemview.getButtonOpen().addListener(new Button.ClickListener() {
			
				private static final long serialVersionUID = -6462616508069675291L;

				@Override
				public void buttonClick(ClickEvent event) {
					getDelegate().processArticleSelection(finalarticle);
					
				}
			});
			itemview.getTitle().setValue(article.getCaption());
			getView().getArticles().addComponent(itemview);

			
		}
	}

}
