
package graphical_components;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.MainFrame;
/*
 * @author Yuri Gardinazzi
 * TODO: to finish
 * This class describes the drawing of a dice
 * It can draw a dice with any number of sides.
 * 
 */
public class GraphicDice extends FormIconLabel {
	private static final long serialVersionUID = 1L;
	private static final String PICS_PATH = "defaults"+ File.separator + "d6" + File.separator;
	private int displayedDice;
	
	public GraphicDice() {
		super();
		this.setDisplayedDice(6);
	}

	/**
	 * @return the number of the displayed dice
	 */
	public int getDisplayedDice() {
		return displayedDice;
	}

	/**
	 * @param set the number of the displayed dice
	 */
	public void setDisplayedDice(int displayedDice) {
		if(displayedDice <= 0 || displayedDice > 6) {
			this.displayedDice = 6;
		}
		this.displayedDice = displayedDice;
		
		this.updatePicture(this.PICS_PATH + "n"+ this.displayedDice +".png");
	}
}
