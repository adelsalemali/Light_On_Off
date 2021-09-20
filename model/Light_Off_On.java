package com.adel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Light_Off_On {
	
	private String SelectLightState = "SELECT light FROM room WHERE id=?" ;
	private String UpdateLightState = "UPDATE room SET light=? WHERE id=?";
		     
		//We are going to make two methods 
	
	    //First method click About room on list to show you in URL id where you are .
		public Boolean getLight(Integer roomId){  
			try { 		
				
				Connection con = DBMySQL.getConnection();
				PreparedStatement ps1 = con.prepareStatement(SelectLightState);  
				ps1.setInt(1, roomId); 
				ResultSet rs1 = ps1.executeQuery();	
  
				   
				if(rs1.next()) {
					return rs1.getBoolean("light"); 
				} else {
					return null;
				}
				
			}catch (Exception e) { 
				e.printStackTrace();
				return null;
			}
			
		}
		
		//Here we update if true or false 
		public Boolean switchLight(Integer roomId){  
			try { 	
				
				Connection con = DBMySQL.getConnection();
				PreparedStatement ps1 = con.prepareStatement(SelectLightState);  
				ps1.setInt(1, roomId);
				ResultSet rs1 = ps1.executeQuery();	
				
				if(rs1.next()) {
					//UPDATE room SET light=? WHERE id=?
					boolean light = rs1.getBoolean("light"); 
					light = !light; 
					ps1 = con.prepareStatement(UpdateLightState);
					ps1.setBoolean(1, light);
					ps1.setInt(2, roomId);
					ps1.executeUpdate();
					return light;
				} else {
					return null;
				}				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
