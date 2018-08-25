package de.jfpgmc.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a user within the system. User can be a customer or an administrator, defined by the {@link UserRoleEnum}.
 * Customers are also linked by a {@link Customer} for additional informations.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = -8689509935310955503L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String alias;
	private UserRoleEnum userRoleEnum;

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
	 * Get email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get alias.
	 * 
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Set alias.
	 * 
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Get userRoleEnum.
	 * 
	 * @return the userRoleEnum
	 */
	public UserRoleEnum getUserRoleEnum() {
		return userRoleEnum;
	}

	/**
	 * Set userRoleEnum.
	 * 
	 * @param userRoleEnum
	 *            the userRoleEnum to set
	 */
	public void setUserRoleEnum(UserRoleEnum userRoleEnum) {
		this.userRoleEnum = userRoleEnum;
	}

}
