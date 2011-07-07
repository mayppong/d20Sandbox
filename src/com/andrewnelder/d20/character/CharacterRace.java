package com.andrewnelder.d20.character;

/**
 * Project: d20Sandbox
 * File: 	CharacterClass.java
 * Purpose: Create and store character's race, and bonuses
 *
 * @author  Andrew Nelder
 * @version 0.1 	March 28, 2011
 */

import java.util.HashMap;

import com.andrewnelder.d20.util.Exceptions.AttributeNotFoundException;

public class CharacterRace {

	private String name;
	private HashMap<String, Integer> mods;

	static enum Race {

		/*
		 * RACE       Name      [str dex int con wis cha]
		 */
		HUMAN		("Human",     0,  0,  0,  0,  0,  0),
		DWARF		("Dwarf",     0,  0,  0, +2,  0, -2),
		ELF			("Elf",       0, +2,  0, -2,  0,  0),
		GNOME		("Gnome",    -2,  0,  0, +2,  0,  0),
		HALF_ELF	("Half-Elf",  0,  0,  0,  0,  0,  0),
		HALF_ORC	("Half-Orc", +2,  0, -2,  0,  0, -2),
		HALFLING	("Halfling", -2, +2,  0,  0,  0,  0);

		private String name;
		private HashMap<String, Integer> mods;

		private Race(String name, int strengthModifier, int dexterityModifier,
				int intelligenceModifier, int constitutionModifier,
				int wisdomModifier, int charismaModifier) {
			this.name = name;
			this.mods = new HashMap<String, Integer>();
			this.mods.put("str", strengthModifier);
			this.mods.put("dex", dexterityModifier);
			this.mods.put("int", intelligenceModifier);
			this.mods.put("con", constitutionModifier);
			this.mods.put("wis", wisdomModifier);
			this.mods.put("cha", charismaModifier);
		}

		public String getName() {
			return this.name;
		}

		public HashMap<String, Integer> getModifiers() {
			return this.mods;
		}

	}

	CharacterRace(Race race) {
		this.name = race.getName();
		this.mods = race.getModifiers();
	}

	public int getRacialModifier(String attributeKey)
			throws AttributeNotFoundException {

		if (!this.mods.keySet().contains(attributeKey)) {
			throw new AttributeNotFoundException(
					"Unknown Attribute: " + attributeKey);
		}

		return this.mods.get(attributeKey);

	}

	public String getName() {
		return this.name;
	}

}
