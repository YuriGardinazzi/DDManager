package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

//import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import player_map.GridPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this("");
	}
	public MainFrame(String title) {
		super(title);

		this.setLayout(new GridBagLayout());

		LeftPanel p1 = new LeftPanel(new Dimension(20,70), Color.red);		
		
		GridPanel grid = new GridPanel(20,20, 50);
		JScrollPane scrollGrid = new JScrollPane(grid,
												  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollGrid.setPreferredSize(new Dimension(600,350));			
		/**
		 * TODO:
		 * Creare una dimensione coerente con la grandezza delle celle 
		 * e un limite massimo
		 */
		//Middle Panel
		CustomPanel p2 = new CustomPanel(new Dimension(50,70), Color.gray);
					p2.add(scrollGrid);
	
		//Right Panel		
		CustomPanel p3 = new CustomPanel(new Dimension(20,70), Color.pink);
		GridBagConstraints c = new GridBagConstraints();
		
		//left panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;  //coloumn
		c.gridy = 0;  //row
		this.add(p1,c);
		//middle panel
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		this.add(p2, c);
		//right panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(p3, c);
		
		
		MyMenu m = new MyMenu();
		this.setJMenuBar(m);
		this.pack();
		
		
		//this.setMaximumSize(new Dimension(300,500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
