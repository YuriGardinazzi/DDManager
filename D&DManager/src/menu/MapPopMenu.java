/**
 * 
 */
package menu;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * @author Yuri
 * Popup menu that displays what you can do on the map
 *
 */
public class MapPopMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuItem anItem;
		
	public MapPopMenu() {
		this.anItem = new JMenuItem("Add new character");
		this.add(this.anItem);
	}

	/**
	 * @param label
	 */
	//public MapPopMenu(String label) {
		//super(label);
		// TODO Auto-generated constructor stub
//	}

}
