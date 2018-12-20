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
	
	
	public Formula(Dice d, int num) {
		Vector<Dices> v = new Vector<Dices>();
					  v.add(new Dices(1,d));
		this.setVet(v);
		this.setAdditionalNumber(num);
	}
	public Formula(Vector<Dices> v) {
		this(v, 0);
	}
	public Formula(Vector<Dices> v, int num) {	
		this.setVet(v);
		this.setAdditionalNumber(num);
	}
	
	
	public void addDice(int n, Dice d) {
		
		if(n <= 0) {
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
		// TODO Auto-generated method stub

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
