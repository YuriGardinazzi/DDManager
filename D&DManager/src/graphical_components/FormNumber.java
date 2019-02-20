/**
 * 
 */
package graphical_components;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;


/**
 * Personalized formatted text field for numbers
 * @author Yuri
 * 
 */
public class FormNumber extends JFormattedTextField {

    //TODO: Aggiungere controllo sull'input come si deve
	private String font = "Times new roman";
	private int fontSize = 18;
	public FormNumber() {
		super();
		
		DecimalFormat decimalFormat = new DecimalFormat("###");
		decimalFormat.setMinimumIntegerDigits(0);
		
		NumberFormatter formatter = new NumberFormatter(decimalFormat);
		this.setFormatter(formatter);
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
		this.setText("0");
		
	
		
	}
	public Integer getNumber() {
		return Integer.parseInt(this.getText());
	}
}

