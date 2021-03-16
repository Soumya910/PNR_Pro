package com.coforgetech.ssr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="doca")
public class Doca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "segment_no")
	private int segmentNo;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}", message = "Destination should be single character")
	@Column(name = "destination")
	private String destination;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{2}" ,message = "Country Code should be two character")
	@Column(name = "country_code")
	private String countryCode;
	
	@NotNull
	//@Pattern(regexp = "[^a-zA-Z0-9]")
	@Column(name = "street_no")
	private String streetNo;
	
	@NotNull
	@Column(name = "country")
	private String country;
	
	@NotNull
	@Pattern(regexp = "[0-9A-Za-z]{6}",message = "Zipcode should be Six character alpha numeric")
	@Column(name = "zip_code")
	private String zipcode;
	
	@NotNull
	@Column(name = "passenger_no")
	private String passengerNo;
	
	@Column(name = "address_id")
	private int addressId;
	
		
	public Doca() {
		
	}

	public Doca(int id, int segmentNo, String destination, String countryCode, String streetNo, String country,
			String zipcode, String passengerNo, int addressId) {
		super();
		this.id = id;
		this.segmentNo = segmentNo;
		this.destination = destination;
		this.countryCode = countryCode;
		this.streetNo = streetNo;
		this.country = country;
		this.zipcode = zipcode;
		this.passengerNo = passengerNo;
		this.addressId= addressId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSegmentNo() {
		return segmentNo;
	}

	public void setSegmentNo(int segmentNo) {
		this.segmentNo = segmentNo;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(String passengerNo) {
		this.passengerNo = passengerNo;
	}

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	
    
	
	
	
	

}
