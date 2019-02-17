/**
 *@author Yuri Gardinazzi 
 */
package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * This class describes the left panel of the MainFrame
 * @author Yuri Gardinazzi
 *
 */
public class LeftPanel extends CustomPanel {

	private static final long serialVersionUID = 1L;
	
	
	private String myPicturePath = "images" + File.separator + "default.jpg";
	
	private JLabel imgLabel;
	
	
	/**
	 * Creates the left panel with a given background color
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
		this.setImgLabel(new JLabel());
		this.ChangeProfilePic(this.getMyPicturePath());
	
		this.imgLabel.setPreferredSize(new Dimension(150,150));

	    GridBagConstraints c = new GridBagConstraints();   
		
	    c.gridy = 0;
	    this.add(this.getImgLabel(), c);
	  
	    //generate buttons for test purposes
	    for(int i = 0; i < 10; i++) {
	    	c.gridy++;
	    	JButton btn= new JButton("Test " + i);
	    	btn.setMinimumSize(new Dimension(100, 25));
	    	this.add(btn, c);
	    }
		

	}
	/**
	 * Change profile pic with a given path
	 * @param newPicturePath
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
			ImageIcon toScale = new ImageIcon(result);
			Image scaledImage = toScale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			this.getImgLabel().setIcon(new ImageIcon(scaledImage));	
		
		} catch (IOException e) {
			System.out.println("Wrong Image Path!");
			e.printStackTrace();
		}
			
	}
	/**
	 * @return the imgLabel
	 */
	public JLabel getImgLabel() {
		return imgLabel;
	}
	/**
	 * set the Label where the profile picture will be shown
	 * @param imgLabel 
	 */
	public void setImgLabel(JLabel imgLabel) {
		this.imgLabel = imgLabel;
	}

	/**
	 * @return the myPicturePath
	 */
	public String getMyPicturePath() {
		return myPicturePath;
	}

	/**
	 * @param myPicturePath the myPicturePath to set
	 */
	public void setMyPicturePath(String myPicturePath) {
		this.myPicturePath = myPicturePath;
	}


}
