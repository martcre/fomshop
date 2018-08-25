package de.jfpgmc.ui.articleviewer;

import java.io.Serializable;

import com.vaadin.data.util.BeanContainer;

import de.jfpgmc.dto.ArticleVariant;

/**
 * Model of ArticleViewer component.
 * 
 * @author Patrick Giezen
 *
 *
 */
public class ArticleViewerModel implements Serializable {

	private static final long serialVersionUID = -354624729203022186L;
	
	
	private BeanContainer<Long, ArticleVariant> articleVariants;


	/**
	 * Get articleVariants.
	 * 
	 * @return the articleVariants
	 */
	public BeanContainer<Long, ArticleVariant> getArticleVariants() {
		return articleVariants;
	}


	/**
	 * Set articleVariants.
	 * 
	 * @param articleVariants the articleVariants to set
	 */
	public void setArticleVariants(
			BeanContainer<Long, ArticleVariant> articleVariants) {
		this.articleVariants = articleVariants;
	}
	
}
