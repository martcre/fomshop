package de.jfpgmc.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BasketEntry is one position in a basket, linking an amount of one
 * ArticleVariant.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_BASKET_ENTRY")
public class BasketEntry implements Serializable {

	private static final long serialVersionUID = 6946335305096574001L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ArticleVariant articleVariant;
	@ManyToOne
	private Basket basket;
	private int amount;

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
	 * Get articleVariant.
	 * 
	 * @return the articleVariant
	 */
	public ArticleVariant getArticleVariant() {
		return articleVariant;
	}

	/**
	 * Set articleVariant.
	 * 
	 * @param articleVariant
	 *            the articleVariant to set
	 */
	public void setArticleVariant(ArticleVariant articleVariant) {
		this.articleVariant = articleVariant;
	}

	/**
	 * Get basket.
	 * 
	 * @return the basket
	 */
	public Basket getBasket() {
		return basket;
	}

	/**
	 * Set basket.
	 * 
	 * @param basket
	 *            the basket to set
	 */
	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	/**
	 * Get amount.
	 * 
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Set amount.
	 * 
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
