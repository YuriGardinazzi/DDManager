/**
 * 
 */
package graphical_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import layout.CustomPanel;

/**
 * @author Yuri
 *
 */
public class NotesPanel extends CustomPanel {

	
	private String font = "Times new roman";
	private int fontSize = 18;
	public NotesPanel(Dimension ratio, Color bg) {
		super(ratio, bg);
		this.setLayout(new GridBagLayout());
		
		this.setMinimumSize(this.calculateDimensions(ratio));
		
		
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.fill = GridBagConstraints.BOTH;
		cons.gridheight = 2;
		JTextArea	noteArea = new JTextArea("Write your notes here");
					noteArea.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
	//	noteArea.setPreferredSize(this.calculateDimensions(new Dimension(35,20)));
		
		JScrollPane noteAreaScrollPane = new JScrollPane(noteArea);
					noteAreaScrollPane.setPreferredSize(this.calculateDimensions(ratio));
					noteAreaScrollPane.setMinimumSize(this.calculateDimensions(ratio));
		this.add(noteAreaScrollPane, cons);
		
		cons.gridheight = 1;
		cons.gridx = 1;
		
		cons.fill  = GridBagConstraints.HORIZONTAL;
		JButton saveBtn = new JButton("Save notes");
		
		this.add(saveBtn,cons);
		
		
		cons.gridy = 1;
		cons.fill  = GridBagConstraints.HORIZONTAL;
		JButton uploadButton = new JButton("Upload notes");
		
		this.add(uploadButton,cons); 
		
		
	}

}
