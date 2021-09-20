package com.adel.model;

public class Memebers {

		//Variables
		private int room_id  , country_id  , roomcountry_id;   
		private String room_name , country_name  ;
		
		
		//For inserting
		public Memebers(String room_name, Integer country_id) {
			super();
			this.room_name = room_name;
			this.country_id = country_id;
		}

		//To show list with information
		public Memebers(int room_id, String room_name, String country_name) {
			super();
			this.room_id = room_id; 
			this.room_name = room_name;
			this.country_name = country_name;
		}
         //
		public Memebers(int country_id, String country_name) { 
			super();
			this.country_id = country_id;
			this.country_name = country_name;
		}

		//Using getters and setters
		public int getRoom_id() {
			return room_id;
		}

		public void setRoom_id(int room_id) {
			this.room_id = room_id;
		}

		public int getCountry_id() {
			return country_id;
		}

		public void setCountry_id(int country_id) {
			this.country_id = country_id;
		}

		public int getRoomcountry_id() {
			return roomcountry_id;
		}

		public void setRoomcountry_id(int roomcountry_id) {
			this.roomcountry_id = roomcountry_id;
		}

		public String getRoom_name() {
			return room_name;
		}

		public void setRoom_name(String room_name) {
			this.room_name = room_name;
		}

		public String getCountry_name() {
			return country_name;
		}

		public void setCountry_name(String country_name) {
			this.country_name = country_name;
		}
		
		
		
		
   }

