package com.coforgetech.pnrcreation.pnr.vo;

import java.util.Date;

public class ItineraryVo {
	
	private int id;
	private String airlinecode;
	private int flightno;
	private String classofbooking;
	private Date dateoftravel;
	private String origin;
	private String destination;
	private int numberofseat;
	
	
	
	
	public ItineraryVo() {
		
	}
	
	public ItineraryVo(int id, String airlinecode, int flightno, String classofbooking, Date dateoftravel,
			String origin, String destination, int numberofseat) {
		super();
		this.id = id;
		this.airlinecode = airlinecode;
		this.flightno = flightno;
		this.classofbooking = classofbooking;
		this.dateoftravel = dateoftravel;
		this.origin = origin;
		this.destination = destination;
		this.numberofseat = numberofseat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlinecode() {
		return airlinecode;
	}
	public void setAirlinecode(String airlinecode) {
		this.airlinecode = airlinecode;
	}
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	public String getClassofbooking() {
		return classofbooking;
	}
	public void setClassofbooking(String classofbooking) {
		this.classofbooking = classofbooking;
	}
	public Date getDateoftravel() {
		return dateoftravel;
	}
	public void setDateoftravel(Date dateoftravel) {
		this.dateoftravel = dateoftravel;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNumberofseat() {
		return numberofseat;
	}
	public void setNumberofseat(int numberofseat) {
		this.numberofseat = numberofseat;
	}
	
	
	

}
