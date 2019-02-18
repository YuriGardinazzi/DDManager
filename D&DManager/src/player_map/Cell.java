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
	
	private static final int DEFAULT_SIDE = 25;

	



	/**
	 * Draw the cell
	 * @param g
	 */
	public void paint(Graphics g) {
		
		super.paint(g);
		
		try {
			BufferedImage picture = ImageIO.read(new File(this.getCellPicPath()));
			//If the image is  .png this code converts it to jpg
			BufferedImage result = new BufferedImage(
			        picture.getWidth(),
			        picture.getHeight(),
			        BufferedImage.TYPE_INT_RGB);
			//color the transparent background into white
			result.createGraphics().drawImage(picture, 0, 0, Color.white, null);

			Image scaledImage = result.getScaledInstance(this.getSide(),
														 this.getSide(), Image.SCALE_SMOOTH);
			g.drawImage(scaledImage, 0,0, this);
			System.out.println("ho provato a stampare "+ this.getCellPicPath());
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		

	}
	public Cell() {
		this(DEFAULT_SIDE, Color.yellow);
	}
	
	public Cell(int side, Color bg) {
		super();
		this.setSide(side);
		this.setBackground(bg);
		this.setCellPicPath("images"+File.separator+"grass.jpg");
		this.setPreferredSize(new Dimension(this.getSide(), this.getSide()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());

		
		this.addMouseListener(new CellListener(this));

		this.repaint();
	}

	
	public void changeCellPicture(String path) {

		this.setCellPicPath(path);
		this.repaint();
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
}
