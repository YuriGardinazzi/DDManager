package layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Yuri
 * This class describes the window that handle the character creation 
 *
 */
public class CharacterCreation extends JFrame {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Create the CharacterCreation window
	 */
	public CharacterCreation() {
		super("");
		this.CreateGUI();
	}
	/**
	 * Create the CharacterCreation window with a given name
	 * @param title
	 */
	public CharacterCreation(String title) {
		super(title);
		this.CreateGUI();
	}

	public void CreateGUI() {
		JPanel testPanel = new JPanel();
			   testPanel.setPreferredSize(new Dimension(600,400));
			   testPanel.setBackground(Color.magenta);
		
		this.add(testPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	
}
