package layout;

import javax.swing.JPanel;
import java.awt.*;
/**
 * 
 * 
 * This class describes a custom JPanel
 * the user can give an input ratio that is basically a percentage.
 * The dimensions of the panel will be the input percentage of the actual screen size 
 * of the monitor where the software is running
 * @author Yuri 
 */
public class CustomPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Dimension screenRatio;
	private final Dimension MINIMUM_RATIO = new Dimension(10,25);
	
	/**
	 * Creates a customized JPanel
	 * @param ratio percentage dimension of the panel related to the screen size
	 * @param bg background of the panel
	 */
	public CustomPanel(Dimension ratio, Color bg) {	
		//this.setPreferredSize(d);
		this.setScreenRatio(ratio);
		this.setBackground(bg);
		this.setSizes();
		
	}
	public CustomPanel(Color bg) {
		this.setBackground(bg);
	}
	
	/**
	 * Set preferred and minimum size
	 */
	private void setSizes() {
		this.setPreferredSize(this.calculateDimensions(this.getScreenRatio()));
		this.setMinimumSize(this.calculateDimensions(this.MINIMUM_RATIO));
	}
	
	/**
	 * Return a dimension relative to the screen size
	 * @param ratio percentage of the dimensions needed compared to the screen dimensions
	 * @return calculated Dimension
	 */
	protected Dimension calculateDimensions(Dimension ratio) {
		
		Dimension output = new Dimension(0,0);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		output.setSize(screenSize.getWidth()*ratio.getWidth()/100,
					   screenSize.getHeight()*ratio.getHeight()/100);
	
		return output;
	}
	
	/**
	 * @return the dim
	 */
	public Dimension getScreenRatio() {
		return screenRatio;
	}
	/**
	 * Set the screen ratio according to the minimum one
	 * @param ratio percentage to set
	 */
	public void setScreenRatio(Dimension ratio) {
		if(ratio.getWidth() < this.getMinimumRatio().getWidth() || 
		   ratio.getHeight() < this.getMinimumRatio().getHeight()) {
		
			//System.out.print(this.getMinimumRatio());
			this.screenRatio = this.getMinimumRatio();
		
		}else {
			this.screenRatio = ratio;
			
		}
	}
	
	/**
	 * @return the minimumRatio
	 */
	public Dimension getMinimumRatio() {
		return MINIMUM_RATIO;
	}
}
