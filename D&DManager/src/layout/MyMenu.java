package layout;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
public class MyMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MyMenu() {
		super();
		
		//menu building
		JMenu menu = new JMenu("File");
		JMenuItem menuItem;
		
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		this.add(menu);
		
		menuItem = new JMenuItem("Random text",KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
											"This doesn't really do anything");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("save", new ImageIcon("images/save_icon.png"));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
										KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menu.add(menuItem);
		
	}

}
