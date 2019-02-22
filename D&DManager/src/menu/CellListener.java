/**
 * 
 */
package menu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import player_map.Cell;
import player_map.GridPanel;

/**
 * @author ASUS
 *
 */
public class CellListener extends MouseAdapter {

	private Cell cell;
	private Color bg;
	private GridPanel grid;
	public CellListener(Cell c, GridPanel grid) {
		this.setCell(c);
		this.setGrid(grid);
		this.setBg(c.getBackground());
	}

    public void mousePressed(MouseEvent e){
        //left Click
    	if(e.getButton() == MouseEvent.BUTTON1) {
        	if(this.getCell().getCharacter() != null) {
        		this.getCell().getRightPanel().updateStat(this.getCell().getCharacter());
        	}
    		
    	/*	if(this.getBg().equals(Color.black)) {
        		this.setBg(Color.red);
        		this.cell.setBackground(this.getBg());
        	}else {
        		 this.cell.setBackground(Color.black);
        		 this.setBg(Color.black);
        	}*/
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
        MapPopMenu menu = new MapPopMenu(this.getCell(), this.getGrid());
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

	/**
	 * @return the grid
	 */
	public GridPanel getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(GridPanel grid) {
		this.grid = grid;
	}
}
