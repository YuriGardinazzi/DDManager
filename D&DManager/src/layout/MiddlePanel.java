/**
 * 
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import graphical_components.NotesPanel;
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
		this.setLayout(new BorderLayout());
		
		this.setGrid(new GridPanel(20,20,75, p3));
		JScrollPane scrollGrid = new JScrollPane(grid,
												 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		

		scrollGrid.setPreferredSize(this.calculateDimensions(new Dimension(35,35)));
		this.add(scrollGrid, BorderLayout.PAGE_START);
		
		NotesPanel notePane = new NotesPanel(new Dimension(30,20), bg);
		this.add(notePane,  BorderLayout.CENTER);

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
