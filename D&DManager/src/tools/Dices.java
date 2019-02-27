/**
 * 
 */
package tools;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class implements the couple Number and Dice to indicate a number of dices
 * example : 2d4 that stands for 2 dices of 4 sides
 * @author Yuri 
 *
 */
public class Dices extends Dice {


	private int numberOfDices;
	/**
	 * Initialize Dices 
	 * @param num number of times to roll a dice
	 * @param d dice to roll
	 */
	
	public Dices(int num, Dice d) {
		super(d.getNSide());
		this.setNumberOfDices(num);
	}
	
	/**
	 * Initialize Dices
	 * @param num number of rolling
	 * @param sides number of the sides of the dice to roll;
	 */
	public Dices(int num, int sides) {
		super(sides);
		this.setNumberOfDices(num);
		
	}

	@Override
	public int roll() {
		int sum = 0;
		for(int i = 0; i < this.getNumberOfDices(); i++) {
			sum += ThreadLocalRandom.current().nextInt(1, this.getNSide()+1);
		}
		
		return sum;
	}
	@Override
	public String toString() {
		return this.getNumberOfDices() +"d"+ this.getNSide();
	}
	/**
	 * Get the number of dices to roll
	 * @return the numberOfDices
	 */
	public int getNumberOfDices() {
		return numberOfDices;
	}
	/**
	 * Set the number of dices
	 * the value must be different from 0 but can be negative.
	 * negative number of dices could be useful in a formula
	 * @param numberOfDices 
	 */
	public void setNumberOfDices(int numberOfDices) {
		if(numberOfDices == 0) {
			System.err.println("number of dices wrong!\n set to the default value of 1");
			this.numberOfDices = 1;
		}else {
			this.numberOfDices = numberOfDices;
		}
	}
	

}
