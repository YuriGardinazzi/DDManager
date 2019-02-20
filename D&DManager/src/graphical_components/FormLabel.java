/**
 * 
 */
package graphical_components;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Personalized label
 * @author Yuri
 *
 */
public class FormLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String font = "Times new roman";
	private int fontSize = 18;
	/**
	 * Istantiate a form label with a given text
	 * @param text
	 */
	public FormLabel(String text) {
		super(text);
		this.setFont(new Font(this.font, Font.BOLD, this.fontSize));
	}
	public FormLabel(Integer integer) {
		super(integer.toString());
		this.setFont(new Font(this.font, Font.BOLD, this.fontSize));
	}
}
