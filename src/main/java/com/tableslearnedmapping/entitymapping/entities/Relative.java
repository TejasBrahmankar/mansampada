package com.tableslearnedmapping.entitymapping.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Relative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relativeId;

    public String relationName;
	public String rtitle;
	public String rfirstName;
	public String rMiddleName;
	public String rlastName;
	public String rAddress;
	public String rMobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

	public Relative(Long relativeId, String relationName, String rtitle, String rfirstName, String rMiddleName,
			String rlastName, String rAddress, String rMobileNumber, User user) {
		super();
		this.relativeId = relativeId;
		this.relationName = relationName;
		this.rtitle = rtitle;
		this.rfirstName = rfirstName;
		this.rMiddleName = rMiddleName;
		this.rlastName = rlastName;
		this.rAddress = rAddress;
		this.rMobileNumber = rMobileNumber;
		this.user = user;
	}

	public Relative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(Long relativeId) {
		this.relativeId = relativeId;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRfirstName() {
		return rfirstName;
	}

	public void setRfirstName(String rfirstName) {
		this.rfirstName = rfirstName;
	}

	public String getrMiddleName() {
		return rMiddleName;
	}

	public void setrMiddleName(String rMiddleName) {
		this.rMiddleName = rMiddleName;
	}

	public String getRlastName() {
		return rlastName;
	}

	public void setRlastName(String rlastName) {
		this.rlastName = rlastName;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public String getrMobileNumber() {
		return rMobileNumber;
	}

	public void setrMobileNumber(String rMobileNumber) {
		this.rMobileNumber = rMobileNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

    // Constructors, getters, and setters
}