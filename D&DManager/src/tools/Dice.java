/**
 * 
 */
package tools;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Yuri Gardinazzi
 * This class defines a Dice and provides a method to get a random number
 */
public class Dice {

	private int nSide;
	public Dice(int n) {
		this.setNSide(n);
	}
	
	/**
	 * 
	 * @return random number in the interval [1, nSide]
	 */
	public int roll() {
		return ThreadLocalRandom.current().nextInt(1, this.getNSide()+1);
	}
	
	//this main tests the class
	public static void main(String[] args) {
		Dice d = new Dice(6);
		for(int i = 0; i < 10; i++) {
			System.out.println(d.roll());
		}
	}
	
	/**
	 * @return the nSide
	 */
	public int getNSide() {
		return this.nSide;
	}
	/**
	 * Set the number of sides of the dice
	 * the value must be >= 4 and multiple of 2
	 * @param nSide
	 */
	public void setNSide(int nSide) {
		if(nSide <= 3 || nSide % 2 != 0) {
			System.err.println("Number of side of the dice is wrong or not multiple of 2\n dice value set to default = 4 ");
			this.nSide = 4;
		}else {
			this.nSide = nSide;
		}
	}

}
