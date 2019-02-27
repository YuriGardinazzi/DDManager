/**
 * 
 */
package graphical_components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;


import javax.swing.JFormattedTextField;



/**
 * @author Yuri
 * Personalized formatted text field for numbers
 * it accepts only number >= 0. 
 * If the user inserts a string or a wrong number the value set is 0 
 */
@SuppressWarnings("serial")
public class FormNumber extends JFormattedTextField implements PropertyChangeListener{

	/**
	 * Create a FormNumber with a a number given input as default
	 * @param number Input number to display
	 */
	public FormNumber(Integer number) {
		super(new DecimalFormat("######"));
		this.setProperties(number);
		
	}
	/**
	 * Create a default FormNumber that displays 0 as default number
	 */
	public FormNumber() {
		super(new DecimalFormat("######"));
		this.setProperties(0);
		
	}
	/**
	 * Set the properties of the FormNumber
	 * and displays the number given in input
	 * @param number input number
	 */
	private void setProperties(Integer number) {
		this.setValue(number);
		this.addPropertyChangeListener("value",this);
		this.setFont(FormFont.getUsedFont(false));
		this.setText(number.toString());
	}

	/**
	 * @return the number displayed
	 */
	public Integer getNumber() {
		return Integer.parseInt(this.getText());
	}

	/**
	 * Checks for negative values and if present set them to 0
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Integer input = ((Number) this.getValue()).intValue();
		
		if(input < 0) {
			this.setValue(0);
		}
		
	}
}

