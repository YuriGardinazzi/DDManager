/**
 * 
 */
package tools;

import java.io.Serializable;

/**
 * @author Yuri
 * This class describes a general character
 */
public class DDCharacter implements Serializable {

	private String imagePath;
	private String name;
	private String alignment;
	private String divinity;
	private String charClass;
	
	
	private Integer level;
	private Integer experience;
	private Integer strength;
	private Integer	dexterity;
	private Integer	constitution;
	private Integer	intelligence;
	private Integer	wisdom;
	private Integer charisma;
	

	
	/**
	 * Constructor of the character 
	 * @param name
	 * @param alignment
	 * @param divinity
	 * @param level
	 * @param experience
	 * @param strength
	 * @param dexterity
	 * @param constitution
	 * @param intelligence
	 * @param wisdom
	 * @param charisma
	 */
	public DDCharacter(
						String imagePath,
						String name, String alignment, String divinity,
						String charClass,Integer level, Integer experience,
						Integer strength, Integer dexterity,
						Integer constitution, Integer intelligence, Integer wisdom,
						Integer charisma) {
		super();
		this.setImagePath(imagePath);
		this.setName(name);
		this.setAlignment(alignment);
		this.setDivinity(divinity);
		this.setCharClass(charClass);
		this.setLevel(level);
		this.setExperience(experience);
		this.setStrength(strength);
		this.setDexterity(dexterity);
		this.setConstitution(constitution);
		this.setIntelligence(intelligence);
		this.setWisdom(wisdom);
		this.setCharisma(charisma);
	}
	
	@Override
	public String toString() {
		return("Character stats:\n " +
			   "\nImagePath"+ this.getImagePath() +
			   "\nName: " + this.getName() +
			   "\nAlignment: "+ this.getAlignment()+
			   "\nDivinity: "+ this.getDivinity() + 
			   "\nClass: " + this.getClass() +
			   "\nLevel: "+ this.getLevel()+
			   "\nExperience: "+ this.getExperience()+
			   "\nStrength: "+ this.getStrength()+
			   "\nDexterity: "+ this.getDexterity() +
			   "\nConstitution: " + this.getConstitution()+
			   "\nIntelligence: "+ this.getIntelligence() +
			   "\nWisdom: "+ this.getWisdom() +
			   "\nCharisma: "+ this.getCharisma());
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}
	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	/**
	 * @return the divinity
	 */
	public String getDivinity() {
		return divinity;
	}
	/**
	 * @param divinity the divinity to set
	 */
	public void setDivinity(String divinity) {
		this.divinity = divinity;
	}
	/**
	 * @return the strength
	 */
	public Integer getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	/**
	 * @return the dexterity
	 */
	public Integer getDexterity() {
		return dexterity;
	}
	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	/**
	 * @return the costitution
	 */
	public Integer getConstitution() {
		return constitution;
	}
	/**
	 * @param costitution the costitution to set
	 */
	public void setConstitution(Integer costitution) {
		this.constitution = costitution;
	}
	/**
	 * @return the intelligence
	 */
	public Integer getIntelligence() {
		return intelligence;
	}
	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	/**
	 * @return the wisdom
	 */
	public Integer getWisdom() {
		return wisdom;
	}
	/**
	 * @param wisdom the wisdom to set
	 */
	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}
	/**
	 * @return the charisma
	 */
	public Integer getCharisma() {
		return charisma;
	}
	/**
	 * @param charisma the charisma to set
	 */
	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	/**
	 * @return the charClass
	 */
	public String getCharClass() {
		return charClass;
	}

	/**
	 * @param charClass the charClass to set
	 */
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
