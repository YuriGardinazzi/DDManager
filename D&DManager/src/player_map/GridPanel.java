package player_map;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gridHeight;
	private int gridWidth;
	private int cellSide;
	private static final int DEFAULT_WIDTH = 5;
	private static final int DEFAULT_HEIGHT = 5;
	private Cell[][] matrice;
	
	/**
	 * GridPanel generates a panel that contains a Grid of a class Cell given in input
	 * @param h rows
	 * @param w coloumns
	 * @param cell cell that draws
	 */
	public GridPanel(int w, int h, int cell) {
		super();
		this.setGridHeight(h);
		this.setGridWidth(w);
		this.setCellSide(cell);
		this.setLayout(new GridBagLayout());
		this.setMatrice();
		
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
	public void setMatrice() {
		
		this.matrice = new Cell[this.getGridWidth()][this.getGridHeight()];
		for(int c = 0; c < this.getGridWidth(); c++) {
			for(int r = 0; r < this.getGridHeight(); r++) {
				this.matrice[c][r] = new Cell(this.getCellSide(), Color.red);
			}
		}
		
		
	}

}
