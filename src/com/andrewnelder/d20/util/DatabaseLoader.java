package com.andrewnelder.d20.util;

import java.sql.*;

public interface DatabaseLoader {

	public Connection getConnection() throws ClassNotFoundException, SQLException;
	
}
