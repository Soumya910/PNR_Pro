package com.coforgetech.pnrcreation.pnr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="itinerary")
public class Itinerary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{2}",message ="Airlinecode should be max 2 char" )
	@Column(name="airline_code")
	private String airlinecode;
	
	@NotNull
	@Column(name="flight_no")
	private int flightno;
	
	@Pattern(regexp = "[A-Z]")
	@Column(name="class_of_booking")
	private String classofbooking;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name="date_of_travel")
	private Date dateoftravel;
	
	@NotNull
	@Column(name="origin")
	private String origin;
	
	@NotNull
	@Column(name="destination")
	private String destination;

	@NotNull
	@Column(name="number_of_seat")
	private int numberofseat;
	
	public Itinerary() {
		
	}

	public Itinerary(String airlinecode,int flightno, String classofbooking, Date dateoftravel, String origin,
			String destination, int numberofseat) {
		super();
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





















