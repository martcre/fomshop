package de.jfpgmc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.jfpgmc.dao.IArticleDAO;
import de.jfpgmc.dto.Article;
import de.jfpgmc.dto.Category;

/**
 * Implementation of IArticleDAO. Contains methods to manage articles and
 * categories.
 * 
 * @author Patrick Giezen
 * 
 */
public class ArticleDAOImpl implements IArticleDAO, Serializable {

	private static final long serialVersionUID = 290471989183974320L;
	protected EntityManager entityManager;

	/**
	 * Setter for the JPA entityManager.
	 * 
	 * @param entityManager
	 *            the entityManager
	 */
	@PersistenceContext(unitName = "fomshop")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Not implemented.
	 */
	@Override
	public Category create(Category category) {
		throw new UnsupportedOperationException("NOT IMPLEMENTED");
	}

	/**
	 * Not implemented.
	 */
	@Override
	public Category update(Category category) {
		throw new UnsupportedOperationException("NOT IMPLEMENTED");
	}

	/**
	 * Not implemented.
	 */
	@Override
	public void delete(long categoryId) {
		throw new UnsupportedOperationException("NOT IMPLEMENTED");
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findRootCategories() {
		try {
			Query query = entityManager
					.createQuery("SELECT c FROM Category c WHERE c.parentCategory IS NULL ");
			return query.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Category>();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findArticlesInCategory(Category category) {
		try {
			Query query = entityManager
					.createQuery("SELECT a FROM Article a WHERE a.category = :category ");
			query.setParameter("category", category);
			return query.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Article>();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findAllArticles() {
		try {
			Query query = entityManager.createQuery("SELECT a FROM Article a ");
			return query.getResultList();
		} catch (NoResultException nre) {
			return new ArrayList<Article>();
		}
	}
}
