package de.jfpgmc.util;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility to get the translation for a given key.
 * 
 * @author Martin Cremer
 *
 */
public class I18n {
	
	private static ResourceBundle resourceBundle;
	private static Logger logger = Logger.getLogger(I18n.class.getName());
	
	/**
	 * Get the translation for key.
	 * 
	 * @param key 
	 * @return the translation
	 */
	public static String getString(String key) {
		String result;
		if(resourceBundle == null) {
			/*
			 * TODO Locale des Clients herrausfinden!!
			 */
			resourceBundle = ResourceBundle.getBundle("de.jfpgmc.labels", Locale.GERMAN);
		}
		try {
			result = resourceBundle.getString(key);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Key \"" + key + "\" can not be found in ResourceBundle");
			result = "???" + key + "???";
		}
		return result;
	}
}
