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
 * This class describes the Character that the applications handle
 */
public class DDCharacter implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imagePath = "defaults" + File.separator + "character.jpg";
	private  Integer maxLife;
	private Map<String, String> textStatMap;
	public final String[] textStatKeys = new String[] {"Name","Alignment","Divinity",
												  "CharacterClass"};
	public final String[] numberStatKeys = new String[] {"HitPoints", "Level", "Experience", "Strength",
												  "Dexterity", "Constitution","Intelligence", "Wisdom",
												  	"Charisma"};
	private Map<String, Integer> numberStatMap;


	
	/**
	 * Initialize the default Character of the application
	 */
	public DDCharacter() {
		this.textStatMap = new HashMap<String, String>();
		this.numberStatMap = new HashMap<String, Integer>();
		this.setDefaultHashMap();
		this.setMaxLife();
	}
	
	/**
	 * Set defaults value of the character
	 */
	private void setDefaultHashMap() {

		for(String s : this.textStatKeys) {
			this.textStatMap.put(s, "Test");
		}
		for(String s : this.numberStatKeys) {
			this.numberStatMap.put(s, 0);
		}
	}

	/**
	 * Add a number to HitPoints stats
	 * @param healValue value added
	 */
	public void healDamage(Integer healValue) {
		Integer lifeAfterHeal = this.getNumberStat("HitPoints") + healValue;
		if(lifeAfterHeal <= this.getMaxLife()) {
			this.setNumberStat("HitPoints", lifeAfterHeal);
		}else {
			this.setNumberStat("HitPoints", this.getMaxLife());
		}
	}
	
	/**
	 * Reduce hitPoints value by a number
	 * @param damagePoints value to subtruct
	 */
	public void dealDamage(Integer damagePoints) {
		Integer lifeAfterDamage = this.getNumberStat("HitPoints") - damagePoints;
		if(lifeAfterDamage >= 0){
			this.setNumberStat("HitPoints", lifeAfterDamage);
		}else {
			this.setNumberStat("HitPoints", 0);
		}
	}
	/**
	 * Set a textual statistic of the character
	 * @param key name of the value to change
	 * @param value new value to set
	 */
	public void setTextStat(String key, String value) {
		this.textStatMap.replace(key, value);
	}
	/**
	 * Set a numerical statistic of the character
	 * @param key name of the statistic to change 
	 * @param value new value to set
	 */
	public void setNumberStat(String key, Integer value) {
		this.numberStatMap.replace(key, value);
	}
	
	
	/**
	 * Get a textual statistic of the character
	 * @param key name of the statistic to get
	 * @return value of that statistic
	 */
	public String getTextStat(String key) {
		return this.textStatMap.get(key);
	}
	
	/**
	 * Get a numerical statistic of the character
	 * @param key name of the statistic to get
	 * @return value of that statistic
	 */
	public Integer getNumberStat(String key) {
		return this.numberStatMap.get(key);
	}
	/**
	 * Get the character's image path
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Set the character's image path
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	/**
	 * @return the value of the total life of the character
	 */
	public Integer getMaxLife() {
		return maxLife;
	}

	
	/**
	 * Set the maximum life of the character equal to the HitPoints value
	 * @param maxLife the maxLife to set
	 */
	public void setMaxLife() {
		this.maxLife = this.getNumberStat("HitPoints");
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
