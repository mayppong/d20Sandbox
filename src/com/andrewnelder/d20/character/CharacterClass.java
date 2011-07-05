package com.andrewnelder.d20.character;

/**
 * Project: d20Sandbox
 * File: 	CharacterClass.java
 * Purpose: Retrieve character bonus based on character's class and level
 *
 * @author  May Pongpitpitak
 * @version 0.1 	July 3, 2011
 */

import java.sql.*;
import java.util.*;

import com.andrewnelder.d20.srd.*;

public class CharacterClass {
	
	/* -----------------  
		The variables 
		----------------- */
	private String charClass;
	private int charLevel;
	private HashMap<String, Integer> classBonus;
	private ArrayList<String> classList;
	
	
	
	protected void setClassList() {
		// TODO: Generate a list of class from database
	}
	
	public ArrayList<String> getClassList() {
		return this.classList;
 	}
	
	
	CharacterClass(String charClass, int charLevel, HashMap<String, Integer> classBonus) {
		this.charClass = charClass;
		
	}
	CharacterClass(String charClass, int charLevel){
		setClassBonus(charClass, charLevel);
		this.classBonus = getClassBonus();
		CharacterClass(charClass, charLevel, classBonus);
	}
	
	
	
	/* -----------------  
		The setters 
		---------------- */
	public void setCharClass(String charClass, int charLevel) {
		this.charClass = charClass;
		setClassBonus(charClass, charLevel);
	}
	
	protected void setClassBonus(String charClass, int charLevel) {
		/**
		 * This function takes the character's class and level and return a hash map of bonuses
		 * return as (baseAtkBonus 1, baseAtkBonus 2, baseAtkBonus 3, baseAtkBonus 4, fortSave, refSave, willSave)
		 */
		SRDLoader srd = new SRDLoader();
		try {
			Connection connt = srd.getConnection();	
			try {	
				PreparedStatement stmt = connt.prepareStatement("SELECT name, level FROM class_table WHERE name = ? AND level = ?");
				stmt.setString(0, charClass);
				stmt.setInt(1, charLevel);
				ResultSet resultData = stmt.executeQuery();
				
				// Separate the attack bonuses
				while(resultData.next()){
					// Separate the base attack bonus
					Scanner baseAtkBonus = new Scanner(resultData.getString("base_atk_bonus"));
					for(int atkNum = 1; atkNum == 4; atkNum++) {
						if(baseAtkBonus.hasNextInt()) {
							this.classBonus.put("baseAtkBonus "+ atkNum, baseAtkBonus.nextInt());
						}
						else{
							this.classBonus.put("baseAtkBonus "+ atkNum, 0);
						}
					}
					this.classBonus.put("fortSave", Integer.parseInt(resultData.getString("fort_save")));
					this.classBonus.put("refSave",  Integer.parseInt(resultData.getString("ref_save")));
					this.classBonus.put("willSave", Integer.parseInt(resultData.getString("will_save")));
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
	public String getCharClass() {
		return this.charClass;
	}
	
	public HashMap<String, Integer> getClassBonus() {
		return this.classBonus;
	}



}
