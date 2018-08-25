package de.jfpgmc.util;

import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

/**
 * Use to extract a value of a nested Property.
 * 
 * @author Martin Cremer
 * 
 */
public class PropertyOfNestedObject implements ColumnGenerator {

	private static final long serialVersionUID = -7114687974016268867L;
	private Object rootPropertyId;
	private String nestedProperty;

	/**
	 * Constructor setup for PropertyOfNestedObject. The property aRootProperty
	 * of the current object will be inspected and the path within
	 * aNestedProperty will be followed until the defined position or null.
	 * 
	 * @param aRootProperty the property to look in
	 * @param aNestedProperty the path to the nested property, separated by .
	 */
	public PropertyOfNestedObject(Object aRootProperty, String aNestedProperty) {
		rootPropertyId = aRootProperty;
		nestedProperty = aNestedProperty;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Component generateCell(Table source, Object itemId, Object columnId) {
		Property currentProperty = source.getItem(itemId).getItemProperty(
				rootPropertyId);
		String[] selector = nestedProperty.split("\\.");
		for (int i = 0; i < selector.length; i++) {
			if (currentProperty != null && currentProperty.getValue() != null) {
				BeanItem b = new BeanItem(currentProperty.getValue());
				currentProperty = b.getItemProperty(selector[i]);
			} else {
				break;
			}
		}
		if (currentProperty != null && currentProperty.getValue() != null) {
			Label l = new Label();
			l.setPropertyDataSource(currentProperty);
			return l;
		} else {
			return null;
		}
	}

}
