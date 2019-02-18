/**
 * 
 */
package menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author ASUS
 *
 */
public class CellListener extends MouseAdapter {

	/**
	 * 
	 */
	public CellListener() {
		// TODO Auto-generated constructor stub
	}

    public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            this.showMenu(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            this.showMenu(e);
    }

    private void showMenu(MouseEvent e){
        MapPopMenu menu = new MapPopMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
