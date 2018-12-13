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
	public LeftPanel(Dimension d, Color bg) {
		super(d, bg);
		this.setLayout(new GridBagLayout());
		
		try {
			this.setMyPicture(ImageIO.read(new File("images/testPic.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon toScale = new ImageIcon(myPicture);
	//	Dimension scaledDim = super.calculateDimensions(new Dimension(5,5));
		Image scaledImage = toScale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
			   picLabel.setPreferredSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));

			   
	    GridBagConstraints c = new GridBagConstraints();   
		
	    c.gridy = 0;
	    this.add(picLabel, c);
	  
	    for(int i = 0; i < 10; i++) {
	    	c.gridy++;
	    	Button btn  = new Button("Test " + i);
	    	btn.setMinimumSize(new Dimension(100, 25));
	    	this.add(btn, c);
	    }
		

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

}
