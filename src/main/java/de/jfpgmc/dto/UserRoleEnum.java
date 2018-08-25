package de.jfpgmc.dto;

/**
 * List of different user roles.
 * 
 * @author Patrick Giezen, Martin Cremer
 *
 */
public enum UserRoleEnum {
	CUSTOMER, ADMINISTRATOR;
	
	/**
	 * Convert a String representation into a enum object, used for JPA.
	 * 
	 * @param str the key
	 * @return the value
	 */
	public static UserRoleEnum fromString(String str) {
		if ("0".equals(str)) return UserRoleEnum.CUSTOMER;
		if ("1".equals(str)) return UserRoleEnum.ADMINISTRATOR;
		return valueOf(str);
	}
}
