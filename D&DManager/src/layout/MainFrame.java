package layout;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import menu.*;


/**
 * 
 * 
 * This class describes the JFrame of the entire application
 * It contains the followin 3 CustomPanels
 * LeftPanel, MiddlePanel and RightPanel
 * @author Yuri
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private LeftPanel p1;
	private MiddlePanel p2;
	private RightPanel p3;
	
	/**
	 * Initialize a MainFrame without a title
	 */
	public MainFrame() {
		this("");
	}
	/**
	 * Initialize the MainFrame with the 3 main panels inside
	 * @param title title of the main frame
	 */
	public MainFrame(String title) {
		super(title);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));	
		this.p1 = new LeftPanel(new Dimension(20,70), new Color(201, 221, 255));		

		
		//Right Panel		
		this.p3 = new RightPanel(new Dimension(20,70), new Color(143, 252, 133));
		
		//Middle Panel
		this.p2 = new MiddlePanel(new Dimension(40,70), new Color(255, 214, 140), this.p3);
		
		//Insert each panel inside a SplitPane
		JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
											 this.p1, this.p2);
				   splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
						   					 splitter, this.p3);
		this.add(splitter);
		
		MyMenu m = new MyMenu(this.p1, this.p2.getGrid());
		this.setJMenuBar(m);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
