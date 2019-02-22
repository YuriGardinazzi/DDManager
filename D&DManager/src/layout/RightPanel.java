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
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graphical_components.FormIconLabel;
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

	
	private FormIconLabel picLabel;
	private Map<String, FormLabel> mapLabel;

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
			 System.out.println("Input non trovato :S");
			 e.printStackTrace();
			 c = new DDCharacter();
		
		 } catch (ClassNotFoundException e) {
		
			System.out.println("Classe non trovata");
			e.printStackTrace();
			c = new DDCharacter();
		}
		
		this.setCharacter(c);
		this.setMapLabel(new HashMap<String, FormLabel>());
		
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
		this.picLabel = new FormIconLabel(this.getCharacter().getImagePath());
		this.add(picLabel, cons);
	
		
		cons.anchor = GridBagConstraints.WEST;
		cons.fill = GridBagConstraints.HORIZONTAL;
		
		cons.gridy++;
		for(String key : c.textStatKeys) {
			cons.gridx = 0;
			this.add(new FormLabel(key + ": "), cons);
			cons.gridx = 1;
			this.getMapLabel().put(key, new FormLabel(c.getTextStat(key)));
			this.add(this.getMapLabel().get(key), cons);
			cons.gridy++;
		}

		for(String key : c.numberStatKeys) {
			cons.gridx = 0;
			this.add(new FormLabel(key + ": "), cons);
			cons.gridx = 1;
			this.getMapLabel().put(key, new FormLabel(c.getNumberStat(key)));
			this.add(this.getMapLabel().get(key), cons);
			cons.gridy++;
		}
		
		
	}
	/**
	 * Update the stats written in the form with the one of a given character
	 */
	public void updateStat(DDCharacter c) {
		this.setCharacter(c);	
		this.picLabel.updatePicture(c.getImagePath());
		for(String key : c.textStatKeys) {
			this.getMapLabel().get(key).setText(c.getTextStat(key));
		}
		for(String key : c.numberStatKeys) {
			this.getMapLabel().get(key).setText(c.getNumberStat(key));
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

	public Map<String, FormLabel> getMapLabel() {
		return mapLabel;
	}

	public void setMapLabel(Map<String, FormLabel> mapLabel) {
		this.mapLabel = mapLabel;
	}

}
