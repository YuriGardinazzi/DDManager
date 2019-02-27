/**
 * 
 */
package menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import player_map.Cell;
import player_map.GridPanel;

/**
 * 
 * This class describe the listener event on mouse click of the Cell class
 * @author Yuri
 */
public class CellListener extends MouseAdapter {

	private Cell cell;
	private GridPanel grid;
	
	/**
	 * Initialized listener
	 * @param c Cell where the listener is applied
	 * @param grid Grid where the cell is placed
	 */
	public CellListener(Cell c, GridPanel grid) {
		this.setCell(c);
		this.setGrid(grid);
	}

	/**
	 * Describes the actions to do when the mouse is pressed
	 */
    public void mousePressed(MouseEvent e){
        //left Click
    	if(e.getButton() == MouseEvent.BUTTON1) {
        	if(this.getCell().getCharacter() != null) {
        		this.getCell().getRightPanel().updateStat(this.getCell().getCharacter());
        	}
    	}
    	//PopUp Menu event
    	if (e.isPopupTrigger()) {
            this.showMenu(e);
    	}
    	
    }

    /**
     * Describes the action to do when the mouse is released
     */
    public void mouseReleased(MouseEvent e){
        //PopUp menu event
    	if (e.isPopupTrigger()) {
            this.showMenu(e);
        }
    }

    /**
     * Display the popup menu where user clicked with the mouse
     * @param e event
     */
    private void showMenu(MouseEvent e){
        MapPopMenu menu = new MapPopMenu(this.getCell(), this.getGrid());
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

	/**
	 * Return actual Cell when CellListener is applied
	 * @return the cell
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * Set the cell of the CellListener
	 * @param cell  new cell
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	/**
	 * Get the Grid that CellListener refers to
	 * @return the grid
	 */
	public GridPanel getGrid() {
		return grid;
	}

	/**
	 * Set the grid of CellListener
	 * @param grid the grid to set
	 */
	public void setGrid(GridPanel grid) {
		this.grid = grid;
	}
}
