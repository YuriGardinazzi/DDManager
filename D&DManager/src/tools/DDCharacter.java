/**
 * 
 */
package tools;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuri
 * This class describes a general character
 */
public class DDCharacter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imagePath;
	private Map<String, String> textStatMap;
	public final String[] textStatKeys = new String[] {"Name","Alignment","Divinity",
												  "CharacterClass"};
	public final String[] numberStatKeys = new String[] {"HitPoints", "Level", "Experience", "Strength",
												  "Dexterity", "Constitution","Intelligence", "Wisdom",
												  	"Charisma"};
	private Map<String, Integer> numberStatMap;


	

	public DDCharacter() {
		this.textStatMap = new HashMap<String, String>();
		this.numberStatMap = new HashMap<String, Integer>();
		this.setImagePath("images" + File.separator + "character.jpg");
		this.setDefaultHashMap();
	}
	
	private void setDefaultHashMap() {

		for(String s : this.textStatKeys) {
			this.textStatMap.put(s, "Test");
		}
		for(String s : this.numberStatKeys) {
			this.numberStatMap.put(s, 0);
		}
	}

	
	public void setTextStat(String key, String value) {
		this.textStatMap.replace(key, value);
	}
	public void setNumberStat(String key, Integer value) {
		this.numberStatMap.replace(key, value);
	}
	
	public String getTextStat(String key) {
		return this.textStatMap.get(key);
	}
	
	public Integer getNumberStat(String key) {
		return this.numberStatMap.get(key);
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		String output = " ";
		for(String s : this.textStatMap.keySet()) {
			output += "\n" + s + " " + this.textStatMap.get(s);
		}
		for(String s : this.numberStatMap.keySet()) {
			output += "\n" + s + " " + this.numberStatMap.get(s);
		}
		
		return output;
	}

}
