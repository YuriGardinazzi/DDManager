package menu;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import layout.*;
import player_map.GridPanel;
import tools.DDCharacter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MyMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeftPanel leftP;
	private GridPanel grid;
	
	
	public MyMenu(LeftPanel p, GridPanel g) {
		super();
		this.setLeftP(p);
		this.setGrid(g);
		//menu building
		JMenu menu = new JMenu("Options");
		JMenuItem menuItem;

		this.add(menu);
		
		
		//change profile picture
		MenuItemChangeProPic proPicItem = new MenuItemChangeProPic(this.getLeftP());

		menu.add(proPicItem);
		
		
		//Save file item, shortcut Ctrl + S
		menuItem = new JMenuItem("Save Map", new ImageIcon("defaults/save_icon.png"));		
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					saveMapDialog();
				}
	
		});
		
		menu.add(menuItem); 
		
		menuItem = new JMenuItem("Upload Map");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uploadMapDialog();		
			}
		});
		menu.add(menuItem);
		NewCharacter characterCreationItem = new NewCharacter();
		menu.add(characterCreationItem);
		
		menuItem = new JMenuItem("Modify a character");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = showChooseFileDialog(false);
				try {
					FileInputStream fileIn = new FileInputStream(path);
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         DDCharacter inputChar = (DDCharacter) in.readObject();
			         in.close();
			         fileIn.close();
			         CharacterCreation modify = new CharacterCreation("Modify " + inputChar.getTextStat("Name"),
			        		 											inputChar);	
			        		 
			         
		        } catch (Exception ex) {
		        	
		            ex.printStackTrace();
		        }
		    }	
		});
		
		menu.add(menuItem);
	}


	/**
	 * Create a File chooser box dialog and get a *.ddm file from the user
	 * @return name of the file choosen by the user
	 */
	private String showChooseFileDialog(boolean isMap) {
		FileNameExtensionFilter filter = null;
		if(isMap) {
			filter = new FileNameExtensionFilter("D&D Map", "ddm");
		}else {
			filter = new FileNameExtensionFilter(
					"D&D character", "ddc");
		}
		
		JFileChooser chooser = new JFileChooser();
					 chooser.setFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
		int retrieval = chooser.showSaveDialog(this.getParent());
		
		if(retrieval == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
			
		}
			
		return null;
		
		
	}
	
	private GridPanel uploadMapDialog() {
		GridPanel map = null;
		String file = this.showChooseFileDialog(true);
		if(file != null) {
			try {
				System.out.println("trie to take: " + file);
				FileInputStream fileIn = new FileInputStream(file);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         GridPanel newGrid = (GridPanel) in.readObject();
		         in.close();
		         fileIn.close();
		         this.getGrid().updateGrid(newGrid);
			}catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
		}
		
		return map;
	}
	/**
	 * Show the save dialog for the grid
	 */
	private void saveMapDialog() {
		String file = this.showChooseFileDialog(true);
		System.out.println("Path: "+ file);
		if (file != null) {
			try {
					FileOutputStream fOut = new FileOutputStream(file+ ".ddm");
					ObjectOutputStream objOut = new ObjectOutputStream(fOut);
					objOut.writeObject(getGrid());
					objOut.close();
					JOptionPane.showMessageDialog(null,  "Grid Has been saved");
					
		        } catch (Exception ex) {
		        	JOptionPane.showMessageDialog(null, "Something went wrong :C");
		            ex.printStackTrace();
		        }
		    }		
	}
	
	/**
	 * @return the leftP
	 */
	public LeftPanel getLeftP() {
		return leftP;
	}

	/**
	 * @param leftP the leftP to set
	 */
	public void setLeftP(LeftPanel leftP) {
		this.leftP = leftP;
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
