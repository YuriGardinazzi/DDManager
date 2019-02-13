package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//generate 10 buttons for test purposes
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;	
		c.gridy= 0;
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton("test"+i);
			c.gridx++;
			this.add(btn, c);
		}
		
		//add Graphic Dice  TODO: doesn't work
		//	GraphicDice dice= new GraphicDice(4,50, new Dimension(100,100), Color.white);
		//c.gridy++;
		//this.add(dice, c);
	
	//	System.out.println("Dice dimension: "+ dice.getSize());
	}

}
