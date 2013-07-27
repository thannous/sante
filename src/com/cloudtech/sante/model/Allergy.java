package com.cloudtech.sante.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Allergy {
	@DatabaseField(generatedId=true)
	private int idAllergy;
	@DatabaseField
	private String nameAllergy;
	@DatabaseField
	private int idUserAllergy;
	
	public Allergy() {
		super();

	}

	public Allergy(int idAllergy, String nameAllergy, int idUserAllergy) {
		super();
		this.idAllergy = idAllergy;
		this.nameAllergy = nameAllergy;
		this.idUserAllergy = idUserAllergy;
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
	
	public int getUser() {
		return idUserAllergy;
	}
	
	public void setUser(int idUserAllergy) {
		this.idUserAllergy = idUserAllergy;
	}

	@Override
	public String toString() {
		return "Allergy [idAllergy=" + idAllergy + ", nameAllergy="
				+ nameAllergy + "]";
	}
}