package de.jfpgmc.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The basket contains a BasketEntry for each unique ArticleVariant.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_BASKET")
public class Basket implements Serializable {

	private static final long serialVersionUID = -1887264413451309419L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "basket")
	private List<BasketEntry> basketEntries;
	@OneToOne
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
	 * Get basketEntries.
	 * 
	 * @return the basketEntries
	 */
	public List<BasketEntry> getBasketEntries() {
		return basketEntries;
	}

	/**
	 * Set basketEntries.
	 * 
	 * @param basketEntries
	 *            the basketEntries to set
	 */
	public void setBasketEntries(List<BasketEntry> basketEntries) {
		this.basketEntries = basketEntries;
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
