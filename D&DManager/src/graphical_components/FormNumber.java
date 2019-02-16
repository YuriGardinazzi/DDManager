/**
 * 
 */
package graphical_components;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;


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
		super(new DecimalFormat("###"));
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
		this.setText("000");
	
		
	}
	public Integer getNumber() {
		return Integer.parseInt(this.getText());
	}
}

