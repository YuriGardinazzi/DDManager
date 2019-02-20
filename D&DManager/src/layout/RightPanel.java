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
import javax.swing.JLabel;
import graphical_components.FormLabel;
import graphical_components.FormNumber;
import graphical_components.FormTextField;
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

	private JLabel picLabel;
	private FormLabel labelName;
	private FormLabel labelAlignment;	
	private FormLabel labelDivinity;	
	private FormLabel labelClass;	
	private FormLabel labelHP;
	private FormLabel labelLevel;	
	private FormLabel labelExp;
	private FormLabel labelStrength ;
	private FormLabel labelDex;
	private FormLabel labelConst;
	private FormLabel labelInt;
	private FormLabel labelWis;
	private FormLabel labelCharisma;

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

	/**
	 * Draws the GUI of the right panel
	 */
	public void createAndShowGui() {
		this.setLayout(new GridBagLayout());

		DDCharacter c = this.getCharacter();
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;

		//Profile picture 
		this.picLabel = new JLabel();
		this.picLabel.setPreferredSize(new Dimension(150,150));
		this.picLabel.setIcon(this.getScaledPicture(this.getCharacter().getImagePath()));
		this.add(picLabel, cons);
	
		
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		
		//Add each label on the left side
		//Character name
		
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Name: "), cons);
		cons.gridx = 1;
		this.labelName = new FormLabel(c.getName());
		this.add(this.labelName, cons);
	
		//Character Alignment	
		
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Alignment: "), cons);
		cons.gridx = 1;
		this.labelAlignment = new FormLabel(c.getAlignment());
		this.add(this.labelAlignment, cons);
		
		//Character Divinity	
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Divinity: "), cons);
		cons.gridx = 1;
		this.labelDivinity = new FormLabel(c.getDivinity());
		this.add(this.labelDivinity, cons);
		
		//Character Class
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Class: "), cons);
		cons.gridx = 1;
		this.labelClass = new FormLabel(c.getCharClass());
		this.add(this.labelClass, cons);
		
		//Character HP
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("HP: "), cons);
		cons.gridx = 1;
		this.labelHP = new FormLabel(c.getHitPoints());
		this.add(this.labelHP, cons);
		
		//Character Level
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Level: "), cons);
		cons.gridx = 1;
		this.labelLevel = new FormLabel(c.getLevel());
		this.add(this.labelLevel, cons);
		
		//Character Experience
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Experience: "), cons);
		cons.gridx = 1;
		this.labelExp = new FormLabel(c.getExperience());
		this.add(this.labelExp, cons);
		
		//Character Strength
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Strength: "), cons);
		cons.gridx = 1;
		this.labelStrength = new FormLabel(c.getStrength());
		this.add(this.labelStrength, cons);
		
		//Character Dexterity
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Dexterity: "), cons);
		cons.gridx = 1;
		this.labelDex = new FormLabel(c.getDexterity());
		this.add(this.labelDex, cons);
		
		//Character Constitution
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Constitution: "), cons);
		cons.gridx = 1;
		this.labelConst = new FormLabel(c.getConstitution());
		this.add(this.labelConst, cons);
		
		//Character Intelligence
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Intelligence: "), cons);
		cons.gridx = 1;
		this.labelInt = new FormLabel(c.getIntelligence());
		this.add(this.labelInt, cons);
		
		//Character Wisdom
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Wisdom: "), cons);
		cons.gridx = 1;
		this.labelWis = new FormLabel(c.getWisdom());
		this.add(this.labelWis, cons);
		
		//Character Charisma
		cons.gridx = 0;
		cons.gridy++;
		this.add(new FormLabel("Charisma: "), cons);
		cons.gridx = 1;
		this.labelCharisma = new FormLabel(c.getCharisma());
		this.add(this.labelCharisma, cons);
		
		
	}
	/**
	 * Update the stats written in the form with the one of a given character
	 */
	public void updateStat(DDCharacter c) {
		GridBagConstraints cons = new GridBagConstraints();
		this.setCharacter(c);	
		this.picLabel.setIcon(this.getScaledPicture(c.getImagePath()));
		this.labelName.setText(c.getName());
		this.labelAlignment.setText(c.getAlignment());
		this.labelClass.setText(c.getCharClass());
		this.labelDivinity.setText(c.getDivinity());
		this.labelHP.setText(c.getHitPoints());
		this.labelLevel.setText(c.getLevel());
		this.labelExp.setText(c.getExperience());
		this.labelStrength.setText(c.getStrength());
		this.labelDex.setText(c.getDexterity());
		this.labelConst.setText(c.getConstitution());
		this.labelInt.setText(c.getIntelligence());
		this.labelWis.setText(c.getWisdom());
		this.labelCharisma.setText(c.getCharisma());

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
