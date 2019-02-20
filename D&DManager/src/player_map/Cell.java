package player_map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import menu.CellListener;
import menu.MapPopMenu;
import tools.DDCharacter;


/**
 * 
 * @author Yuri Gardinazzi
 *
 */
public class Cell extends JPanel {

	private static final long serialVersionUID = 1L;
	private int side;
	private Color bg;
	private String cellPicPath;
	private DDCharacter character;
	
	private static final int DEFAULT_SIDE = 25;

	



	/**
	 * Draw the cell
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
	public Cell() {
		this(DEFAULT_SIDE, Color.yellow);
	}
	
	public Cell(int side, Color bg) {
		super();
		this.setSide(side);
		this.setBackground(bg);

		this.setPreferredSize(new Dimension(this.getSide(), this.getSide()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());

		
		this.addMouseListener(new CellListener(this));

		this.repaint();
	}

	/**
	 * Add an element to the cell and change the background of the cell
	 * @param path path of the new character
	 * @param c
	 */
	public void addElement(String path, DDCharacter c) {
		
		this.setCharacter(c);
		if(this.getCellPicPath() != null) {
			this.setCellPicPath(path);
		}else {
			this.cellPicPath = new String(path);
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
			this.repaint();
		}
	}
	/**
	 * 
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
	 * 
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
	 * @return the cellPic
	 */
	public String getCellPicPath() {
		return cellPicPath;
	}

	/**
	 * @param cellPic the cellPic to set
	 */
	public void setCellPicPath(String cellPic) {
		this.cellPicPath = cellPic;
	}
	/**
	 * @return the character
	 */
	public DDCharacter getCharacter() {
		return character;
	}
	/**
	 * @param character the character to set
	 */
	public void setCharacter(DDCharacter character) {
		this.character = character;
	}
}
