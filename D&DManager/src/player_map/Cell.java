package player_map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.JPanel;

import layout.RightPanel;
import menu.CellListener;

import tools.DDCharacter;


/**
 * This class describes the single cell of the map
 * @author Yuri 
 *
 */
public class Cell extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int side;
	private Color bg;
	private String cellPicPath;
	private DDCharacter character;
	private String characterPath;
	private RightPanel rightPanel;
	private GridPanel grid;
	
	private static final int DEFAULT_SIDE = 25;

	/**
	 * Initialize the single cell
	 * @param side side of the cell
	 * @param bg	background color
	 * @param rightPanel reference to the right panel
	 * @param grid grid where the cell is displayed
	 */
	public Cell(int side, Color bg, RightPanel rightPanel, GridPanel grid) {
		super();
		this.setSide(side);
		this.setBackground(bg);
		this.setRightPanel(rightPanel);
		this.setGrid(grid);
		
		this.setPreferredSize(new Dimension(this.getSide(), this.getSide()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());

		
		this.addMouseListener(new CellListener(this, this.getGrid()));

		this.repaint();
	}


	/**
	 * Draw the picture of a character if present in the cell
	 * @param g
	 */
	public void paint(Graphics g) {
		
		super.paint(g);
		if(this.getCharacter()!= null) {
			try {
				BufferedImage picture = ImageIO.read(new File(this.getCellPicPath()));
				//If the image is  .png this code converts it to jpg
				BufferedImage result = new BufferedImage(
				        picture.getWidth(),
				        picture.getHeight(),
				        BufferedImage.TYPE_INT_RGB);
				//color the transparent background of white
				result.createGraphics().drawImage(picture, 0, 0, Color.white, null);
	
				Image scaledImage = result.getScaledInstance(this.getSide(),
															 this.getSide(), Image.SCALE_SMOOTH);
				g.drawImage(scaledImage, 0,0, this);	
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
		

	}	


	/**
	 * Add a character to the cell and change the background of the cell
	 * @param c character
	 */
	public void addElement(DDCharacter c) {
		
		this.setCharacter(c);
		if(this.getCellPicPath() != null) {
			this.setCellPicPath(c.getImagePath());
		}else {
			this.cellPicPath = new String(c.getImagePath());
		}
		this.repaint();
	}

	/**
	 * Remove an element from the cell if there's one.
	 * and set to null the fields character and cellPicPath
	 */
	public void removeElement() {
		if(this.getCharacter() != null) {
			this.setCharacter(null);
			this.setCellPicPath(null);
			this.setCharacterPath(null);
			this.repaint();
		}
	}
	/**
	 * Update the cell with a new one taken in input
	 * @param newCell
	 */
	public void updateCell(Cell newCell) {
		if(newCell.getCharacter() != null) {
			this.addElement(newCell.getCharacter());
		}else {
			this.removeElement();
		}
	}
	/**
	 * get the background color of the cell
	 * @return the background color of the cell
	 */
	public Color getBg() {
		return bg;
	}
	/**
	 * Set the background color of the cell
	 * @param bg
	 */
	public void setBg(Color bg) {
		this.bg = bg;
	}

	/**
	 * Get the side of the cell
	 * @return the side of the cell
	 */
	public int getSide() {
		return this.side;
	}
	/**
	 * Set the side of the cell
	 * @param side
	 */
	public void setSide(int side) {
		if(side < 50) {
			this.side = DEFAULT_SIDE;
		}else {
			this.side = side;
		}
	}

	/**
	 * get the path of the picture that is displayed in the cell
	 * @return the cellPic
	 */
	public String getCellPicPath() {
		return cellPicPath;
	}

	/**
	 * Set the path of the picture displayed in the cell
	 * @param cellPic the cellPic to set
	 */
	public void setCellPicPath(String cellPic) {
		this.cellPicPath = cellPic;
	}
	/**
	 * Get the character placed in the cell
	 * @return the character
	 */
	public DDCharacter getCharacter() {
		return character;
	}
	/**
	 * Set the character to place on the cell
	 * @param character the character to set
	 */
	public void setCharacter(DDCharacter character) {
		this.character = character;
	}
	/**
	 * Get the rightPanel that the cell refers to
	 * @return
	 */
	public RightPanel getRightPanel() {
		return rightPanel;
	}
	/**
	 * Set the rightPanel that the cell should refers to
	 * @param rightPanel
	 */
	public void setRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}
	/**
	 * Get the grid where the cell is placed
	 * @return the grid
	 */
	public GridPanel getGrid() {
		return grid;
	}
	/**
	 * Set the grid where the cell is displayed
	 * @param grid the grid to set
	 */
	public void setGrid(GridPanel grid) {
		this.grid = grid;
	}


	/**
	 * Get the path of the character placed on the cell
	 * @return the characterPath
	 */
	public String getCharacterPath() {
		return characterPath;
	}


	/**
	 * Set the path of the character placed in the cell
	 * @param characterPath the characterPath to set
	 */
	public void setCharacterPath(String characterPath) {
		this.characterPath = characterPath;
	}
}
