
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
import tools.Dice;
/*
 * @author Yuri Gardinazzi
 * TODO: to finish
 * This class describes the drawing of a dice
 * It can draw a dice with any number of sides.
 * 
 */
public class GraphicDice extends FormIconLabel {
	private static final long serialVersionUID = 1L;
	private final String PICS_PATH = "defaults"+ File.separator;
	private int diceType = 6;
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
		
		this.updatePicture(this.PICS_PATH + "d" + this.getDiceType() + File.separator + "n"+ this.displayedDice +".png");
	}

	public void rollTheDice() {
		Dice d = new Dice(this.diceType);
		this.setDisplayedDice(d.roll());
	}
	/**
	 * @return the diceType
	 */
	public int getDiceType() {
		return this.diceType;
	}

	/**
	 * @param diceType the diceType to set
	 */
	public  void setDiceType(int diceType) {
		this.diceType = diceType;
	}
}
