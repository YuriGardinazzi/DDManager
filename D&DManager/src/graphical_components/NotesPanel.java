/**
 * 
 */
package graphical_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import tools.DDCharacter;

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
	 * Open a box dialog to save a string
	 * @param textToSave
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
				//Character deserialization
				 try {
			        output = new String(Files.readAllBytes(Paths.get(chooser.getSelectedFile().getPath())));
				 }catch( IOException e) {
					 e.printStackTrace();
				 }
			
			}
			
		}
		return output;
	}

}
