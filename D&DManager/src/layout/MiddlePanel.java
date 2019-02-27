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
 * This class describes the MiddlePanel of the application.
 * It is composed of a GridPanel and a NotePanel
 */
public class MiddlePanel extends CustomPanel {
	private static final long serialVersionUID = 1L;
	private GridPanel grid;
	
	/**
	 * Initialize the middle pnel
	 * @param ratio percentage used to calculate the actual dimensions
	 * @param bg background color
	 * @param rightPanel reference to the right panel to display character informations
	 */
	public MiddlePanel(Dimension ratio, Color bg, RightPanel rightPanel) {
		super(ratio, bg);
		this.setLayout(new BorderLayout());
		
		this.setGrid(new GridPanel(20,20,75, rightPanel));
		JScrollPane scrollGrid = new JScrollPane(grid,
												 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		

		scrollGrid.setPreferredSize(this.calculateDimensions(new Dimension(35,35)));
		this.add(scrollGrid, BorderLayout.PAGE_START);
		
		NotesPanel notePane = new NotesPanel(new Dimension(30,20), bg);
		this.add(notePane,  BorderLayout.CENTER);

	}
	

	/**
	 * @return the player map
	 */
	public GridPanel getGrid() {
		return grid;
	}

	/**
	 * Set a new grid
	 * @param newGrid 
	 */
	public void setGrid(GridPanel newGrid) {
		this.grid = newGrid;
	}

}
