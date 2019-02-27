/**
 * 
 */
package graphical_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import layout.CustomPanel;


/**
 * Personalized Panel that display a JTextArea and two button
 * it is possible to save the text given by the Text area in a file .txt 
 * or upload a text from a file.txt
 * @author Yuri
 */
public class NotesPanel extends CustomPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create a NotesPanel with a given ratio the set his dimensions related to the screen size
	 * and a given background color
	 * @param ratio percentage of the panel sizes compared to the screen 
	 * @param bg background color of the panel
	 */
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
					noteArea.setFont(FormFont.getUsedFont(false));
		
		JScrollPane noteAreaScrollPane = new JScrollPane(noteArea);
					noteAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					noteAreaScrollPane.setPreferredSize(this.calculateDimensions(ratio));
					noteAreaScrollPane.setMinimumSize(this.calculateDimensions(ratio));
		this.add(noteAreaScrollPane, cons);
		
		cons.gridheight = 1;
		cons.gridx = 1;
		
		cons.fill  = GridBagConstraints.HORIZONTAL;
		JButton saveBtn = new JButton("Save notes");
				saveBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						saveNote(noteArea.getText());
						
					}
				});
		this.add(saveBtn,cons);
		
		
		cons.gridy = 1;
		cons.fill  = GridBagConstraints.HORIZONTAL;
		JButton uploadButton = new JButton("Upload notes");
				uploadButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						noteArea.setText(getNoteFromUser());
						
					}
				});
		
		
		this.add(uploadButton,cons); 
		
	}
	/**
	 * Open a box dialog to save an input text
	 * @param textToSave String to save as a file.txt
	 */
	private void saveNote(String textToSave) {
		
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Text File", "txt");
			JFileChooser chooser = new JFileChooser();
						 chooser.setFileFilter(filter);
						 chooser.setAcceptAllFileFilterUsed(false);
			int retrieval = chooser.showSaveDialog(this.getParent());

			if (retrieval == JFileChooser.APPROVE_OPTION) {
				try {
						PrintWriter out = new PrintWriter(chooser.getSelectedFile() + ".txt");
						out.println(textToSave);
						out.close();
						JOptionPane.showMessageDialog(null, "Note sas been saved");
						
			        } catch (Exception ex) {
			        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
			            ex.printStackTrace();
			        }
			    }
	}
	
	/**
	 * Open a dialog box and let user choose a .txt file
	 * @return the content of the .txt file
	 */
	private String getNoteFromUser() {
		String output = "";		
		//Get text file from the user
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text File", "txt");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		
		int retrieval = chooser.showOpenDialog(this.getParent());
		
		//Show the picture
		if(retrieval == JFileChooser.APPROVE_OPTION) {
			if(chooser.getSelectedFile().getPath() != null) {		
				 try {
			        output = new String(Files.readAllBytes(Paths.get(chooser.getSelectedFile().getPath())));
				 }catch( IOException e) {
					 System.err.println("Can't read the file");
					 e.printStackTrace();
				 }
			
			}
			
		}
		return output;
	}

}
