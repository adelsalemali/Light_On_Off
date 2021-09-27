package com.adel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListData {

         //We want to make a list with id , name and country
	     private  String SelectBouth =
	     "SELECT room.id , room.room, country.country FROM room INNER JOIN country ON room.country_id = country.id";
	     
	     private  String SelectRoom =
	     "SELECT room.room, country.country FROM room INNER JOIN country ON room.country_id = country.id WHERE room.id = ?";
	     
	
	public List<Memebers> getCountry(){  
		
		//List of (members class) 
		List<Memebers> list  = new 	ArrayList<Memebers>();
		
		try (
			
			Connection con = DBMySQL.getConnection();
			PreparedStatement ps1 = con.prepareStatement(SelectBouth); 
			ResultSet rs1 = ps1.executeQuery();	
			
			
			){
			System.out.println("List :"  + ps1);
			System.out.println("ResultSet :"  + rs1);      
			
			//Here we want to show users a list of information when they create their group
			while(rs1.next()) {
				
				int id = rs1.getInt("id");
				String name = rs1.getString("room");
				String country = rs1.getString("country");
				list.add(new  Memebers(id, name , country)); 	 
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list ;
	}
 
	
	// Here we use select room and country by id if user writes a number does not exit on list we give him (sendError)
	public Memebers getRoom(Integer id){  
		try { 
			Connection con = DBMySQL.getConnection();
			PreparedStatement ps1 = con.prepareStatement(SelectRoom); 
			ps1.setInt(1, id);
			ResultSet rs1 = ps1.executeQuery();	
			if(rs1.next()) {
				String name = rs1.getString("room");
				String country = rs1.getString("country");
				return new Memebers(id, name , country); 	 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
