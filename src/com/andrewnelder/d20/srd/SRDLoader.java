package com.andrewnelder.d20.srd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.andrewnelder.d20.util.DatabaseLoader;

public class SRDLoader implements DatabaseLoader {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager
				.getConnection("jdbc:sqlite:src/com/andrewnelder/d20/srd/resources/dnd35.db");
		return conn;

	}

}
