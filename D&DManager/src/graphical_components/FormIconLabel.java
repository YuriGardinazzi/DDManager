/**
 * 
 */
package graphical_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Yuri
 *
 */
public class FormIconLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private final Dimension DIM = new Dimension(150,150);
	private String imagePath;
	
	
	public FormIconLabel() {
		this("images"+ File.separator + "default.jpg");
	}
	/**
	 * Create a FormIconLabel with a given picture
	 * @param path path of the picture to display
	 */
	public FormIconLabel(String path) {
		super();
		this.setImagePath(path);
		this.setPreferredSize(this.DIM);
		this.setIcon(this.getScaledPicture(this.getImagePath()));
	}

	
	/**
	 * Return a scaled picture from a picture got from a given path
	 * @param path path of the picture to scale
	 * @return ImageIcon of the scaled picture
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
			Image scaledImage = toScale.getImage().getScaledInstance(this.DIM.width,
																	 this.DIM.height,
																	 Image.SCALE_SMOOTH);
		
			return new ImageIcon(scaledImage);
			
		} catch (IOException e) {
			System.out.println(path);
			e.printStackTrace();
			
			return null;
		}
	}
	
	/**
	 * 
	 * @return ImageIcon of the label
	 */
	public ImageIcon getPicture() {
		return this.getScaledPicture(this.getImagePath());
	}
	
	/**
	 * Update the picture of the Label with a new one
	 * @param path path of the new picture
	 */
	public void updatePicture(String path) {
		this.setImagePath(path);
		this.setIcon(this.getScaledPicture(this.getImagePath()));
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
