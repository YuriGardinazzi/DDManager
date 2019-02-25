/**
 * 
 */
package graphical_components;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;


import javax.swing.JFormattedTextField;



/**
 * Personalized formatted text field for numbers
 * @author Yuri
 * 
 */
@SuppressWarnings("serial")
public class FormNumber extends JFormattedTextField implements PropertyChangeListener{

    //TODO: Aggiungere controllo sull'input come si deve
	private String font = "Times new roman";
	private int fontSize = 18;
	
	public FormNumber(Integer number) {
		super(new DecimalFormat("######"));
		this.setProperties(number);
		
	}
	public FormNumber() {
		super(new DecimalFormat("######"));
		this.setProperties(0);
		
	}
	private void setProperties(Integer number) {
		this.setValue(number);
		this.addPropertyChangeListener("value",this);
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
		this.setText(number.toString());
	}

	public Integer getNumber() {
		return Integer.parseInt(this.getText());
	}

	/**
	 * Checks for negative values and set them to 0
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Integer input = ((Number) this.getValue()).intValue();
		
		if(input < 0) {
			this.setValue(0);
		}
		
	}
}

