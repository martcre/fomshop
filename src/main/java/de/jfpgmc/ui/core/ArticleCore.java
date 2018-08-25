package de.jfpgmc.ui.core;

import java.io.Serializable;
import java.util.List;

import com.vaadin.ui.Component;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.ArticleVariant;
import de.jfpgmc.dto.Basket;
import de.jfpgmc.dto.BasketEntry;
import de.jfpgmc.dto.Category;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.articlebrowser.ArticleBrowserControl;
import de.jfpgmc.ui.articlebrowser.IArticleBrowser;
import de.jfpgmc.ui.articlebrowser.IArticleBrowserDelegate;
import de.jfpgmc.ui.articlecategorymenu.IArticleCategoryMenuDelegate;
import de.jfpgmc.ui.articlelisting.IArticleListingDelegate;
import de.jfpgmc.ui.articleviewer.ArticleViewerControl;
import de.jfpgmc.ui.articleviewer.IArticleViewer;
import de.jfpgmc.ui.articleviewer.IArticleViewerDelegate;

/**
 * Delegate implementing {@link IArticleBrowserDelegate},
 * {@link IArticleCategoryMenuDelegate}, {@link IArticleListingDelegate}.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
public class ArticleCore implements Serializable, IArticleBrowserDelegate,
		IArticleCategoryMenuDelegate, IArticleListingDelegate,
		IArticleViewerDelegate {

	private static final long serialVersionUID = -8448809300879464053L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processChooseArticleVariant(ArticleVariant articleVariant,
			int amount) {

		synchronized (FomShopApplication.getInstance()) {
			Basket basket = FomShopApplication.getInstance().getBasketContext()
					.getBasket();
			boolean added = false;
			for (BasketEntry basketEntry : basket.getBasketEntries()) {
				if (basketEntry.getArticleVariant().equals(articleVariant)) {
					basketEntry.setAmount(basketEntry.getAmount() + amount);
					added = true;
				}
			}

			if (!added) {
				BasketEntry basketEntry = new BasketEntry();
				basketEntry.setAmount(amount);
				basketEntry.setArticleVariant(articleVariant);
				basketEntry.setBasket(FomShopApplication.getInstance()
						.getBasketContext().getBasket());
				FomShopApplication.getInstance().getBasketContext().getBasket()
						.getBasketEntries().add(basketEntry);
			}

			FomShopApplication.getInstance().getBasketContext().basketUpdated();
			FomShopApplication.getInstance().getBasketContext()
					.notifyObservers();
		}
	}

	/**
	 * NOT IMPLEMENTED.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void processEditArticle(Article article) {
		throw new UnsupportedOperationException();
	}

	/**
	 * NOT IMPLEMENTED.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void processCreateArticle() {
		throw new UnsupportedOperationException();

	}

	/**
	 * NOT IMPLEMENTED.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void processDeleteArticle(Article article) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processCategorySelection(Category category) {
		FomShopApplication.getInstance().getLayoutView().getMainArea()
				.removeAllComponents();

		IArticleBrowser articleBrowser = new ArticleBrowserControl(this);
		articleBrowser.showArticles(category.getCaption(),
				FomShopApplication.getInstance().getArticleService()
						.findArticlesInCategory(category));
		FomShopApplication.getInstance().getLayoutView().getMainArea()
				.addComponent((Component) articleBrowser);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Category> fetchRootCategories() {
		return FomShopApplication.getInstance().getArticleService()
				.findRootCategories();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processArticleSelection(Article article) {
		FomShopApplication.getInstance().getLayoutView().getMainArea()
				.removeAllComponents();
		IArticleViewer articleViewer = new ArticleViewerControl(this);
		articleViewer.showArticle(article);
		FomShopApplication.getInstance().getLayoutView().getMainArea()
				.addComponent((Component) articleViewer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Article> fetchArticles() {
		return FomShopApplication.getInstance().getArticleService()
				.findAllArticles();
	}

}
