package com.ntl.frs.bean;

public class PassengerBean {

	private String reservationID ; 
	private  String scheduleID;
	private  String name ;
	private  int age ;
	private  String gender;
	
	
	
	
	public PassengerBean() {
		super();
	}
	
	
	
	
	/**
	 * @param scheduleID
	 * @param name
	 * @param age
	 * @param gender
	 */
	public PassengerBean(String reservationID, String name, int age, String gender) {
		super();
		this.reservationID=reservationID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}




	public PassengerBean(String reservationID, String scheduleID, String name, int age, String gender) {
		super();
		this.reservationID = reservationID;
		this.scheduleID = scheduleID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}



	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	
}
