package layout;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import graphical_components.FormIconLabel;
import graphical_components.FormLabel;
import graphical_components.FormNumber;
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
	private FormLabel maxLifeValueLabel;
	private Map<String, FormLabel> mapLabel;

	private DDCharacter character;
	/**
	 * Generate the right panel with a given dimension and background color
	 * @param d
	 * @param bg
	 */
	public RightPanel(Dimension d, Color bg) {
		super(d, bg);
		
		//Display the default character located in the file "default.ddc"
		DDCharacter c = new DDCharacter();
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
	
		FormLabel maxLifeLabel = new FormLabel("Max Life: ");
		this.add(maxLifeLabel, cons);
		
		cons.gridx = 1;

		this.maxLifeValueLabel = new FormLabel(c.getMaxLife());
		this.add(maxLifeValueLabel, cons);
		
		cons.gridy ++;
		
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
		
		
		//Deal damage button and label
		cons.gridx = 0;
		FormNumber damageNumber = new FormNumber();
		this.add(damageNumber, cons);
		
		JButton damageBtn = new JButton("Deal Damage");
		damageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getCharacter().dealDamage(damageNumber.getNumber());
				updateStat(getCharacter());
				damageNumber.setValue(0);
			}
		});
		
		cons.gridx = 1;
		this.add(damageBtn, cons);
		
		//Heal damage button and label
		cons.gridy++;
		cons.gridx = 0;
		FormNumber healNumber = new FormNumber();
		this.add(healNumber, cons);
		
		JButton healBtn = new JButton("Heal Damage");
		healBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getCharacter().healDamage(healNumber.getNumber());
				updateStat(getCharacter());
				healNumber.setValue(0);
			}
		});
		
		cons.gridx = 1;
		this.add(healBtn, cons);
		
		
		
	}
	/**
	 * Update the stats written in the form with the one of a given character
	 */
	public void updateStat(DDCharacter c) {
		this.setCharacter(c);	
		this.picLabel.updatePicture(c.getImagePath());
		this.maxLifeValueLabel.setText(c.getMaxLife());
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
