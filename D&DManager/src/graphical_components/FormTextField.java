/**
 * 
 */
package graphical_components;

import java.awt.Font;

import javax.swing.JTextField;

/**
 * Personalized JTextField for forms
 * @author Yuri
 *
 */
public class FormTextField extends JTextField {


	private static final long serialVersionUID = 1L;

	private String font = "Times new roman";
	private int fontSize = 18;
	public FormTextField() {
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
	}
	public FormTextField(Integer length) {
		this("", length);
	}
	public FormTextField(String text, Integer length) {
		super(text, length);
		this.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
	}
}
