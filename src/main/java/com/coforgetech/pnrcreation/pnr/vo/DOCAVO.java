package com.coforgetech.pnrcreation.pnr.vo;


public class DOCAVO {

	private int id;
	private int segmentNo;
	private String destination;
	private String countryCode;
	private String streetNo;
	private String country;
	private String zipcode;
	private String passengerNo;
	private int addressId;
	
	public DOCAVO() {
		
	}
	
	
	public DOCAVO(int id, int segmentNo, String destination, String countryCode, String streetNo, String country,
			String zipcode, String passengerNo,int addressId) {
		super();
		this.id = id;
		this.segmentNo = segmentNo;
		this.destination = destination;
		this.countryCode = countryCode;
		this.streetNo = streetNo;
		this.country = country;
		this.zipcode = zipcode;
		this.passengerNo = passengerNo;
		this.addressId = addressId;
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
