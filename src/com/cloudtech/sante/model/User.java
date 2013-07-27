package com.cloudtech.sante.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class User {
	@DatabaseField(generatedId=true)
	private int idUser;
	@DatabaseField
	private Date birthDate;
	@DatabaseField
	private String bloodType;
	@DatabaseField
	private String firstName;
	@DatabaseField
	private String iceEmail;
	@DatabaseField
	private String iceFirtName;
	@DatabaseField
	private String iceLastName;
	@DatabaseField
	private String icePhone;
	@DatabaseField
	private String isMain;
	@DatabaseField
	private String lastName;
	@DatabaseField
	private String password;
	@DatabaseField
	private String physicianAdress;
	@DatabaseField
	private String physicianPhone;
	@DatabaseField
	private String socialSecurity;
	
	public User() {
		super();

	}

	public User(int idUser, Date birthDate, String bloodType, String firstName,
			String iceEmail, String iceFirtName, String iceLastName,
			String icePhone, String isMain, String lastName, String password,
			String physicianAdress, String physicianPhone, String socialSecurity) {
		super();
		this.idUser = idUser;
		this.birthDate = birthDate;
		this.bloodType = bloodType;
		this.firstName = firstName;
		this.iceEmail = iceEmail;
		this.iceFirtName = iceFirtName;
		this.iceLastName = iceLastName;
		this.icePhone = icePhone;
		this.isMain = isMain;
		this.lastName = lastName;
		this.password = password;
		this.physicianAdress = physicianAdress;
		this.physicianPhone = physicianPhone;
		this.socialSecurity = socialSecurity;
	}



	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBloodType() {
		return bloodType;
	}
	
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getIceEmail() {
		return iceEmail;
	}
	
	public void setIceEmail(String iceEmail) {
		this.iceEmail = iceEmail;
	}
	
	public String getIceFirtName() {
		return iceFirtName;
	}
	
	public void setIceFirtName(String iceFirtName) {
		this.iceFirtName = iceFirtName;
	}
	
	public String getIceLastName() {
		return iceLastName;
	}
	
	public void setIceLastName(String iceLastName) {
		this.iceLastName = iceLastName;
	}
	
	public String getIcePhone() {
		return icePhone;
	}
	
	public void setIcePhone(String icePhone) {
		this.icePhone = icePhone;
	}
	
	public String getIsMain() {
		return isMain;
	}
	
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhysicianAdress() {
		return physicianAdress;
	}
	
	public void setPhysicianAdress(String physicianAdress) {
		this.physicianAdress = physicianAdress;
	}
	
	public String getPhysicianPhone() {
		return physicianPhone;
	}
	
	public void setPhysicianPhone(String physicianPhone) {
		this.physicianPhone = physicianPhone;
	}
	
	public String getSocialSecurity() {
		return socialSecurity;
	}
	
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", birthDate=" + birthDate
				+ ", bloodType=" + bloodType + ", firstName=" + firstName
				+ ", iceEmail=" + iceEmail + ", iceFirtName=" + iceFirtName
				+ ", iceLastName=" + iceLastName + ", icePhone=" + icePhone
				+ ", isMain=" + isMain + ", lastName=" + lastName
				+ ", password=" + password + ", physicianAdress="
				+ physicianAdress + ", physicianPhone=" + physicianPhone
				+ ", socialSecurity=" + socialSecurity + "]";
	}
	
}