/**
 * 
 */
package tools;

import java.util.Vector;

/**
 * This class describes a formula that is a sum of dices and levels
 * 
 * @author Yuri Gardinazzi
 *
 */
public class Formula {

	private Vector<Dices> vet;
	private int additionalNumber;
	
	
	public Formula(int num, Dice d) {
		Vector<Dices> v = new Vector<Dices>();
					  v.add(new Dices(1,d));
		this.setVet(v);
		this.setAdditionalNumber(num);
	}
	public Formula(int addNum, int numDices, Dice d) {
		Vector<Dices> v = new Vector<Dices>();
					  v.add(new Dices(numDices, d));
		this.setVet(v);
		this.setAdditionalNumber(addNum);
	}
	/**
	 * takes in input just the vector of dices 
	 * the additionalNumber value is set to 0
	 * @param v
	 */
	public Formula(Vector<Dices> v) {
		this(v, 0);
	}
	public Formula(Vector<Dices> v, int num) {	
		this.setVet(v);
		this.setAdditionalNumber(num);
	}
	
	/**
	 * Add a number of the same dice in the formula
	 * the number can be negative, because you can add and subtract N dices
	 *
	 * @param n number of dices
	 * @param d dice
	 */
	public void addDice(int n, Dice d) {
		
		if(n == 0) {
			System.err.println("number of dices wrong\n default: added one dice");
			this.vet.add(new Dices(1,d));
		}else {
			this.vet.add(new Dices(n,d));
		}
	}

	/**
	 * Test Formula
	 * @param args
	 */
	public static void main(String[] args) {
		Formula f = new Formula(-3,4, new Dice(4));
				f.addDice(3, new Dice(6) );
			    f.addDice(-3, new Dice(20));
				f.addDice(-1, new Dice(8));
		System.out.println("the formula is: " + f);
	}
	public int getResult() {
		int result = 0;
		
		for(Dices d : this.getVet()) {
			result += d.roll();
		}
		result += this.getAdditionalNumber();
		return result;
	}
	@Override
	public String toString() {
		String output ="";
		for(Dices d : this.getVet()) {
			output += d.toString() + " ";
		}
		output+= this.getAdditionalNumber();
		return output;
	}
	/**
	 * @return the vet
	 */
	public Vector<Dices> getVet() {
		return vet;
	}

	/**
	 * @param vet the vet to set
	 */
	public void setVet(Vector<Dices> vet) {
		if(vet.isEmpty()) {
			System.err.println("Vector of dices empty, \n created a default vector");
			Dices d = new Dices(1,6); //1d6
			Vector<Dices> v = new Vector<Dices>();
						  v.add(d);
			this.vet = v;
		}else {
			this.vet = vet;
		}
	}

	/**
	 * @return the additionalNumber
	 */
	public int getAdditionalNumber() {
		return additionalNumber;
	}

	/**
	 * @param additionalNumber the additionalNumber to set
	 */
	public void setAdditionalNumber(int additionalNumber) {
		this.additionalNumber = additionalNumber;
	}
	
}