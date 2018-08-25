package de.jfpgmc.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Articles are structured in categories, which themself can also be structured
 * in categories. Categories without a parent category are root categories, wich
 * can be used as starting point to explore the structure.
 * 
 * @author Patrick Giezen, Martin Cremer
 * 
 */
@Entity
@Table(name = "T_CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = -298579251014914960L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String caption;
	@OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER)
	private List<Category> childCategories;
	@ManyToOne
	private Category parentCategory;

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
	 * Get childCategories.
	 * 
	 * @return the childCategories
	 */
	public List<Category> getChildCategories() {
		return childCategories;
	}

	/**
	 * Set childCategories.
	 * 
	 * @param childCategories
	 *            the childCategories to set
	 */
	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}

	/**
	 * Get parentCategory.
	 * 
	 * @return the parentCategory
	 */
	public Category getParentCategory() {
		return parentCategory;
	}

	/**
	 * Set parentCategory.
	 * 
	 * @param parentCategory
	 *            the parentCategory to set
	 */
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

}
