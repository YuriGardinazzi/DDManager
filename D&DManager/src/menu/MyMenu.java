package menu;

import javax.swing.*;
import layout.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class MyMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel leftP;
	
	public MyMenu(LeftPanel p) {
		super();
		
		//menu building
		JMenu menu = new JMenu("File");
		JMenuItem menuItem;
		
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		this.add(menu);
		
		
		//change profile picture
		menuItem = new JMenuItem("Change profile picture",KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
											"This doesn't really do anything");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Son stato premuto");
				
			}
		});
		
		menu.add(menuItem);
		
		
		//Save file item
		menuItem = new JMenuItem("save", new ImageIcon("images/save_icon.png"));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
										KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		menu.add(menuItem);
		
	}

}
