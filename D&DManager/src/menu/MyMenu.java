package menu;

import javax.swing.*;
import layout.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
public class MyMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel leftP;
	
	public MyMenu(LeftPanel p) {
		super();
		this.setLeftP(p);
		//menu building
		JMenu menu = new JMenu("Options");
		JMenuItem menuItem;
		
	//	menu.setMnemonic(KeyEvent.VK_A);
	//	menu.getAccessibleContext().setAccessibleDescription(
	//	        "The only menu in this program that has menu items");
		this.add(menu);
		
		
		//change profile picture
		MenuItemChangeProPic proPicItem = new MenuItemChangeProPic(this.getLeftP());

		menu.add(proPicItem);
		
		
		//Save file item, shortcut Ctrl + S
		menuItem = new JMenuItem("save", new ImageIcon("images/save_icon.png"));		
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		menu.add(menuItem); 
		
		
		//menuItem = new JMenuItem("new character");
		//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		NewCharacter characterCreationItem = new NewCharacter();
		menu.add(characterCreationItem);
	}

	/**
	 * @return the leftP
	 */
	public LeftPanel getLeftP() {
		return leftP;
	}

	/**
	 * @param leftP the leftP to set
	 */
	public void setLeftP(LeftPanel leftP) {
		this.leftP = leftP;
	}

}
