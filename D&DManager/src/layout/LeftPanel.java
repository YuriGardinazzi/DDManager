/**
 *@author Yuri Gardinazzi 
 */
package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import javax.swing.JButton;
import javax.swing.JComboBox;

import graphical_components.FormIconLabel;
import graphical_components.FormLabel;
import graphical_components.GraphicDice;
/**
 * This class describes the Left panel of the application
 * @author Yuri 
 *
 */
public class LeftPanel extends CustomPanel {

	private static final long serialVersionUID = 1L;
	
	
	private String myPicturePath = "defaults" + File.separator + "default.jpg";
	private final Integer possibleDices[] = {4,6,8,10,12,20};
	private FormIconLabel imgLabel;
	private GraphicDice dice;
	
	/**
	 * Creates the left panel with just a given background color
	 * @param bg Background color
	 */
	public LeftPanel(Color bg) {
		super(bg);
		this.CreatePanel();
	}
	/**
	 * Create the left panel with a given Dimension and background color
	 * @param d Dimension
	 * @param bg Background color
	 */
	public LeftPanel(Dimension d, Color bg) {
		super(d, bg);
		this.CreatePanel();	
	}
	/**
	 * Insert inside the panel each element
	 */
	private void CreatePanel() {
		this.setLayout(new GridBagLayout());
		
		//add profile pic
		this.setImgLabel(new FormIconLabel());
		this.ChangeProfilePic(this.getMyPicturePath());
	
		this.imgLabel.setPreferredSize(new Dimension(150,150));

	    GridBagConstraints cons = new GridBagConstraints();   
	    cons.gridy = 0;
	    cons.gridx = 0;
	    cons.gridwidth = 2;
	    this.add(this.getImgLabel(), cons);
	    
	    cons.gridx = 0;
	    cons.gridy ++;
	    cons.gridwidth = 1;
	    FormLabel diceLabel = new FormLabel("Roll a d");
	    this.add(diceLabel, cons);
	    
	    cons.gridx = 1;
	    cons.gridwidth = 1;
	   	JComboBox<Integer> diceList = new JComboBox<Integer>(this.possibleDices);
	    this.add(diceList, cons);
	    
	    cons.gridy++;
	    cons.gridx = 0;
	    cons.gridwidth = 2;
	    JButton rollBtn = new JButton("Roll !");
	    rollBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dice.setDiceType((Integer) diceList.getSelectedItem()); 
				dice.rollTheDice();
			}
		});
	    
	    
	    this.add(rollBtn, cons);
	    
	   
	    cons.gridy ++;
	    cons.gridx = 0;
	    cons.gridwidth = 2;
	    this.dice = new GraphicDice();
	    this.add(dice, cons);
	    
		

	}
	/**
	 * Change profile picture
	 * @param newPicturePath path of the new picture
	 */
	public void ChangeProfilePic(String newPicturePath) {
		
		try {
			//save new profile pic as default.jpg
			BufferedImage picture = ImageIO.read(new File(newPicturePath));
			
			//If the image is  .png this code converts it to jpg
			BufferedImage result = new BufferedImage(
			        picture.getWidth(),
			        picture.getHeight(),
			        BufferedImage.TYPE_INT_RGB);
			//color the transparent background into white
			result.createGraphics().drawImage(picture, 0, 0, Color.white, null);
					
			ImageIO.write(result ,"jpg", new File(this.getMyPicturePath()));

			
			//change profile pic and scale it
			this.getImgLabel().updatePicture(newPicturePath);
		
		} catch (IOException e) {
			System.out.println("Wrong Image Path!");
			e.printStackTrace();
		}
			
	}
	/**
	 * @return the label of the profile picture
	 */
	public FormIconLabel getImgLabel() {
		return imgLabel;
	}
	/**
	 * set the Label where the profile picture will be shown
	 * @param imgLabel 
	 */
	public void setImgLabel(FormIconLabel imgLabel) {
		this.imgLabel = imgLabel;
	}

	/**
	 * @return the path of the profile picture
	 */
	public String getMyPicturePath() {
		return myPicturePath;
	}

	/**
	 * @param myPicturePath set the path of the profile picture
	 */
	public void setMyPicturePath(String myPicturePath) {
		this.myPicturePath = myPicturePath;
	}


}
