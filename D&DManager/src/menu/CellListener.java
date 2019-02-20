/**
 * 
 */
package menu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import player_map.Cell;

/**
 * @author ASUS
 *
 */
public class CellListener extends MouseAdapter {

	private Cell cell;
	private Color bg;
	public CellListener(Cell c) {
		this.setCell(c);
		this.setBg(c.getBackground());
	}

    public void mousePressed(MouseEvent e){
        //left Click
    	if(e.getButton() == MouseEvent.BUTTON1) {
        	if(this.getCell().getCharacter() != null) {
   
        		this.getCell().getRightPanel().setCharacter(this.getCell().getCharacter());
        		this.getCell().getRightPanel().createAndShowGui();
        	}
    		
    		if(this.getBg().equals(Color.black)) {
        		this.setBg(Color.red);
        		this.cell.setBackground(this.getBg());
        	}else {
        		 this.cell.setBackground(Color.black);
        		 this.setBg(Color.black);
        	}
    	}
    	
    	if (e.isPopupTrigger()) {
            this.showMenu(e);
    	}
    	
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger()) {
            this.showMenu(e);
        }
    }

    private void showMenu(MouseEvent e){
        MapPopMenu menu = new MapPopMenu(this.getCell());
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

	/**
	 * @return the cell
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	/**
	 * @return the bg
	 */
	public Color getBg() {
		return bg;
	}

	/**
	 * @param bg the bg to set
	 */
	public void setBg(Color bg) {
		this.bg = bg;
	}
}
