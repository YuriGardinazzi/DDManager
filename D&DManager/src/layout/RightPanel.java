package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphical_components.FormLabel;
import graphical_components.GraphicDice;
import tools.DDCharacter;

/**
 * 
 * @author Yuri	
 *	This class describes the right panel of the main layout of the application
 */
public class RightPanel extends CustomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DDCharacter character;
	/**
	 * Create the right panel with a given dimension and background color
	 * @param d
	 * @param bg
	 */
	public RightPanel(Dimension d, Color bg) {
		super(d, bg);
		
		//get the default character located in the file "default.ddc"
		DDCharacter c = null;
		try {
	         FileInputStream fileIn = new FileInputStream(new File("images" + File.separator + "default.ddc"));
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         c = (DDCharacter) in.readObject();
	         in.close();
	         fileIn.close();
		 }catch( IOException e) {
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		this.setCharacter(c);
		this.createAndShowGui();
	}

	private void createAndShowGui() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;

		//Profile picture 
		JLabel	picLabel = new JLabel();
				picLabel.setPreferredSize(new Dimension(150,150));
				picLabel.setIcon(this.getScaledPicture(this.getCharacter().getImagePath()));
		this.add(picLabel, cons);
	
		
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		//Character name
		
		cons.gridx = 0;
		cons.gridy++;	
		this.add(new FormLabel(this.getCharacter().getName()), cons);

		//Character Alignment	
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Alignment: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getAlignment()), cons);
		//Character Divinity	
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Divinity: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getDivinity()), cons);
		//Character Class
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Class: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getCharClass()), cons);
		//Character HP
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("HP: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getHitPoints()), cons);
		//Character Level
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Level: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getLevel()), cons);
		//Character Experience
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Experience: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getExperience()), cons);
		//Character Strength
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Strength: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getStrength()), cons);
		//Character Dexterity
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Dexterity: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getDexterity()), cons);
		//Character Constitution
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Constitution: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getConstitution()), cons);
		//Character Intelligence
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Intelligence: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getIntelligence()), cons);
		//Character Wisdom
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Wisdom: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getWisdom()), cons);
		//Character Charisma
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Wisdom: "), cons);
		cons.gridx = 1;
		this.add(new FormLabel(this.getCharacter().getCharisma()), cons);
				
	}
	
	/**
	 * Return a scaled picture from a picture got from a given path
	 * @param path path of the picture to scale
	 * @return scaled picture
	 */
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
	/**
	 * @return the character
	 */
	public DDCharacter getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(DDCharacter character) {
		this.character = character;
	}

}
