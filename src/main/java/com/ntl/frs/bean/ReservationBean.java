package com.ntl.frs.bean;

import java.time.LocalDate;

public class ReservationBean {

	private String reservationID;
	private String scheduleID;
	private String userID;
	private LocalDate bookingDate;
	private LocalDate journeyDate;
	private int noOfSeats;
	private double totalFare;
	private String bookingStatus;
	/**
	 * 
	 */
	public ReservationBean() {
		super();
	}
	/**
	 * @param reservationID
	 * @param scheduleID
	 * @param userID
	 * @param bookingDate
	 * @param journeyDate
	 * @param noOfSeats
	 * @param totalFare
	 * @param bookingStatus
	 */
	public ReservationBean(String reservationID, String scheduleID, String userID, LocalDate bookingDate,
			LocalDate journeyDate, int noOfSeats, double totalFare, String bookingStatus) {
		super();
		this.reservationID = reservationID;
		this.scheduleID = scheduleID;
		this.userID = userID;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the reservationID
	 */
	public String getReservationID() {
		return reservationID;
	}
	/**
	 * @param reservationID the reservationID to set
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	/**
	 * @return the scheduleID
	 */
	public String getScheduleID() {
		return scheduleID;
	}
	/**
	 * @param scheduleID the scheduleID to set
	 */
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the journeyDate
	 */
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	/**
	 * @return the noOfSeats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}
	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	/**
	 * @return the totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}
	/**
	 * @param totalFare the totalFare to set
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	/**
	 * @return 
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReservationBean [reservationID=" + reservationID + ", scheduleID=" + scheduleID + ", userID=" + userID
				+ ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", bookingStatus=" + bookingStatus + "]";
	}
	
	
	
	/**
	 * 
	 */
	
	
}