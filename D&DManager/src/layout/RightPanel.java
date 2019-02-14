package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import components.GraphicDice;

/**
 * 
 * @author Yuri	
 *	This class describes the right panel of the main layout of the application
 */
public class RightPanel extends CustomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Create the right panel with a given background color
	 * @param bg
	 */
	public RightPanel(Color bg) {
		super(bg);
		this.CreatePanel();
	}
	/**
	 * Create the right panel with a given dimension and background color
	 * @param d
	 * @param bg
	 */
	public RightPanel(Dimension d, Color bg) {
		super(d, bg);
		this.CreatePanel();
	}
	/**
	 * Insert each element inside the panel
	 */
	public void CreatePanel() {
		//this.setLayout(new FlowLayout());

		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton("test"+i);
			
			this.add(btn);
		}
	
		//add Graphic Dice  TODO: doesn't work
		//GraphicDice dice= new GraphicDice(4,50, new Dimension(100,100), Color.white);
		JPanel prova = new JPanel();
			   prova.setPreferredSize(new Dimension(100,100));
			   prova.setBackground(Color.blue);
		
		this.add(prova);
		this.repaint();   
		
		System.out.println("Dice dimension: "+ prova.getSize());
	}

}
