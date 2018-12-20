package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;

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

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));


		this.p1 = new LeftPanel(new Dimension(20,70), Color.orange);		
		
		GridPanel grid = new GridPanel(20,20, 50);
		JScrollPane scrollGrid = new JScrollPane(grid,
												  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollGrid.setPreferredSize(new Dimension(600,350));
					scrollGrid.setMinimumSize(new Dimension(600,350));			
		/**
		 * TODO:
		 * Creare una dimensione coerente con la grandezza delle celle 
		 * e un limite massimo
		 */
		//Middle Panel
		this.p2 = new CustomPanel(new Dimension(50,70), Color.gray);
			 p2.add(scrollGrid);
			// p2.setLayout(new FlowLayout());
	
		//Right Panel		
		this.p3 = new CustomPanel(new Dimension(20,70), Color.pink);
		     p3.setLayout(new FlowLayout());

		     
		//left panel
		this.add(this.p1);		
		//middle panel
		this.add(this.p2);
		//right panel
		this.add(this.p3);
		
		MyMenu m = new MyMenu(this.p1);
		this.setJMenuBar(m);
		this.pack();
		
		
		//this.setMaximumSize(new Dimension(300,500));
	//	this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
