package com.andrewnelder.d20.character;

/**
 * Project: d20Sandbox
 * File: 	CharacterClass.java
 * Purpose: Retrieve character bonus based on character's class and level
 *
 * @author  Andrew Nelder, May Pongpitpitak
 * @version 0.1 	March 28, 2011
 */

import java.util.HashMap;

import com.andrewnelder.d20.util.Exceptions.AttributeNotFoundException;

public class Character {

	/* -----------------  
		The variables 
		----------------- */
	
	protected String 			charName;
	protected CharacterRace 	charRace;
	protected String 			charClass;
	
	protected static final String[] ATTRIBUTE_LIST = 
		new String[] { "str", "dex", "int", "con", "wis", "cha" };
	protected HashMap<String, Integer> attributes;
	
	// TODO: Add skill related features
	//private Collection<CharacterSkill> skills;

	
	
	/* -----------------  
		Character object 
		----------------- */
	
	public Character(String characterName, String characterClass, int characterLevel, CharacterRace characterRace) {

		charName 	= characterName;
		charRace 	= characterRace;
		charClass 	= characterClass;

		attributes 	= new HashMap<String, Integer>();
		for (String attribute : ATTRIBUTE_LIST) {
			attributes.put(attribute, 0);
		}

	}
	
	// Over-loading
	public Character(String name) {
		// String[] charClass = CharacterClass.getClassList();
		this(name, "Barbarian", 1, new CharacterRace(CharacterRace.Race.HUMAN));
	}

	
	
	/* -----------------  
		The setters 
		----------------- */
	
	public void setAttribute(String attributeKey, int attributeValue) throws AttributeNotFoundException {

		if (!attributes.keySet().contains(attributeKey)) {
			throw new AttributeNotFoundException(
					"Unknown Attribute: " + attributeKey);
		}

		attributes.put(attributeKey, attributeValue);

	}
	
	
	
	/* -----------------  
		The getters 
		----------------- */
	
	public HashMap<String, Integer> getAttributes() {

		HashMap<String, Integer> out = new HashMap<String, Integer>();

		for (String attributeKey : ATTRIBUTE_LIST) {
			try {
				out.put(attributeKey,
						attributes.get(attributeKey)
							+ charRace.getRacialModifier(attributeKey));
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return out;

	}

	
	
	/* -----------------  
		Main method 
		----------------- */
	
	public static void main(String[] args) {
		
		// TODO: User input information
		String charName  = "Broerd";
		String charClass = "Wizard";
		int charLevel	 = 7;
		
		// Create a new character
		Character ch = new Character(charName, charClass, charLevel, new CharacterRace(
				CharacterRace.Race.GNOME));

		for (String attribute : ATTRIBUTE_LIST) {
			try {
				ch.setAttribute(attribute, 10);
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		HashMap<String, Integer> attributes = ch.getAttributes();
		System.out.println(attributes);
	}

}