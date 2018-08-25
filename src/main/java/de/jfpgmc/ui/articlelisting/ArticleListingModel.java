/**
 * 
 */
package de.jfpgmc.ui.articlelisting;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.ArticleVariant;

/**
 * Model of ArticleListing component.
 * 
 * @author Patrick Giezen
 * 
 */
public class ArticleListingModel implements Serializable {

	private static final long serialVersionUID = 7991785386360927242L;

	private BeanItemContainer<Article> articleContainer;
	private BeanItemContainer<ArticleVariant> articleVariantContainer;

	/**
	 * Get articleContainer.
	 * 
	 * @return the articleContainer
	 */
	public BeanItemContainer<Article> getArticleContainer() {
		return articleContainer;
	}

	/**
	 * Set articleContainer.
	 * 
	 * @param articleContainer
	 *            the articleContainer to set
	 */
	public void setArticleContainer(BeanItemContainer<Article> articleContainer) {
		this.articleContainer = articleContainer;
	}

	/**
	 * Get ArticleVariantContainer
	 * 
	 * @return the articleVariantContainer
	 */
	public BeanItemContainer<ArticleVariant> getArticleVariantContainer() {
		return articleVariantContainer;
	}

	/**
	 * Set ArticleVariantCotainer
	 * 
	 * @param articleVariantContainer
	 *            the articleVariantContainer to set
	 */
	public void setArticleVariantContainer(
			BeanItemContainer<ArticleVariant> articleVariantContainer) {
		this.articleVariantContainer = articleVariantContainer;
	}

}