package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

import graphical_components.FormIconLabel;
import graphical_components.FormLabel;
import graphical_components.FormNumber;
import graphical_components.FormTextField;
import tools.DDCharacter;

/**
 * @author Yuri
 * This class describes the window that handle the character creation 
 *
 */
public class CharacterCreation extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String imgPath;
	private Map<String, FormTextField> textFields = new HashMap<String, FormTextField>();
	private Map<String, FormNumber> numberFields = new HashMap<String, FormNumber>();
	
	/**
	 * Create the CharacterCreation window
	 */
	public CharacterCreation() {
		super("");
		this.CreateGUI();
	}
	/**
	 * Create the Character creation window with a given name
	 * @param title
	 */
	public CharacterCreation(String title) {
		super(title);
		this.CreateGUI();
	}
	
	/**
	 * Create the Character modify window with a given name
	 * @param title name of the window
	 * @param character character to modify
	 */
	public CharacterCreation(String title, DDCharacter character) {
		super(title);
		this.CreateGUI(character);
	}

	/**
	 * Creates the Graphic User Interface to modify a character
	 * @param character  character to modify
	 */
	private void CreateGUI(DDCharacter character) {
		
		this.CreateForm(this, character);
		this.pack();
		this.getContentPane().setBackground(Color.cyan);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * Creates the Graphic User Interface to create a new character
	 */
	private void CreateGUI() {
		
		this.CreateForm(this, new DDCharacter());
		this.pack();
		this.getContentPane().setBackground(Color.cyan);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Add character fields to the form 
	 * @param form
	 */
	private void CreateForm(JFrame form, DDCharacter character) {

		form.setLayout(new GridBagLayout());
	
		DDCharacter c = character;
		this.setImgPath(c.getImagePath());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.insets = new Insets(2,5,2,5);
		cons.ipady = 5;
		cons.gridx = 0;
		cons.gridy = 0;

		//Profile picture fields
		FormIconLabel picLabel = new FormIconLabel(c.getImagePath());

		form.add(picLabel, cons);
		
		cons.gridx = 1;
		
		JButton addPic = new JButton("Change profile pic");
				addPic.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String newCharPath = getCharPicturePath();
						if(newCharPath != getImgPath()) {
							setImgPath(newCharPath);
						}
						picLabel.updatePicture(getImgPath());
					}
				});
		
		form.add(addPic, cons);
		
		cons.gridy++;
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;	
		

		//add label and text/number fields 
		for(String key : c.textStatKeys) {
			this.textFields.put(key, new FormTextField(c.getTextStat(key), 16));
			cons.gridx = 0;
			FormLabel label = new FormLabel(key);
			form.add(label, cons);
			cons.gridx = 1;
			form.add(this.textFields.get(key), cons);
			cons.gridy ++;
		}
		for(String key : c.numberStatKeys) {	
			this.numberFields.put(key, new FormNumber(c.getNumberStat(key)));
			cons.gridx = 0;
			
			FormLabel label = new FormLabel(key);
			form.add(label, cons);
			cons.gridx = 1;
			form.add(this.numberFields.get(key), cons);
			cons.gridy ++;
		}

		
	//Save Button
		
		cons.gridy++;
		cons.gridx = 1;
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DDCharacter c = new DDCharacter();
				
				c.setTextStat("ImagePath", getImgPath());
				for(String key : c.textStatKeys) {
				
					c.setTextStat(key, textFields.get(key).getText());
				}
				for(String key : c.numberStatKeys) {
					c.setNumberStat(key, numberFields.get(key).getNumber());
				}
				
				c.setImagePath(getImgPath());
				c.setMaxLife();
				saveCharacter(c);
			}
		});
			
		form.add(save,cons);

	}
	
	/**
	 * Show a box dialog to save the character
	 */
	private void saveCharacter(DDCharacter character) {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"D&D character", "ddc");
		JFileChooser chooser = new JFileChooser();
					 chooser.setFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
		int retrieval = chooser.showSaveDialog(this.getParent());

		if (retrieval == JFileChooser.APPROVE_OPTION) {
			try {
					FileOutputStream fOut = new FileOutputStream(chooser.getSelectedFile()+ ".ddc");
					ObjectOutputStream objOut = new ObjectOutputStream(fOut);
					objOut.writeObject(character);
					objOut.close();
					JOptionPane.showMessageDialog(null, character.getTextStat("Name") + " Has been saved");

			         
			         //Close the character creation frame
			         this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
		            ex.printStackTrace();
		        }
		    }
		//For Debug purposes
		System.out.println(character);
	}
	
	/**
	 * Create a File chooser box dialog to get the path of a new picture
	 * @return the path of the picture that the user choosed
	 */
	private String getCharPicturePath() {
		//Get a picture from the user
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & png Images", "jpg", "png");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(this.getParent());
		
		//return the path
		if(returnVal == JFileChooser.APPROVE_OPTION) {

			if(chooser.getSelectedFile().getPath() != null) {
				return chooser.getSelectedFile().getPath();
			
			}
			
		}
		return this.imgPath;
	}
	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}
	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
