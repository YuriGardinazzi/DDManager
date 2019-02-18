/**
 * 
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

import player_map.Cell;
import tools.DDCharacter;

/**
 * @author Yuri
 * Popup menu that displays what you can do on the map
 *
 */
public class MapPopMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuItem addCharacter;
	private Cell cell;
	
	public MapPopMenu(Cell c) {
		this.setCell(c);
		this.addCharacter = new JMenuItem("Add new character");
		this.addCharacter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DDCharacter c = retrieveCharacter();
				getCell().changeCellPicture(c.getImagePath());
			}
		});
		this.add(this.addCharacter);
	}

	private DDCharacter retrieveCharacter() {
		DDCharacter c = null;
		//Get a picture from the user
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"D&D Character", "ddc");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(this.getParent());
		
		//Show the picture
		if(returnVal == JFileChooser.APPROVE_OPTION) {

			if(chooser.getSelectedFile().getPath() != null) {
				String path = chooser.getSelectedFile().getPath();
				
				//Character deserialization
				 try {
			         FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile());
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         c = (DDCharacter) in.readObject();
			         in.close();
			         fileIn.close();
				 }catch( IOException e) {
					 e.printStackTrace();
				 } catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
		}
		return c;
	}

	/**
	 * @return the cell
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}
}
