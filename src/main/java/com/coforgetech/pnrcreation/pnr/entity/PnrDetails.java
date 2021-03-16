package com.coforgetech.pnrcreation.pnr.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pnr_details")
public class PnrDetails  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated entity ID")
	@Column(name="id")
	private int id;
	
	@NotNull(message = "First Name Required")
	@Size(max = 30)
	@ApiModelProperty(notes = "The database generated First Name")
	@Column(name="firstname")
	private String firstName;
	
	@NotNull(message = "LastName required")
	@ApiModelProperty(notes = "Passenger Last Name")
	@Column(name="lastname")
	@Size(max = 20)
	private String lastName;
	
	@NotNull(message = "dob should not be blank")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@ApiModelProperty(notes = "passenger DOB")
	@Column(name="date_of_birth")
	private Date dob;
	
	@NotNull
	@Pattern(regexp = "(0191)?[7-9][0-9]{9}")
	@ApiModelProperty(notes = "Passenger contact no")
	@Column(name="contact")
	private String contact;
	
	@ApiModelProperty(notes = "Time Limit")
	@Column(name="timelimit")
	private String timelimit;
	
	@ApiModelProperty(notes = "Received From")
	@Column(name="receivedfrom")
	private String receivedfrom;
	
	@Column(name = "address_id")
	private int addressId; 
	
	@Column(name = "created_date")
	private Date createdDate; 
			
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "itinerary_id")
	private Itinerary itinerary;

	
	public PnrDetails() {
		
	}

	public PnrDetails( int id ,String firstName, String lastName, Date dateOfBirth, String contact, String timelimit, String receivedfrom , int addressId,Itinerary itinerary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dateOfBirth;
		this.contact = contact;
		this.timelimit = timelimit;
		this.receivedfrom = receivedfrom;
		this.addressId = addressId;
		this.itinerary=itinerary;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the timelimit
	 */
	public String getTimelimit() {
		return timelimit;
	}

	/**
	 * @param timelimit the timelimit to set
	 */
	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

	/**
	 * @return the receivedfrom
	 */
	public String getReceivedfrom() {
		return receivedfrom;
	}

	/**
	 * @param receivedfrom the receivedfrom to set
	 */
	public void setReceivedfrom(String receivedfrom) {
		this.receivedfrom = receivedfrom;
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

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

		
	
}
