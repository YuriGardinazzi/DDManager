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
import java.util.HashMap;
import java.util.Map;

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
	 * Create the CharacterCreation window with a given name
	 * @param title
	 */
	public CharacterCreation(String title) {
		super(title);
		this.CreateGUI();
	}

	private void CreateGUI() {
		CustomPanel form = this.CreateForm(new Dimension(30,60), Color.cyan);
		
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
	
		DDCharacter c = new DDCharacter();
		
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
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;	
		

		
		for(String s : c.textStatKeys) {
			this.textFields.put(s, new FormTextField("test", 16));
			cons.gridx = 0;
			JLabel label = new JLabel(s);
			form.add(label, cons);
			cons.gridx = 1;
			form.add(this.textFields.get(s), cons);
			cons.gridy ++;
		}
		for(String s : c.numberStatKeys) {	
			this.numberFields.put(s, new FormNumber());
			cons.gridx = 0;
			
			JLabel label = new JLabel(s);
			form.add(label, cons);
			cons.gridx = 1;
			form.add(this.numberFields.get(s), cons);
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
					JOptionPane.showMessageDialog(null, this.getImgPath() + " Has been saved");

			         
			         //Close the character creation frame
			         this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
		            ex.printStackTrace();
		        }
		    }
		System.out.println(character);
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
