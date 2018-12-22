
package components;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Yuri Gardinazzi
 * TODO: to finish
 */
public class GraphicDice extends JPanel {
	private static final long serialVersionUID = 1L;
	private int numberOfSides;
	private int radius;
	private int offsetX = 250;
	private int offsetY = 250;
	/**
	 * 
	 */
	public GraphicDice(int n, int r) {
		this.setNumberOfSides(n);
		this.setRadius(r);
	}
	
	public void paint(Graphics g) {
		final int N = this.getNumberOfSides();
		final int R = this.getRadius();
		final int Tetha = 360/N;
		for(int i = 0; i < N; i++) {
			
			Graphics2D g2 = (Graphics2D) g;
			double x1 =  (Math.cos(Math.toRadians(Tetha*i))*R + this.offsetX);
			double y1 =  (Math.sin(Math.toRadians(Tetha*i))*R + this.offsetY);
			double x2 =  (Math.cos(Math.toRadians(Tetha*(i+1)))*R + this.offsetX);
			double y2 =  (Math.sin(Math.toRadians(Tetha*(i+1)))*R + this.offsetY);
			
	
			g2.setStroke(new BasicStroke(5));
			g2.draw(new Line2D.Double(x1, y1, x2, y2)); 
			Font f = new Font("TimesRoman", Font.BOLD, 40);
			g2.setFont(f);
			g2.drawString(Integer.toString(N),this.offsetX -20, this.offsetY +10);
			
					
		}
	}

	/**
	 * test GraphicDice
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("test Graphic Dice");
			   frame.setPreferredSize(new Dimension(500,500));
		GraphicDice dice = new GraphicDice(8,100);
		frame.add(dice);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
			   

	}

	/**
	 * @return the numberOfSides
	 */
	public int getNumberOfSides() {
		return numberOfSides;
	}

	/**
	 * @param numberOfSides the numberOfSides to set
	 */
	public void setNumberOfSides(int numberOfSides) {
		if(numberOfSides <= 2) {
			System.err.println("number of Sides of GraphicDice <=2\ndefault value: 3");
			this.numberOfSides = 3;
		}else {
			this.numberOfSides = numberOfSides;
		}
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		if(radius <=0) {
			System.err.println("raidius of the GraphicDice <= 0\nValue set to default: 20");
			this.radius = 20;
		}else {
			this.radius = radius;
		}
		
	}

}
