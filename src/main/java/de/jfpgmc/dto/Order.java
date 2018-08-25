package de.jfpgmc.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * When the User transmit a basket, it will be converted into an Order. The
 * properties are now independent from what is set in the current ArticleVariant
 * (for example, when the price changes).
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = -6549912769545342421L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderEntry> orderEntries;
	private double netTotalPrice;
	@ManyToOne
	private Customer customer;

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
	 * Get orderEntries.
	 * 
	 * @return the orderEntries
	 */
	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	/**
	 * Set orderEntries.
	 * 
	 * @param orderEntries
	 *            the orderEntries to set
	 */
	public void setOrderEntries(List<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
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

	/**
	 * Get customer.
	 * 
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set customer.
	 * 
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
