package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

//import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import player_map.GridPanel;
import menu.*;
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel p1;
	private CustomPanel p2;
	private CustomPanel p3;
	public MainFrame() {
		this("");
	}
	public MainFrame(String title) {
		super(title);

		this.setLayout(new GridBagLayout());

		this.p1 = new LeftPanel(new Dimension(20,70), Color.orange);		
		
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
		this.p2 = new CustomPanel(new Dimension(50,70), Color.gray);
					p2.add(scrollGrid);
	
		//Right Panel		
		this.p3 = new CustomPanel(new Dimension(20,70), Color.pink);
		GridBagConstraints c = new GridBagConstraints();
		
		//left panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;  //coloumn
		c.gridy = 0;  //row
		
		this.add(this.p1,c);
		
		//middle panel
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		this.add(this.p2, c);
		//right panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(this.p3, c);
		
		MyMenu m = new MyMenu(this.p1);
		this.setJMenuBar(m);
		this.pack();
		
		
		//this.setMaximumSize(new Dimension(300,500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
