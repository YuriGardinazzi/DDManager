package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import layout.CharacterCreation;
/**
 * Menu Item that launch the new frame for character creations
 * @author Yuri
 *
 */
public class NewCharacter extends JMenuItem implements ActionListener{

	/**
	 * Construcot of the CharacterCreation Menu item
	 */
	public NewCharacter() {
		super("Create a new character");
		this.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CharacterCreation newFrame =  new CharacterCreation("Character creation");
		
	}

}
