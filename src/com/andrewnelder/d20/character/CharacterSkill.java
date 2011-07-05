package com.andrewnelder.d20.character;

import java.sql.*;
import java.util.*;
import com.andrewnelder.d20.srd.resources.*;

/**
 * Project: d20Sandbox
 * File: 	CharacterSkill.java
 * Purpose: Retrieve character bonus based on character's class and level
 *
 * @author  May Pongpitpitak
 * @version 0.1 	July 4, 2011
 */

public class CharacterSkill {
	
	private List<String> skillList;
	
	public List<String> getSkill() {
		return this.skillList;		
	}
}
