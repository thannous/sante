package com.cloudtech.sante.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Allergy {
	@DatabaseField(id=true)
	private int idAllergy;
	@DatabaseField
	private String nameAllergy;
	@DatabaseField
	private User user;
	
	public Allergy() {
		super();

	}

	public Allergy(int idAllergy, String nameAllergy, User user) {
		super();
		this.idAllergy = idAllergy;
		this.nameAllergy = nameAllergy;
		this.user = user;
	}

	public int getIdAllergy() {
		return idAllergy;
	}
	
	public void setIdAllergy(int idAllergy) {
		this.idAllergy = idAllergy;
	}
	
	public String getNameAllergy() {
		return nameAllergy;
	}
	
	public void setNameAllergy(String nameAllergy) {
		this.nameAllergy = nameAllergy;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Allergy [idAllergy=" + idAllergy + ", nameAllergy="
				+ nameAllergy + "]";
	}
}
