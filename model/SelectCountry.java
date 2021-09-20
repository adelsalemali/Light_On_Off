package com.adel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectCountry {

	 private String select = "select id , country from country"; 
	 
	 public List<Memebers> selectCountry(){   
		 
		 List<Memebers> list  = new ArrayList<Memebers>();
		 try { 
			    
				Connection con = DBMySQL.getConnection();
				PreparedStatement ps1 = con.prepareStatement(select); 
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
					 
					
					String country_name = rs1.getString("country"); 
					int country_id = rs1.getInt("id");
					list.add(new Memebers(country_id , country_name));   
				}
				
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		 return list ; 
	 }
}
