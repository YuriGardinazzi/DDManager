/**
 * 
 */
package layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import player_map.GridPanel;

/**
 * @author Yuri
 *
 */
public class MiddlePanel extends CustomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridPanel grid;
	
	public MiddlePanel(Dimension ratio, Color bg, RightPanel p3) {
		super(ratio, bg);
		this.setGrid(new GridPanel(10,5,75, p3));
		JScrollPane scrollGrid = new JScrollPane(grid,
												 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		

		scrollGrid.setPreferredSize(this.calculateDimensions(new Dimension(35,35)));
		this.add(scrollGrid);
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
