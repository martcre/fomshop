package de.jfpgmc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import de.jfpgmc.dao.IArticleDAO;
import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.Category;
import de.jfpgmc.service.IArticleService;

/**
 * Implementation of the ArticleService.
 * 
 * @author Patrick Giezen
 *
 */
public class ArticleServiceImpl implements IArticleService, Serializable {
	private static final long serialVersionUID = -3312063031175347533L;
	/**
	 * Injected by spring configuration.
	 */
	private IArticleDAO articleDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<Category> findRootCategories() {
		return articleDAO.findRootCategories();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<Article> findArticlesInCategory(Category category) {
		return articleDAO.findArticlesInCategory(category);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Article> findAllArticles() {
		return articleDAO.findAllArticles();
	}
	
	/**
	 * Set articleDAO.
	 * 
	 * @param articleDAO the articleDAO to set
	 */
	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
}
