/**
 * 
 */
package layout;

import java.awt.Color;
import java.awt.Dimension;

/**
 * @author Yuri
 * This class describes the panel that handle the character creation 
 *
 */
public class CharacterCreation extends CustomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiate the CustomPanel for the character creation
	 * @param d dimension 
	 * @param bg background color
	 */
	public CharacterCreation(Dimension d, Color bg) {
		super(d, bg);
		// TODO Creare tutti i vari tool per la configurazione del personaggio
	}
	/**
	 * Instantiate the CustomPanel for the character creation
	 * @param bg background color
	 */
	public CharacterCreation(Color bg) {
		super(bg);
	}

}
