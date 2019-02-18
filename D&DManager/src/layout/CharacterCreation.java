package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	
	private String imgPath = "images" + File.separator + "character.jpg";
	
	private FormLabel labelName = new FormLabel("Name");
	private FormTextField textName = new FormTextField("name", 16);
	private FormLabel labelAlignment = new FormLabel("Alignment");
	private FormTextField textAlign = new FormTextField("chaotic-evil", 16);
	private FormLabel labelDivinity = new FormLabel("Divinity");
	private FormTextField textDivinity = new FormTextField("Boccob", 16);
	private FormLabel labelClass = new FormLabel("Class");
	private FormTextField textClass = new FormTextField("Wizard", 16);
	private FormLabel labelHP = new FormLabel("HitPoints");
	private FormNumber numHP = new FormNumber();
	private FormLabel labelLevel = new FormLabel("Level");
	private FormNumber numLevel = new FormNumber();
	private FormLabel labelExp = new FormLabel("Experience");
	private FormNumber numExp = new FormNumber();
	private FormLabel labelStrength = new FormLabel("Strength");
	private FormNumber numStr = new FormNumber();
	private FormLabel labelDex = new FormLabel("Dexterity");
	private FormNumber numDex = new FormNumber();
	private FormLabel labelConst = new FormLabel("Constitution");
	private FormNumber numConst = new FormNumber();
	private FormLabel labelInt = new FormLabel("Intelligence");
	private FormNumber numInt = new FormNumber();
	private FormLabel labelWis = new FormLabel("Wisdom");
	private FormNumber numWis = new FormNumber();
	private FormLabel labelChar = new FormLabel("Charisma");
	private FormNumber numChar = new FormNumber();
	
	/**
	 * Create the CharacterCreation window
	 */
	public CharacterCreation() {
		super("");
		this.CreateGUI();
	}
	/**
	 * Create the CharacterCreation window with a given name
	 * @param title
	 */
	public CharacterCreation(String title) {
		super(title);
		this.CreateGUI();
	}

	private void CreateGUI() {
		CustomPanel form = this.CreateForm(new Dimension(30,50), Color.cyan);
		
		this.add(form);
		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Create the Form panel with a given ratio and background color
	 * @param ratio
	 * @param bg background color
	 * @return
	 */
	private CustomPanel CreateForm(Dimension ratio, Color bg) {
		CustomPanel form = new CustomPanel(ratio, bg);
		form.setLayout(new GridBagLayout());
		
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;

		//Profile picture fields
		JLabel	picLabel = new JLabel();
				picLabel.setPreferredSize(new Dimension(150,150));
				picLabel.setIcon(this.getScaledPicture(this.imgPath));
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
						picLabel.setIcon(getScaledPicture(getImgPath()));
					}
				});
		
		form.add(addPic, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		//Name fields
		form.add(labelName, cons);
		cons.gridx = 1;
		form.add(textName, cons);
		
		cons.gridy++;
		cons.gridx = 0;
	
		//Alignment fields
	
		form.add(labelAlignment, cons);
		cons.gridx = 1;
		form.add(textAlign, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Divinity fields
	
		form.add(labelDivinity, cons);
		cons.gridx = 1;		
		form.add(textDivinity, cons);
		
		cons.gridy++;
		cons.gridx = 0;
	
		//Class fields
		
		form.add(labelClass, cons);		
		cons.gridx = 1;	
		form.add(textClass, cons);
		
		cons.gridy++;
		cons.gridx = 0;
	
		//HitPoints fields
		
		form.add(labelHP, cons);		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numHP, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Level fields
	
		form.add(labelLevel, cons);		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numLevel, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Experience fields	
		form.add(labelExp, cons);	
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numExp, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Strength fields	
		form.add(labelStrength, cons);
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		form.add(numStr, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Dexterity fields

		form.add(labelDex, cons);	
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		form.add(numDex, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Constitution fields
		
		form.add(labelConst, cons);	
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		form.add(numConst, cons);	
		cons.gridy++;
		cons.gridx = 0;
		
		//Intelligence fields

		form.add(labelInt, cons);		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;		
		form.add(numInt, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Wisdom fields
		
		form.add(labelWis, cons);		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		form.add(numWis, cons);
		cons.gridy++;
		cons.gridx = 0;
		
		//Charisma fields
		
		form.add(labelChar, cons);	
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;	
		form.add(numChar, cons);

		
		//Save Button
		
		cons.gridy++;
		cons.gridx = 1;
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DDCharacter c = new DDCharacter(
												getImgPath(),
												textName.getText(), textAlign.getText(),
												textDivinity.getText(), textClass.getText(), 
												numHP.getNumber(),numLevel.getNumber(),
												numExp.getNumber(), numStr.getNumber(),
												numDex.getNumber(), numConst.getNumber(),
												numInt.getNumber(), numWis.getNumber(), numChar.getNumber());
				
				saveCharacter(c);
		
			}
		});
		
		
		form.add(save,cons);
			
		return form;
	}
	
	/**
	 * Show an input dialog for a picture
	 * return the default path if something goes wrong.
	 * @return path to that picture
	 */
	
	private void saveCharacter(DDCharacter character) {
	
		JFileChooser chooser = new JFileChooser();

		int retrival = chooser.showSaveDialog(this.getParent());
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"D&D character", "ddc");
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
					FileOutputStream fOut = new FileOutputStream(chooser.getSelectedFile()+ ".ddc");
					ObjectOutputStream objOut = new ObjectOutputStream(fOut);
					objOut.writeObject(character);
					objOut.close();
					JOptionPane.showMessageDialog(null, character.getName() + " Has been saved");
					
					//TEST DESERIALIZATION
			         FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile()+".ddc");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         DDCharacter c = (DDCharacter) in.readObject();
			         in.close();
			         fileIn.close();
				
			         System.out.println(c);
			         
			         //Close the character creation frame
			         this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
		            ex.printStackTrace();
		        }
		    }
	}
	private ImageIcon getScaledPicture(String path) {
		BufferedImage picture;
		try {
			picture = ImageIO.read(new File(path));
			
			//If the image is  .png this code converts it to jpg
			BufferedImage result = new BufferedImage(
			        picture.getWidth(),
			        picture.getHeight(),
			        BufferedImage.TYPE_INT_RGB);
			//color the transparent background into white
			result.createGraphics().drawImage(picture, 0, 0, Color.white, null);
			
			ImageIcon toScale = new ImageIcon(result);
			Image scaledImage = toScale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
			return new ImageIcon(scaledImage);
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		
		
	}
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
