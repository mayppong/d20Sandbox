package com.andrewnelder.d20.character;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewnelder.d20.srd.SRDLoader;

public class ClassReference {
	
	Logger logger = LoggerFactory.getLogger(ClassReference.class);
	
	public static void main(String[] args) {
		
		SRDLoader srd = new SRDLoader();
		try {
			Connection conn = srd.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT name, type, alignment, class_skills FROM class WHERE type NOT LIKE '%psionic%';");
			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("[ Name: " + rs.getString("name") + " ]\n");
				sb.append("[ Type: " + rs.getString("type") + " ]\n");
				sb.append("[ Alignment: " + rs.getString("alignment") + " ]\n");
				sb.append("[ Skills: " + rs.getString("class_skills") + " ]\n");
				sb.append("\n");
				System.out.println(sb.toString());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
