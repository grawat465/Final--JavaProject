package com.ntl.frs.bean;

import java.time.LocalDate;

public class ScheduleBean {

	private String scheduleID;
	private String routeID;
	private String flightID;
	private LocalDate startDate;
	private int  reservationCapacity;
	private int travelduration;
	private int  departureTime;

	
	

	
	/**
	 * @param scheduleID
	 * @param routeID
	 * @param flightID
	 * @param startDate
	 */
	public ScheduleBean(String scheduleID, String routeID, String flightID, LocalDate startDate) {
		super();
		this.scheduleID = scheduleID;
		this.routeID = routeID;
		this.flightID = flightID;
		this.startDate = startDate;
	}







	/**
	 * @param routeID
	 * @param flightID
	 * @param startDate
	 */
	public ScheduleBean(String routeID, String flightID, LocalDate startDate) {
		super();
		this.routeID = routeID;
		this.flightID = flightID;
		this.startDate = startDate;
	}







	/**
	 * @param scheduleID
	 * @param routeID
	 * @param flightID
	 */
	public ScheduleBean(String scheduleID, String routeID, String flightID) {
		super();
		this.scheduleID = scheduleID;
		this.routeID = routeID;
		this.flightID = flightID;
	}
	/**
	 */
	public ScheduleBean() {
		super();
		this.scheduleID = scheduleID;
		this.routeID = routeID;
		this.flightID = flightID;
		this.startDate = startDate;
		this.reservationCapacity = reservationCapacity;
		this.travelduration = travelduration;
		this.departureTime = departureTime;
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
	 * @return the routeID
	 */
	public String getRouteID() {
		return routeID;
	}
	/**
	 * @param routeID the routeID to set
	 */
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	/**
	 * @return the flightID
	 */
	public String getFlightID() {
		return flightID;
	}
	/**
	 * @param flightID the flightID to set
	 */
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the reservationCapacity
	 */
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	/**
	 * @param reservationCapacity the reservationCapacity to set
	 */
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	/**
	 * @return the travelduration
	 */
	public int getTravelduration() {
		return travelduration;
	}
	/**
	 * @param travelduration the travelduration to set
	 */
	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}
	/**
	 * @return the departureTime
	 */
	public int getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScheduleBean [scheduleID=" + scheduleID + ", routeID=" + routeID + ", flightID=" + flightID
				+ ", startDate=" + startDate + ", reservationCapacity=" + reservationCapacity + ", travelduration="
				+ travelduration + ", departureTime=" + departureTime + "]";
	}
	
	
	
	
	
	
}