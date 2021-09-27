package com.adel.model;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {

private final String INSERT = "INSERT INTO room (room , country_id) values (?,?)"; 

	
	// Insert New Members
	public void insertNewMebers(Memebers memebers) {  
		
		try
		(
			Connection con = DBMySQL.getConnection();
			
		){
			PreparedStatement ps = con.prepareStatement(INSERT); 
			
			//Here we let user writes his group and his country
			ps.setString(1, memebers.getRoom_name());
			ps.setInt(2, memebers.getCountry_id());  
			ps.executeUpdate();
			
			System.out.println("PreparedStatement" + ps); 
			
		}catch (Exception e) {
			
			e.printStackTrace();
	}	
  }
}
