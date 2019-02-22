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
import player_map.GridPanel;
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

	private JMenuItem addCharacterItem;
	private JMenuItem removeCharacterItem;
	private JMenuItem moveCharacterItem;
	private JMenuItem placeCharacterItem;
	private GridPanel grid;
	private Cell cell;
	
	public MapPopMenu(Cell c, GridPanel grid) {
		this.setCell(c);
		this.setGrid(grid);
		this.addCharacterItem = new JMenuItem("Add new character");
		this.addCharacterItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DDCharacter c = retrieveCharacter();
				getCell().addElement(c);

			}
		});
		this.add(this.addCharacterItem);
		
		this.removeCharacterItem = new JMenuItem("remove character");
		this.removeCharacterItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//remove a character if present
				getCell().removeElement();
				
			}
		});
		this.add(this.removeCharacterItem);
		this.displayShowOrPlaceItems();
	}

	private void displayShowOrPlaceItems() {
		if(this.getGrid().isCharacterMoving()) {
			this.addPlaceItem();
		}else {
			this.addMoveItem();
		}
	}
	
	private void addPlaceItem() {
		//remove MoveButton if present
		if(this.moveCharacterItem != null) {
			this.remove(this.moveCharacterItem);
			this.moveCharacterItem = null;
		}
		this.placeCharacterItem = new JMenuItem("Place");
		this.placeCharacterItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				getCell().addElement(getGrid().getMovedCharacter());
				getGrid().setMovedCharacter(null);
			}
		});
		this.add(this.placeCharacterItem);
	}
	
	public void addMoveItem() {
		if(this.placeCharacterItem != null) {
			this.remove(this.placeCharacterItem);
			this.placeCharacterItem = null;
		}
		
		this.moveCharacterItem = new JMenuItem("Move");
		this.moveCharacterItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getCell().getCharacter() != null) {
					getGrid().setMovedCharacter(getCell().getCharacter());
					getCell().removeElement();
				}
				
			}
		});
		
		this.add(this.moveCharacterItem);
	}
	
	/**
	 * This functions returns a character object from a *.ddc file choosed from the user
	 * @return character object
	 */
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

	/**
	 * @return the grid
	 */
	public GridPanel getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(GridPanel grid) {
		this.grid = grid;
	}
}
