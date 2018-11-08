package com.ntl.frs.bean;

public class RouteBean {

	private String routeID;
	private String source;
	private String destination ; 
	private String travelDuration ;
	private  int fare;
	
	
	
	
	public RouteBean() {
		super();
	}
	
	
	
	public RouteBean(String source, String destination, String travelDuration, int fare) {
		super();
		this.source = source;
		this.destination = destination;
		this.travelDuration = travelDuration;
		this.fare = fare;
	}



	public RouteBean(String routeID, String source, String destination, String travelDuration,int fare) {
		super();
		this.routeID = routeID;
		this.source = source;
		this.destination = destination;
		this.travelDuration = travelDuration;
		this.fare = fare;
	}



	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String gettravelDuration() {
		return travelDuration;
	}
	public void settravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RouteBean [routeID=" + routeID + ", source=" + source + ", destination=" + destination + "]";
	}
	
	
	
}
