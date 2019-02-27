
package graphical_components;

import java.io.File;

import tools.Dice;
/**
 *
 * This class is a FormIconLabel with defined picture
 * the picture that it can display are just picture of dices
 * those picture are saved in the folder defaults
 * 
 * Folders follow the rule d[number of the dice]
 * and picture follo the rule n[side to display]
 *  @author Yuri 
 */
public class GraphicDice extends FormIconLabel {
	private static final long serialVersionUID = 1L;
	private final String PICS_PATH = "defaults"+ File.separator;
	private int diceType = 6;
	private int displayedDice;
	
	
	/**
	 * create a Graphic dice
	 * display a d6 with the number 6
	 */
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
	 * if the input number is not in the interval [1,20] it sets the value to 6
	 * @param displayedDice number of the side to display
	 * 
	 */
	private void setDisplayedDice(int displayedDice) {
		if(displayedDice <= 0 || displayedDice > 20) {
			this.displayedDice = 6;
		}
		this.displayedDice = displayedDice;
		
		this.updatePicture(this.PICS_PATH + "d" + this.getDiceType() + File.separator + "n"+ this.displayedDice +".png");
	}

	/**
	 * Roll a dice of the displayed dice type
	 * and change the picture displayed according to the rolled number
	 * the number rolled is just a random number in the interval [1, diceType]
	 */
	public void rollTheDice() {
		Dice d = new Dice(this.diceType);
		this.setDisplayedDice(d.roll());
	}
	/**
	 * @return the actual dice type
	 */
	public int getDiceType() {
		return this.diceType;
	}

	/**
	 * @param diceType the diceType to set
	 */
	public  void setDiceType(int diceType) {
		if(diceType <= 0 || diceType > 20) {
			this.diceType = 6;
		}
		this.diceType = diceType;
	}
}
