package com.andrewnelder.d20.character;

/**
 * Project: d20Sandbox
 * File: 	CharacterClass.java
 * Purpose: Retrieve from database and store character's 
 * 			class name, class level and bonuses
 *
 * @author  May Pongpitpitak
 * @version 0.1 	July 6, 2011
 */

import java.sql.*;
import java.util.*;

import com.andrewnelder.d20.srd.*;

public class CharacterClass {
	
	/* -----------------  
		The variables 
		----------------- */
	
	private String 						charClassName;
	private int 						charClassLevel;
	private HashMap<String, Integer> 	charClassBonus;
	
	
	
	/* -----------------  
		CharacterClass 
		---------------- */
	
	CharacterClass(String charClassName, int charClassLevel) {
		this.charClassName  	= charClassName;
		this.charClassLevel 	= charClassLevel;
		setcharClassBonus(charClassName, charClassLevel);
	}
	
	
	
	/* -----------------  
		The setters 
		---------------- */
	
	protected void setcharClassBonus(String charClassName, int charClassNameLevel) {
		/**
		 * This function takes the character's class and level and return a hash map of bonuses
		 * return as (baseAtkBonus 1, baseAtkBonus 2, baseAtkBonus 3, baseAtkBonus 4, fortSave, refSave, willSave)
		 */
		SRDLoader srd = new SRDLoader();
		try {
			Connection connt = srd.getConnection();	
			try {	
				PreparedStatement stmt = connt.prepareStatement("SELECT name, level FROM class_table WHERE name = ? AND level = ?");
				stmt.setString(0, charClassName);
				stmt.setInt(1, charClassNameLevel);
				ResultSet resultData   = stmt.executeQuery();
				
				// Separate the attack bonuses
				while(resultData.next()){
					// Separate the base attack bonus
					Scanner baseAtkBonus = new Scanner(resultData.getString("base_atk_bonus"));
					for(int atkNum = 1; atkNum == 4; atkNum++) {
						if(baseAtkBonus.hasNextInt()) {
							this.charClassBonus.put("baseAtkBonus "+ atkNum, baseAtkBonus.nextInt());
						}
						else{
							this.charClassBonus.put("baseAtkBonus "+ atkNum, 0);
						}
					}
					this.charClassBonus.put("fortSave", Integer.parseInt(resultData.getString("fort_save")));
					this.charClassBonus.put("refSave",  Integer.parseInt(resultData.getString("ref_save")));
					this.charClassBonus.put("willSave", Integer.parseInt(resultData.getString("will_save")));
				}
			}
			finally {
				connt.close();
			}
		}
		catch (SQLException sqlError) {
			sqlError.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/* -----------------  
		The getters 
		---------------- */
	
	public String getcharClassName() {
		return this.charClassName;
	}
	
	public int getCharClassLevel() {
		return this.charClassLevel;
	}
	
	public HashMap<String, Integer> getcharClassBonus() {
		return this.charClassBonus;
	}

}