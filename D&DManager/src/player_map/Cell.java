package player_map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Yuri Gardinazzi
 *
 */
public class Cell extends JPanel {

	private static final long serialVersionUID = 1L;
	private int side;
	private Color bg;
	private static final int DEFAULT_SIDE = 25;
	
	public Cell() {
		this(DEFAULT_SIDE, Color.yellow);
	}
	
	public Cell(int side, Color bg) {
		super();
		this.setSide(side);
		this.setBackground(bg);
		this.setPreferredSize(new Dimension(this.getSide(), this.getSide()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.addMouseListener(new MouseAdapter() {
     
	       	//getBackground return the background color of the father
			//@SuppressWarnings("unused")
			private Color defaultBg = getBackground();
			private Color actualColor = getBackground();
			
            @Override
            public void mousePressed(MouseEvent e) {
            	if(actualColor.equals(Color.black)) {
            		this.actualColor = this.defaultBg;
            		setBackground(this.defaultBg);
            	}else {
            		 setBackground(Color.black);
            		 this.actualColor = Color.black;
            	}
               
                repaint();
            }
            

           /* @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
            } */
        });
	}



	/**
	 * Draw the cell
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		this.setBackground(bg);
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
}
