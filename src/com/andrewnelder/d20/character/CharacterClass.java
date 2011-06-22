package com.andrewnelder.d20.character;

import java.sql.*;
import java.util.*;
import com.andrewnelder.d20.srd.resources.*;

/**
 * Project: d20Sandbox
 * File: 	CharacterClass.java
 * Purpose: Retrieve character bonus based on character's class and level
 *
 * @author May Pongpitpitak
 * @version 0.1 	March 28, 2011
 */

public class CharacterClass {
	
	/**
	 * 
	 */
	public static ArrayList<Integer> getClassBonus(String charClass, int charLevel) {
		
		try {
			
			Connection connt = DriverManager.getConnection("com.andrewnelder.d20.srd.resources.dnd35.db");
			
			try {
				
				PreparedStatement stmt = connt.prepareStatement("SELECT name, level FROM class_table WHERE name = ? AND level = ?");
				stmt.setString(0, charClass);
				stmt.setInt(1, charLevel);
				
				ResultSet resultData = stmt.executeQuery();
				
				// Separate the attack bonuses
				HashMap<String, Integer> classBonus = new HashMap<String, Integer>(); 		// should I use hashmap? would that be easier?
				while(resultData.next()){
					
					String baseAtkBonus = resultData.getString("base_atk_bonus");
					for(int atkNum = 1; atkNum == 4; atkNum++) {
						classBonus.put("baseAtkBonus "+ atkNum, baseAtkBonus.nextInt);
					}

					classBonus.put("fortSave", Integer.parseInt(resultData.getString("fort_save")));
					classBonus.put("refSave", Integer.parseInt(resultData.getString("ref_save")));
					classBonus.put("willSave", Integer.parseInt(resultData.getString("will_save")));
				}
			}
			
			finally {
				connt.close();
			}
		}
		catch (SQLException sqlError) {
			sqlError.printStackTrace();
		}
	
		return classBonus;
		
	}
}
