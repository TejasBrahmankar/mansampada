package com.tableslearnedmapping.entitymapping.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoId;

    private String userInformation;
    
    public String title;
	public String candidateFirstname;
	public String candidateMiddlename;
	public String candidateSurname;
	public String image;
	public String birthday;
	public String date;
	public String month;
	public String year;
	public String gender;
	public String birthPlace;
	public String education;
	public String occupation;
	public String occupationAddress;
//	public String candidateMobilenumber;
	public String altCandidateMobilenumber;
//	public String emailID;
//	public String password;
//	public String cPassword;
	public String gotra;
	public String goddess;
	public String heightFeet;
	public String heightInch;
	public String bloodGroup;
	public String titleFather;
	public String fatherFirstname;
	public String fatherMiddlename;
	public String fatherLastname;
	public String fatherOccupation;
	public String fatherMobileNumber;
	public String titleMother;
	public String motherFirstname;
	public String motherMiddlename;
	public String motherLastname;
	public String motherOccupation;
	public String motherMobileNumber;
	public String visitAddress;
	public String tempororyAddress;
	public String expections;
	public String bio;
	public String maritialStatus;
	public String complexion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
	public UserInfo(int infoId, String userInformation, String title, String candidateFirstname,
			String candidateMiddlename, String candidateSurname, String image, String birthday, String date,
			String month, String year, String gender, String birthPlace, String education, String occupation,
			String occupationAddress, String altCandidateMobilenumber, String gotra, String goddess, String heightFeet,
			String heightInch, String bloodGroup, String titleFather, String fatherFirstname, String fatherMiddlename,
			String fatherLastname, String fatherOccupation, String fatherMobileNumber, String titleMother,
			String motherFirstname, String motherMiddlename, String motherLastname, String motherOccupation,
			String motherMobileNumber, String visitAddress, String tempororyAddress, String expections, String bio,
			String maritialStatus, String complexion, User user) {
		super();
		this.infoId = infoId;
		this.userInformation = userInformation;
		this.title = title;
		this.candidateFirstname = candidateFirstname;
		this.candidateMiddlename = candidateMiddlename;
		this.candidateSurname = candidateSurname;
		this.image = image;
		this.birthday = birthday;
		this.date = date;
		this.month = month;
		this.year = year;
		this.gender = gender;
		this.birthPlace = birthPlace;
		this.education = education;
		this.occupation = occupation;
		this.occupationAddress = occupationAddress;
		this.altCandidateMobilenumber = altCandidateMobilenumber;
		this.gotra = gotra;
		this.goddess = goddess;
		this.heightFeet = heightFeet;
		this.heightInch = heightInch;
		this.bloodGroup = bloodGroup;
		this.titleFather = titleFather;
		this.fatherFirstname = fatherFirstname;
		this.fatherMiddlename = fatherMiddlename;
		this.fatherLastname = fatherLastname;
		this.fatherOccupation = fatherOccupation;
		this.fatherMobileNumber = fatherMobileNumber;
		this.titleMother = titleMother;
		this.motherFirstname = motherFirstname;
		this.motherMiddlename = motherMiddlename;
		this.motherLastname = motherLastname;
		this.motherOccupation = motherOccupation;
		this.motherMobileNumber = motherMobileNumber;
		this.visitAddress = visitAddress;
		this.tempororyAddress = tempororyAddress;
		this.expections = expections;
		this.bio = bio;
		this.maritialStatus = maritialStatus;
		this.complexion = complexion;
		this.user = user;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(String userInformation) {
		this.userInformation = userInformation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCandidateFirstname() {
		return candidateFirstname;
	}
	public void setCandidateFirstname(String candidateFirstname) {
		this.candidateFirstname = candidateFirstname;
	}
	public String getCandidateMiddlename() {
		return candidateMiddlename;
	}
	public void setCandidateMiddlename(String candidateMiddlename) {
		this.candidateMiddlename = candidateMiddlename;
	}
	public String getCandidateSurname() {
		return candidateSurname;
	}
	public void setCandidateSurname(String candidateSurname) {
		this.candidateSurname = candidateSurname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOccupationAddress() {
		return occupationAddress;
	}
	public void setOccupationAddress(String occupationAddress) {
		this.occupationAddress = occupationAddress;
	}
	public String getAltCandidateMobilenumber() {
		return altCandidateMobilenumber;
	}
	public void setAltCandidateMobilenumber(String altCandidateMobilenumber) {
		this.altCandidateMobilenumber = altCandidateMobilenumber;
	}
	public String getGotra() {
		return gotra;
	}
	public void setGotra(String gotra) {
		this.gotra = gotra;
	}
	public String getGoddess() {
		return goddess;
	}
	public void setGoddess(String goddess) {
		this.goddess = goddess;
	}
	public String getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(String heightFeet) {
		this.heightFeet = heightFeet;
	}
	public String getHeightInch() {
		return heightInch;
	}
	public void setHeightInch(String heightInch) {
		this.heightInch = heightInch;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getTitleFather() {
		return titleFather;
	}
	public void setTitleFather(String titleFather) {
		this.titleFather = titleFather;
	}
	public String getFatherFirstname() {
		return fatherFirstname;
	}
	public void setFatherFirstname(String fatherFirstname) {
		this.fatherFirstname = fatherFirstname;
	}
	public String getFatherMiddlename() {
		return fatherMiddlename;
	}
	public void setFatherMiddlename(String fatherMiddlename) {
		this.fatherMiddlename = fatherMiddlename;
	}
	public String getFatherLastname() {
		return fatherLastname;
	}
	public void setFatherLastname(String fatherLastname) {
		this.fatherLastname = fatherLastname;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}
	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}
	public String getTitleMother() {
		return titleMother;
	}
	public void setTitleMother(String titleMother) {
		this.titleMother = titleMother;
	}
	public String getMotherFirstname() {
		return motherFirstname;
	}
	public void setMotherFirstname(String motherFirstname) {
		this.motherFirstname = motherFirstname;
	}
	public String getMotherMiddlename() {
		return motherMiddlename;
	}
	public void setMotherMiddlename(String motherMiddlename) {
		this.motherMiddlename = motherMiddlename;
	}
	public String getMotherLastname() {
		return motherLastname;
	}
	public void setMotherLastname(String motherLastname) {
		this.motherLastname = motherLastname;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}
	public String getMotherMobileNumber() {
		return motherMobileNumber;
	}
	public void setMotherMobileNumber(String motherMobileNumber) {
		this.motherMobileNumber = motherMobileNumber;
	}
	public String getVisitAddress() {
		return visitAddress;
	}
	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}
	public String getTempororyAddress() {
		return tempororyAddress;
	}
	public void setTempororyAddress(String tempororyAddress) {
		this.tempororyAddress = tempororyAddress;
	}
	public String getExpections() {
		return expections;
	}
	public void setExpections(String expections) {
		this.expections = expections;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getMaritialStatus() {
		return maritialStatus;
	}
	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserInfo [infoId=" + infoId + ", userInformation=" + userInformation + ", title=" + title
				+ ", candidateFirstname=" + candidateFirstname + ", candidateMiddlename=" + candidateMiddlename
				+ ", candidateSurname=" + candidateSurname + ", image=" + image + ", birthday=" + birthday + ", date="
				+ date + ", month=" + month + ", year=" + year + ", gender=" + gender + ", birthPlace=" + birthPlace
				+ ", education=" + education + ", occupation=" + occupation + ", occupationAddress=" + occupationAddress
				+ ", altCandidateMobilenumber=" + altCandidateMobilenumber + ", gotra=" + gotra + ", goddess=" + goddess
				+ ", heightFeet=" + heightFeet + ", heightInch=" + heightInch + ", bloodGroup=" + bloodGroup
				+ ", titleFather=" + titleFather + ", fatherFirstname=" + fatherFirstname + ", fatherMiddlename="
				+ fatherMiddlename + ", fatherLastname=" + fatherLastname + ", fatherOccupation=" + fatherOccupation
				+ ", fatherMobileNumber=" + fatherMobileNumber + ", titleMother=" + titleMother + ", motherFirstname="
				+ motherFirstname + ", motherMiddlename=" + motherMiddlename + ", motherLastname=" + motherLastname
				+ ", motherOccupation=" + motherOccupation + ", motherMobileNumber=" + motherMobileNumber
				+ ", visitAddress=" + visitAddress + ", tempororyAddress=" + tempororyAddress + ", expections="
				+ expections + ", bio=" + bio + ", maritialStatus=" + maritialStatus + ", complexion=" + complexion
				+ ", user=" + user + "]";
	}

	
    // Constructors, getters, and setters
}
