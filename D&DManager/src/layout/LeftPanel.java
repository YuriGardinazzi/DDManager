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
	private BufferedImage myPicture;
	private String myPicturePath = "images" + File.separator + "default.jpg";
	private JLabel imgLabel;
	
	public LeftPanel(Dimension d, Color bg) {
		super(d, bg);
		this.setLayout(new GridBagLayout());
		
		//add profile pic
		this.setImgLabel(new JLabel());
		this.ChangeProfilePic(this.getMyPicturePath());
		this.imgLabel.setPreferredSize(new Dimension(this.getMyPicture().getWidth(),this.getMyPicture().getHeight()));

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
	 * @param path
	 */
	public void ChangeProfilePic(String path) {
		try {
			this.setMyPicture( ImageIO.read(new File(path)));
		} catch (IOException e) {
			System.out.println("Wrong Image Path!");
			e.printStackTrace();
		}
		//change profile pic
		ImageIcon toScale = new ImageIcon(this.getMyPicture());
		Image scaledImage = toScale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		this.getImgLabel().setIcon( new ImageIcon(scaledImage));
		
		//save profile pic as default.jpg
		try {
			ImageIO.write(this.getMyPicture(), "jpg", new File(this.getMyPicturePath()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Can't save the profile picture");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * @return the myPicture
	 */
	public BufferedImage getMyPicture() {
		return myPicture;
	}
	/**
	 * set profile picture
	 * @param myPicture 
	 */
	public void setMyPicture(BufferedImage myPicture) {
		this.myPicture = myPicture;
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
