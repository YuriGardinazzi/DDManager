package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

//import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import player_map.GridPanel;
import menu.*;
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel p1;
	private CustomPanel p2;
	private RightPanel p3;
	
	public MainFrame() {
		this("");
	}
	/**
	 * Create a frame with 3 panels inside
	 * 
	 * @param title of the main frame
	 */
	public MainFrame(String title) {
		super(title);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));	
		this.p1 = new LeftPanel(new Dimension(20,70), Color.orange);		

		
		GridPanel grid = new GridPanel(15,8, 100);
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
		this.p2 = new CustomPanel(Color.gray);
			 p2.add(scrollGrid);
	
		//Right Panel		
		this.p3 = new RightPanel(new Dimension(20,70), Color.pink);

		//Insert each panel inside a SplitPane
		JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
											 this.p1, this.p2);
				   splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
						   					 splitter, this.p3);
		this.add(splitter);
		
		MyMenu m = new MyMenu(this.p1);
		this.setJMenuBar(m);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
