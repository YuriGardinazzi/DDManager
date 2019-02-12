package layout;

import javax.swing.JPanel;
import java.awt.*;
/**
 * 
 * @author Yuri 
 * This class describes a custom JPanel
 *
 */
public class CustomPanel extends JPanel{
	//TODO: Non gli piace 100 come valore, settare controlli anche per il massimo
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension screenRatio;
	private final Dimension MINIMUM_RATIO = new Dimension(10,25);
	
	/**
	 * Creates a customized JPanel
	 * @param d dimension of the panel
	 * @param bg background of the panel
	 */
	public CustomPanel(Dimension d, Color bg) {	
		//this.setPreferredSize(d);
		this.setScreenRatio(d);
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
	 * Return a dimension relative to the screen size given a ratio P
	 * @param p
	 * @return
	 */
	protected Dimension calculateDimensions(Dimension p) {
		
		Dimension output = new Dimension(0,0);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		output.setSize(screenSize.getWidth()*p.getWidth()/100,
					   screenSize.getHeight()*p.getHeight()/100);
	
		return output;
	}
	
	/**
	 * @return the dim
	 */
	public Dimension getScreenRatio() {
		return screenRatio;
	}
	/**
	 * @param set the screen ratio according to the minimum one
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
