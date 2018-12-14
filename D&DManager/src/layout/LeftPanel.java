/**
 *@author Yuri Gardinazzi 
 */
package layout;

import java.awt.Button;
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
import javax.swing.JLabel;

public class LeftPanel extends CustomPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage myPicture;
	private JLabel imgLabel;
	
	public LeftPanel(Dimension d, Color bg) {
		super(d, bg);
		this.setLayout(new GridBagLayout());
		this.setImgLabel(new JLabel());
		this.ChangeProfilePic("images/testPic.jpg");
		this.imgLabel.setPreferredSize(new Dimension(this.getMyPicture().getWidth(),this.getMyPicture().getHeight()));

	    GridBagConstraints c = new GridBagConstraints();   
		
	    c.gridy = 0;
	    this.add(this.getImgLabel(), c);
	  
	    for(int i = 0; i < 10; i++) {
	    	c.gridy++;
	    	Button btn  = new Button("Test " + i);
	    	btn.setMinimumSize(new Dimension(100, 25));
	    	this.add(btn, c);
	    }
		

	}
	
	public void ChangeProfilePic(String path) {
		try {
			this.setMyPicture( ImageIO.read(new File(path)));
		} catch (IOException e) {
			System.out.println("Wrong Image Path!");
			e.printStackTrace();
		}
		ImageIcon toScale = new ImageIcon(this.getMyPicture());
		Image scaledImage = toScale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH );
	//	this.setImgLabel(new JLabel(new ImageIcon(scaledImage)));
		this.getImgLabel().setIcon( new ImageIcon(scaledImage));
	}
	
	/**
	 * @return the myPicture
	 */
	public BufferedImage getMyPicture() {
		return myPicture;
	}
	/**
	 * @param myPicture the myPicture to set
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
	 * @param imgLabel the imgLabel to set
	 */
	public void setImgLabel(JLabel imgLabel) {
		this.imgLabel = imgLabel;
	}

}
