package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import layout.LeftPanel;

/**
 * Menu Item used to change the profile picture in a LeftPanel
 * It uses a JFileChooser
 * @author Yuri Gardinazzi
 *
 */
public class MenuItemChangeProPic extends JMenuItem implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel panel;
	
	
	public MenuItemChangeProPic(LeftPanel p) {
		super("Change profile picture");
		this.setPanel(p);
		
		this.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}
	
	/**
	 * Event that change the profile pic
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		//Get a picture from the user
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & png Images", "jpg", "png");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(this.getParent());
		
		//Show the picture
		if(returnVal == JFileChooser.APPROVE_OPTION) {

			if(chooser.getSelectedFile().getPath() != null) {
				String path = chooser.getSelectedFile().getPath();
				this.getPanel().ChangeProfilePic(path);
			}
			
		}
	}
	/**
	 * @return the panel
	 */
	private LeftPanel getPanel() {
		return this.panel;
	}
	/**
	 * @param panel the panel to set
	 */
	private void setPanel(LeftPanel panel) {
		this.panel = panel;
	}
}
