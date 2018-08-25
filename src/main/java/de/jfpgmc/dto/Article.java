package de.jfpgmc.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Articles can contain different ArticleVariants with different prices, names and descriptions.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
@Entity
@Table(name = "T_ARTICLE")
public class Article implements Serializable {

	private static final long serialVersionUID = -3962685204798357764L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
	private List<ArticleVariant> articleVariants;
	@OneToMany
	private List<Tag> tags;
	private String caption;
	private String description;
	private String image;
	private Category category;

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
	 * Get articleVariants.
	 * 
	 * @return the articleVariants
	 */
	public List<ArticleVariant> getArticleVariants() {
		return articleVariants;
	}

	/**
	 * Set articleVariants.
	 * 
	 * @param articleVariants
	 *            the articleVariants to set
	 */
	public void setArticleVariants(List<ArticleVariant> articleVariants) {
		this.articleVariants = articleVariants;
	}

	/**
	 * Get tags.
	 * 
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * Set tags.
	 * 
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
	 * Get image.
	 * 
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set image.
	 * 
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Get category.
	 * 
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Set category.
	 * 
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
