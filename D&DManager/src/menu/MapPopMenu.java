/**
 * 
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

import player_map.Cell;
import player_map.GridPanel;
import tools.DDCharacter;

/**
 * @author Yuri
 * Popup menu that displays what you can do with the characters on the map
 * Like adding and removing a character or changing his position on the map
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
	private JMenuItem updateCharacterItem;
	private GridPanel grid;
	private Cell cell;
	
	/**
	 * Constructor
	 * @param c  cell where the Menu should appear
	 * @param grid grid where the cell is placed
	 */
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
		
		this.displayMoveOrPlaceItems();
		this.displayUpdateCharacterItem();
	}

	/**
	 * Add the button Move or Show to the PopUp menu
	 * if the user is already changing the position of a character display "Place" button
	 * otherwise show the "Move" button
	 */
	private void displayMoveOrPlaceItems() {
		
		if(this.getCell().getCharacter() == null && this.getGrid().isCharacterMoving() == false) {
			return;
		} 
		if(this.getGrid().isCharacterMoving()) {
			this.addPlaceItem();
		}else {
			this.addMoveItem();
		}
	}
	/**
	 * Displays the update button if there's a character on the cell
	 * it rewrites the character file (*.ddc) with the character in the cell
	 * If there's not a character it removes the "update" button if it was present
	 */
	private void displayUpdateCharacterItem() {
		if(this.getCell().getCharacterPath() != null) {
			this.updateCharacterItem = new JMenuItem("Update stats");
			this.updateCharacterItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						FileOutputStream fOut = new FileOutputStream(getCell().getCharacterPath());
						ObjectOutputStream objOut = new ObjectOutputStream(fOut);
						objOut.writeObject(getCell().getCharacter());
						objOut.close();						
			        } catch (Exception ex) {
			        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
			            ex.printStackTrace();
			        }
			    }
					
				});
			this.add(this.updateCharacterItem);
		}else {
			if(this.updateCharacterItem != null) {
				this.remove(this.updateCharacterItem);
			}
		}
	
	}
	/**
	 * add the button "Place" to the PopUp menu and remove the button "Move"
	 */
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
	
	/**
	 * add the button "Move" to the PopUp menu and remove the button "Place"
	 */
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
	 * This functions returns a DDCharacter object from a *.ddc file choosed from the user
	 * and updates characterPath field of the Cell
	 * @return DDCharacter
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
		if(returnVal == JFileChooser.APPROVE_OPTION) {

			if(chooser.getSelectedFile().getPath() != null) {		
				//Character deserialization
				 try {
			         FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile());
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         c = (DDCharacter) in.readObject();
			         in.close();
			         fileIn.close();
			         
			         //update cell
			         this.getCell().setCharacterPath(chooser.getSelectedFile().getPath());
			     
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
