package de.jfpgmc.ui.userregister;

import java.io.Serializable;

/**
 * Model of UserRegister component.
 * 
 * @author Patrick Giezen
 * 
 */
public class UserRegisterModel implements Serializable {

	private static final long serialVersionUID = 2442366329905913370L;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String passwordChallenge;
	private String city;
	private String country;
	private String phone;
	private String street;
	private String zipCode;
	
	/**
	 * get the first name
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set the first name
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get the last name
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set the last name
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get the city
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set the city
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get the country
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * set the country
	 * 
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * get the phone number
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * set the phone number
	 * 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * get the street
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * set the street
	 * 
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * get the zipCode
	 * 
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * set the zipCode
	 * 
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Get the email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the passwordChallenge
	 * 
	 * @return the passwordChallenge
	 */
	public String getPasswordChallenge() {
		return passwordChallenge;
	}

	/**
	 * Set the passwordChallenge
	 * 
	 * @param passwordChallenge
	 *            the passwordChallenge to set
	 */
	public void setPasswordChallenge(String passwordChallenge) {
		this.passwordChallenge = passwordChallenge;
	}

}
