package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphical_components.FormLabel;
import graphical_components.FormNumber;
import graphical_components.FormTextField;
import tools.DDCharacter;

/**
 * @author Yuri
 * This class describes the window that handle the character creation 
 *
 */
public class CharacterCreation extends JFrame {

	private static final long serialVersionUID = 1L;
	//TODO: aggiungere random button
	private FormLabel labelName = new FormLabel("Name");
	private FormTextField textName = new FormTextField("name", 16);
	private FormLabel labelAlignment = new FormLabel("Alignment");
	private FormTextField textAlign = new FormTextField("chaotic-evil", 16);
	private FormLabel labelDivinity = new FormLabel("Divinity");
	private FormTextField textDivinity = new FormTextField("Boccob", 16);
	private FormLabel labelLevel = new FormLabel("Level");
	private FormNumber numLevel = new FormNumber();
	private FormLabel labelExp = new FormLabel("Experience");
	private FormNumber numExp = new FormNumber();
	private FormLabel labelStrength = new FormLabel("Strength");
	private FormNumber numStr = new FormNumber();
	private FormLabel labelDex = new FormLabel("Dexterity");
	private FormNumber numDex = new FormNumber();
	private FormLabel labelConst = new FormLabel("Constitution");
	private FormNumber numConst = new FormNumber();
	private FormLabel labelInt = new FormLabel("Intelligence");
	private FormNumber numInt = new FormNumber();
	private FormLabel labelWis = new FormLabel("Wisdom");
	private FormNumber numWis = new FormNumber();
	private FormLabel labelChar = new FormLabel("Charisma");
	private FormNumber numChar = new FormNumber();
	
	/**
	 * Create the CharacterCreation window
	 */
	public CharacterCreation() {
		super("");
		this.CreateGUI();
	}
	/**
	 * Create the CharacterCreation window with a given name
	 * @param title
	 */
	public CharacterCreation(String title) {
		super(title);
		this.CreateGUI();
	}

	public void CreateGUI() {
		CustomPanel form = this.CreateForm(new Dimension(20,40), Color.cyan);
		
		this.add(form);
		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public CustomPanel CreateForm(Dimension ratio, Color bg) {
		CustomPanel form = new CustomPanel(ratio, bg);
		form.setLayout(new GridBagLayout());
		
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;

		//Name fields
	
		form.add(labelName, cons);
		
		cons.gridx = 1;

		form.add(textName, cons);
		
		cons.gridy++;
		cons.gridx = 0;
	
		//Alignment fields
	
		form.add(labelAlignment, cons);
		
		cons.gridx = 1;
	
		form.add(textAlign, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Divinity fields
	
		form.add(labelDivinity, cons);
		
		cons.gridx = 1;
		
		form.add(textDivinity, cons);
		
		cons.gridy++;
		cons.gridx = 0;
	
		//Level fields
	
		form.add(labelLevel, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numLevel, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Experience fields
		
		form.add(labelExp, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numExp, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Strength fields
		
		form.add(labelStrength, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
	
		form.add(numStr, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Dexterity fields

		form.add(labelDex, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
	
		form.add(numDex, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Constitution fields
		
		form.add(labelConst, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
	
		form.add(numConst, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Intelligence fields

		form.add(labelInt, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
		
		form.add(numInt, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Wisdom fields
		
		form.add(labelWis, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;

		form.add(numWis, cons);
		
		cons.gridy++;
		cons.gridx = 0;
		
		//Charisma fields
		
		form.add(labelChar, cons);
		
		cons.gridx = 1;
		cons.anchor = GridBagConstraints.CENTER;
	
		form.add(numChar, cons);

		
		//Save Button
		
		cons.gridy++;
		cons.gridx = 1;
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DDCharacter c = new DDCharacter(textName.getText(), textAlign.getText(),
												textDivinity.getText(), numLevel.getNumber(),
												numExp.getNumber(), numStr.getNumber(),
												numDex.getNumber(), numConst.getNumber(),
												numInt.getNumber(), numWis.getNumber(), numChar.getNumber());
				
				System.out.println(c);
			}
		});
		
		
		form.add(save,cons);
		
		
		
		
		return form;
	}
	
}
