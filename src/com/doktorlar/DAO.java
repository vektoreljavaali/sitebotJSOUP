package com.doktorlar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class DAO extends DatataBaseConnections{
	  
		public int Kaydet(doktors doktor) throws Exception {

			DatataBaseConnections DB = new DatataBaseConnections();
			
			String SQL = " INSERT INTO tbldoktorlar(yorumsayisi, adsoyad, brans, url, relevances, adresname, adresfull, adreslocality, tel, googlemaps)	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
			newConnectDB();

			PreparedStatement pstmt = conn.prepareStatement(SQL.toString());

			pstmt.setString(1,doktor.getYorumsayisi());
			pstmt.setString(2, doktor.getAdsoyad());
			pstmt.setString(3, doktor.getBrans());
			pstmt.setString(4, doktor.getUrl());
			pstmt.setString(5, doktor.getRelevances());
			pstmt.setString(6, doktor.getAdresname());
			pstmt.setString(7, doktor.getAdresfull());
			pstmt.setString(8, doktor.getAdreslocalty());
			pstmt.setString(9, doktor.getTel());
			pstmt.setString(10, doktor.getGooglemaps());
			
			pstmt.executeUpdate();

			disconnectDB();

			return 1;
		}

	    
	
}
