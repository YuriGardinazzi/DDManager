package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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

	public RightPanel(Dimension d, Color bg) {
		super(d, bg);
		this.setLayout(new FlowLayout());
		
		//generate 10 buttons for test purposes
		
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton("test"+i);
			this.add(btn);
		}
		
		//add Graphic Dice  TODO: doesn't work
		GraphicDice dice= new GraphicDice(4,50, new Dimension(50,50), Color.white);
		
		this.add(dice);
	
		System.out.println("Dice dimension: "+ dice.getSize());
	}

}
