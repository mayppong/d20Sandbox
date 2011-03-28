package com.andrewnelder.d20.character;

import java.util.HashMap;

import com.andrewnelder.d20.util.Exceptions.AttributeNotFoundException;

public class Character {

	// Name, Race, Class
	protected String name;
	protected CharacterRace race;
	
	// TODO: Add unimplemented features
	//private Collection<CharacterClass> classes;
	//private Collection<CharacterSkill> skills;

	// Attributes
	protected static final String[] ATTRIBUTE_LIST = 
		new String[] { "str", "dex", "int", "con", "wis", "cha" };
	protected HashMap<String, Integer> attributes;

	public Character(String characterName, CharacterRace characterRace) {

		name = characterName;
		race = characterRace;

		attributes = new HashMap<String, Integer>();
		for (String attribute : ATTRIBUTE_LIST) {
			attributes.put(attribute, 0);
		}

	}

	public Character(String name) {
		this(name, new CharacterRace(CharacterRace.Race.HUMAN));
	}

	public void setAttribute(String attributeKey, int attributeValue) throws AttributeNotFoundException {

		if (!attributes.keySet().contains(attributeKey)) {
			throw new AttributeNotFoundException(
					"Unknown Attribute: " + attributeKey);
		}

		attributes.put(attributeKey, attributeValue);

	}

	public HashMap<String, Integer> getAttributes() {

		HashMap<String, Integer> out = new HashMap<String, Integer>();

		for (String attributeKey : ATTRIBUTE_LIST) {
			try {
				out.put(attributeKey,
						attributes.get(attributeKey)
							+ race.getRacialModifier(attributeKey));
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return out;

	}

	public static void main(String[] args) {
		Character ch = new Character("Broerd", new CharacterRace(
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
