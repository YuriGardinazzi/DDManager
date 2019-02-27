/**
 * 
 */
package graphical_components;

import java.awt.Font;

import javax.swing.JTextField;

/**
 * Personalized JTextField to take string in input
 * @author Yuri
 *
 */
public class FormTextField extends JTextField {


	private static final long serialVersionUID = 1L;

	private String font = "Times new roman";
	private int fontSize = 18;
	
	/**
	 * Create a normal JTextField with just font changed
	 */
	public FormTextField() {
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
	}
	/**
	 * Create a TextField with given columns
	 * @param length number of columns of the text field
	 */
	public FormTextField(Integer length) {
		this("", length);
	}
	/**
	 * Create a TextField with an initialized text field
	 * and given number of columns
	 * @param text initialized text field
	 * @param length number of columns
	 */
	public FormTextField(String text, Integer length) {
		super(text, length);
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
	}
}
