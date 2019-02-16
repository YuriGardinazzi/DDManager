
package graphical_components;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.CustomPanel;
/**
 * @author Yuri Gardinazzi
 * TODO: to finish
 * This class describes the drawing of a dice
 * It can draw a dice with any number of sides.
 * 
 */
public class GraphicDice extends JPanel {
	private static final long serialVersionUID = 1L;
	private int numberOfSides;
	private int radius;
	private int offsetX = 250;
	private int offsetY = 250;
	/**
	 * Constructor of the graphic dice
	 * @param n number of sides
	 * @param r radius  
	 */
	public GraphicDice(int n, int r, Dimension d, Color bg) {
		super();
		super.setSize(d);
		super.setPreferredSize(d);
		super.setBackground(bg);
		this.setNumberOfSides(n);
		this.setRadius(r);
		this.setOpaque(true);

	}

	/**
	 * Draws the dice
	 */
	public void paint(Graphics g) {
		final int N = this.getNumberOfSides();
		final int R = this.getRadius();
		final int Tetha = 360/N;
	
	
		//Draw the sides of the dice
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
			System.err.println("radius of the GraphicDice <= 0\nValue set to default: 20");
			this.radius = 20;
		}else {
			this.radius = radius;
		}
		
	}

	/**
	 * test GraphicDice
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("test Graphic Dice");
			   frame.setPreferredSize(new Dimension(500,500));
		GraphicDice dice = new GraphicDice(8,50, new Dimension(50,50), Color.blue);
		frame.add(dice);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
			   

	}
}
