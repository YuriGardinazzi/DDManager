package player_map;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import layout.RightPanel;
import tools.DDCharacter;

public class GridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 5;
	private static final int DEFAULT_HEIGHT = 5;
	
	private int gridHeight;
	private int gridWidth;
	private int cellSide;
	private RightPanel rightPanel;
	private DDCharacter movedCharacter;
	
	

	private Cell[][] matrice;
	
	/**
	 * GridPanel generates a panel that contains a Grid of a class Cell given in input
	 * @param h rows
	 * @param w coloumns
	 * @param cell cell that draws
	 */
	public GridPanel(int w, int h, int cell, RightPanel rightPanel) {
		super();
		this.setGridHeight(h);
		this.setGridWidth(w);
		this.setCellSide(cell);
		this.setRightPanel(rightPanel);
		this.setLayout(new GridBagLayout());
		this.setMatrix();
		
		//Creation of the grid with the Cells
		GridBagConstraints cons = new GridBagConstraints();
		//Coloumns
		for(int c = 0; c < this.getGridWidth(); c++ ) {
			//Rows
			for(int r = 0; r < this.getGridHeight(); r++) {
				
				cons.fill = GridBagConstraints.NONE;
				cons.gridx = c;
				cons.gridy = r;
				this.add(this.matrice[c][r], cons);
			}
		}
	}
	
	
	

	public int getGridHeight() {
		return this.gridHeight;
	}
	public void setGridHeight(int gridHeight) {
		if(gridHeight <= 0 ) {
			this.gridHeight = DEFAULT_HEIGHT;
		}else {
			this.gridHeight = gridHeight;
		}
	}
	public int getGridWidth() {
		return this.gridWidth;
	}
	public void setGridWidth(int gridWidth) {
		
		if(gridWidth <= 0) {
			this.gridWidth = DEFAULT_WIDTH;
		}else {
			this.gridWidth = gridWidth;
		}
	}


	public int getCellSide() {
		return cellSide;
	}


	public void setCellSide(int cellSide) {
		this.cellSide = cellSide;
	}




	/**
	 * @return the matrice
	 */
	public Cell[][] getMatrice() {
		return matrice;
	}

	/**
	 * Initialize and set the matrix
	 * @param x
	 * @param y
	 */
	public void setMatrix() {
		
		this.matrice = new Cell[this.getGridWidth()][this.getGridHeight()];
		for(int c = 0; c < this.getGridWidth(); c++) {
			for(int r = 0; r < this.getGridHeight(); r++) {
				this.matrice[c][r] = new Cell(this.getCellSide(), new Color(4, 165, 13), this.getRightPanel(), this);
			}
		}
		
		
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	/**
	 * @return the movedCharacter
	 */
	public DDCharacter getMovedCharacter() {
		return movedCharacter;
	}


	/**
	 * @param movedCharacter the movedCharacter to set
	 */
	public void setMovedCharacter(DDCharacter movedCharacter) {
		this.movedCharacter = movedCharacter;
	}
	
	/**
	 * This function tells you if the player is moving a character on the map
	 * @return true if a character is changing its position, else otherwise
	 */
	public boolean isCharacterMoving() {
		if(this.getMovedCharacter() != null) {
			return true;
		}		
		return false;

	}

}
