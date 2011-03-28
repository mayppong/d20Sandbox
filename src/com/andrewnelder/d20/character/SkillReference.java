package com.andrewnelder.d20.character;

import java.util.HashMap;


/**
 * <p>
 * This class contains information about any particular skill.  This
 * class exists so there is a local (non-db) means to obtain information
 * quickly and easily about any given class.  If more information is
 * required, the database may be referenced by the skill name.
 * </p>
 * 
 * <p>
 * <b>NOTE</b> -- Psionic skills are not supported.
 * </p>
 * 
 * <p>
 * <b>NOTE</b> -- It is important to remember that there are two 
 * 				  'Concentration' skills inside the database.  One of these
 * 				  is for Psionics and the other is General.
 * </p> 
 * 
 * @author andrewnelder
 */
public class SkillReference {
	
	public static HashMap<String, SkillInformation> SKILLS;
	
	static {
		
		SKILLS = new HashMap<String, SkillInformation>();
		
		// General Skills
		SKILLS.put("Appraise", 				new SkillInformation("Appraise","int",false,false ));
		SKILLS.put("Balance", 				new SkillInformation("Balance","dex",false,true));
		SKILLS.put("Bluff", 				new SkillInformation("Bluff","cha",false,false));
		SKILLS.put("Climb", 				new SkillInformation("Climb","str",false,true));
		SKILLS.put("Concentration", 		new SkillInformation("Concentration","con",false,false));
		SKILLS.put("Decipher Script", 		new SkillInformation("Decipher Script","int",true,false));
		SKILLS.put("Diplomacy", 			new SkillInformation("Diplomacy","cha",false,false));
		SKILLS.put("Disable Device", 		new SkillInformation("Disable Device","int",true,false));
		SKILLS.put("Disguise", 				new SkillInformation("Disguise","cha",false,false));
		SKILLS.put("Escape Artist", 		new SkillInformation("Escape Artist","dex",false,true));
		SKILLS.put("Forgery", 				new SkillInformation("Forgery","int",false,false));
		SKILLS.put("Gather Information", 	new SkillInformation("Gather Information","cha",false,false));
		SKILLS.put("Handle Animal", 		new SkillInformation("Handle Animal","cha",true,false));
		SKILLS.put("Heal", 					new SkillInformation("Heal","wis",false,false));
		SKILLS.put("Hide", 					new SkillInformation("Hide","dex",false,true));
		SKILLS.put("Intimidate", 			new SkillInformation("Intimidate","cha",false,false));
		SKILLS.put("Jump", 					new SkillInformation("Jump","str",false,true));
		SKILLS.put("Listen", 				new SkillInformation("Listen","wis",false,false));
		SKILLS.put("Move Silently", 		new SkillInformation("Move Silently","dex",false,true));
		SKILLS.put("Open Lock", 			new SkillInformation("Open Lock","dex",true,false));
		SKILLS.put("Ride", 					new SkillInformation("Ride","dex",false,false));
		SKILLS.put("Search", 				new SkillInformation("Search","int",false,false));
		SKILLS.put("Sense Motive", 			new SkillInformation("Sense Motive","wis",false,false));
		SKILLS.put("Sleight of Hand", 		new SkillInformation("Sleight of Hand","dex",true,true));
		SKILLS.put("Spellcraft", 			new SkillInformation("Spellcraft","int",true,false));
		SKILLS.put("Spot", 					new SkillInformation("Spot","wis",false,false));
		SKILLS.put("Survival", 				new SkillInformation("Survival","wis",false,false));
		SKILLS.put("Swim", 					new SkillInformation("Swim","str",false,true));
		SKILLS.put("Tumble", 				new SkillInformation("Tumble","dex",true,true));
		SKILLS.put("Use Magic Device", 		new SkillInformation("Use Magic Device","cha",true,false));
		SKILLS.put("Use Rope", 				new SkillInformation("Use Rope","dex",false,false));
		
		// Skills w/ Subtypes
		SkillInformation knowledgeSkill = new SkillInformation("Knowledge","int",true,false);
		SKILLS.put("Knowledge", knowledgeSkill);
		SKILLS.put("Knowledge - Arcana", 						knowledgeSkill);
		SKILLS.put("Knowledge - Architecture and Engineering", 	knowledgeSkill);
		SKILLS.put("Knowledge - Dungeoneering", 				knowledgeSkill);
		SKILLS.put("Knowledge - Geography", 					knowledgeSkill);
		SKILLS.put("Knowledge - History", 						knowledgeSkill);
		SKILLS.put("Knowledge - Local", 						knowledgeSkill);
		SKILLS.put("Knowledge - Nature", 						knowledgeSkill);
		SKILLS.put("Knowledge - Nobility and Royalty", 			knowledgeSkill);
		SKILLS.put("Knowledge - Religion", 						knowledgeSkill);
		SKILLS.put("Knowledge - The Planes", 					knowledgeSkill);
		
		SkillInformation craftSkill = new SkillInformation("Craft","int",true,false);
		SKILLS.put("Craft", craftSkill);
		SKILLS.put("Craft - Alchemy", 							craftSkill);
		SKILLS.put("Craft - Armor Smithing", 					craftSkill);
		SKILLS.put("Craft - Blacksmithing", 					craftSkill);
		SKILLS.put("Craft - Dream Weaving", 					craftSkill);
		SKILLS.put("Craft - Gem Cutting", 						craftSkill);
		SKILLS.put("Craft - Leather Working", 					craftSkill);
		SKILLS.put("Craft - Metal Working", 					craftSkill);
		SKILLS.put("Craft - Painting", 							craftSkill);
		SKILLS.put("Craft - Sculpting", 						craftSkill);
		SKILLS.put("Craft - Ship Making", 						craftSkill);
		SKILLS.put("Craft - Stone Masonry", 					craftSkill);
		SKILLS.put("Craft - Stone Working", 					craftSkill);
		SKILLS.put("Craft - Trap Making", 						craftSkill);
		SKILLS.put("Craft - Weapon Smithing", 					craftSkill);
		
		SkillInformation performSkill = new SkillInformation("Perform","cha",false,false);
		SKILLS.put("Perform", performSkill);
		SKILLS.put("Perform - Act", 							performSkill);
		SKILLS.put("Perform - Comedy", 							performSkill);
		SKILLS.put("Perform - Dance", 							performSkill);
		SKILLS.put("Perform - Keyboard Instruments", 			performSkill);
		SKILLS.put("Perform - Oratory", 						performSkill);
		SKILLS.put("Perform - Percussion Instruments", 			performSkill);
		SKILLS.put("Perform - Sing", 							performSkill);
		SKILLS.put("Perform - String Instruments", 				performSkill);
		SKILLS.put("Perform - Wind Instruments", 				performSkill);
		
		SkillInformation professionSkill = new SkillInformation("Profession","wis",true,false);
		SKILLS.put("Profession", professionSkill);
		SKILLS.put("Profession - Book Keeper", 					professionSkill);
		SKILLS.put("Profession - Hunter", 						professionSkill);
		SKILLS.put("Profession - Miner", 						professionSkill);
		SKILLS.put("Profession - Siege Engineer", 				professionSkill);
		
	}
	
	public static class SkillInformation implements Comparable<Object> {
		
		private String name;
		private String attribute;
		protected boolean isTrained;
		protected boolean needsArmorCheck;
		
		public SkillInformation(String skillName, String skillAttribute, boolean isTrained, boolean needsArmorCheck) {
			
			this.name = skillName;
			this.attribute = skillAttribute;
			this.isTrained = isTrained;
			this.needsArmorCheck = needsArmorCheck;
			
		}
		
		public String getName() 		{ return this.name; 		}
		public String getAttribute() 	{ return this.attribute; 	}
		
		@Override
		public int compareTo(Object o) throws ClassCastException {
			
			if (!(o instanceof SkillInformation))
				throw new ClassCastException("A Skill object expected.");
			
			int out = 1;
			
			if (this.getName().equals(((SkillInformation) o).getName()))
				out = 0;
			
			return out;
			
		}
		
	}
	
}
