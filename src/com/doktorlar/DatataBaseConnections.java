package com.doktorlar;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatataBaseConnections {

	public Connection conn = null;

	public void newConnectDB() {

		try {

				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBDoktorlar", "postgres", "root");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void disconnectDB() throws Exception {
		conn.close();
	}

	public java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
		java.sql.Date sqlDate = null;
		if (javaDate != null) {
			sqlDate = new java.sql.Date(javaDate.getTime());
		}
		return sqlDate;
	}
	
}
