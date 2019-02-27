/**
 * 
 */
package graphical_components;

import java.awt.Font;

/**
 * @author Yuri
 *	This class describes the personalized Font object used in the application
 */
public class FormFont extends Font {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Initalize FormFont
	 * @param fontName
	 * @param style
	 * @param size
	 */
	public FormFont(String fontName, int style, int size) {
		super(fontName, style, size);
	}

	public static Font getUsedFont(boolean isBold) {
		if(isBold) {
			return new Font("Times new roman", Font.BOLD, 18);
		}
		return new Font("Times new roman", Font.PLAIN, 18);
	}
}
