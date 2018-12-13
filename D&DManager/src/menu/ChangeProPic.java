package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import layout.LeftPanel;

/**
 * Menu Item used to change the profile picture in a LeftPanel
 * It uses a JFileChooser
 * @author Yuri Gardinazzi
 *
 */
public class ChangeProPic extends JMenuItem implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel panel;
	
	
	public ChangeProPic(LeftPanel p) {
		super("Change profile picture");
		this.setPanel(p);
		
		this.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Sono dentro l'evento :OOOOOO");
	}
	/**
	 * @return the panel
	 */
	private LeftPanel getPanel() {
		return panel;
	}
	/**
	 * @param panel the panel to set
	 */
	private void setPanel(LeftPanel panel) {
		this.panel = panel;
	}
}
