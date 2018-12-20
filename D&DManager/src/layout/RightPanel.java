package layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class RightPanel extends CustomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RightPanel(Dimension d, Color bg) {
		super(d, bg);
		
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton("test"+i);
			this.add(btn);
		}
	}

}
