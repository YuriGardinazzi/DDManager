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
	private  Integer maxLife;
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
		this.setMaxLife();
	}
	
	private void setDefaultHashMap() {

		for(String s : this.textStatKeys) {
			this.textStatMap.put(s, "Test");
		}
		for(String s : this.numberStatKeys) {
			this.numberStatMap.put(s, 0);
		}
	}

	public void healDamage(Integer healValue) {
		Integer lifeAfterHeal = this.getNumberStat("HitPoints") + healValue;
		if(lifeAfterHeal <= this.getMaxLife()) {
			this.setNumberStat("HitPoints", lifeAfterHeal);
		}else {
			this.setNumberStat("HitPoints", this.getMaxLife());
		}
	}
	
	/**
	 * Add damages to a character and reduce his hitPoints
	 * @param damagePoints damage to deal
	 */
	public void dealDamage(Integer damagePoints) {
		Integer lifeAfterDamage = this.getNumberStat("HitPoints") - damagePoints;
		if(lifeAfterDamage >= 0){
			this.setNumberStat("HitPoints", lifeAfterDamage);
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


	/**
	 * @return the value of the total life
	 */
	public Integer getMaxLife() {
		return maxLife;
	}

	/**
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
