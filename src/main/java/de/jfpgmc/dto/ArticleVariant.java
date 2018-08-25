package de.jfpgmc.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ArticleVariants are different variants of one article like different sizes,
 * colors, etc.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_ARTICLE_VARIANT")
public class ArticleVariant implements Serializable {

	private static final long serialVersionUID = -473522599275117383L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Article article;
	private Double netPrice;
	private String caption;
	private String description;
	@ManyToOne
	private StockStatus stockStatus;

	/**
	 * Get id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get article.
	 * 
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * Set article.
	 * 
	 * @param article
	 *            the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * Get netPrice.
	 * 
	 * @return the netPrice
	 */
	public Double getNetPrice() {
		return netPrice;
	}

	/**
	 * Set netPrice.
	 * 
	 * @param netPrice
	 *            the netPrice to set
	 */
	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	/**
	 * Get caption.
	 * 
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * Set caption.
	 * 
	 * @param caption
	 *            the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Get description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description.
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get stockStatus.
	 * 
	 * @return the stockStatus
	 */
	public StockStatus getStockStatus() {
		return stockStatus;
	}

	/**
	 * Set stockStatus.
	 * 
	 * @param stockStatus
	 *            the stockStatus to set
	 */
	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

}
