package de.jfpgmc.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderEntries represents the positions of an order.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_ORDER_ENTRY")
public class OrderEntry implements Serializable {

	private static final long serialVersionUID = -7864144858302994875L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Order order;
	private String caption;
	private String description;
	private int amount;
	private double netPrice;
	private double netTotalPrice;

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
	 * Get order.
	 * 
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Set order.
	 * 
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
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

	/**
	 * Get netPrice.
	 * 
	 * @return the netPrice
	 */
	public double getNetPrice() {
		return netPrice;
	}

	/**
	 * Set netPrice.
	 * 
	 * @param netPrice
	 *            the netPrice to set
	 */
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	/**
	 * Get netTotalPrice.
	 * 
	 * @return the netTotalPrice
	 */
	public double getNetTotalPrice() {
		return netTotalPrice;
	}

	/**
	 * Set netTotalPrice.
	 * 
	 * @param netTotalPrice
	 *            the netTotalPrice to set
	 */
	public void setNetTotalPrice(double netTotalPrice) {
		this.netTotalPrice = netTotalPrice;
	}
}
