/**
 * 
 */
package graphical_components;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Personalized Jlabel
 * @author Yuri
 *
 */
public class FormLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	/**
	 * Create label that displays the input text
	 * @param text text to display
	 */
	public FormLabel(String text) {
		super(text);
		this.setFont(FormFont.getUsedFont(true));
	}
	/**
	 * Create a label that displays a number
	 * @param integer number to display
	 */
	public FormLabel(Integer integer) {
		super(integer.toString());
		this.setFont(FormFont.getUsedFont(true));
	}
	/**
	 * Change the number displayed
	 * @param integer new number to display
	 */
	public void setText(Integer integer) {
		super.setText(integer.toString());	
	}
}
