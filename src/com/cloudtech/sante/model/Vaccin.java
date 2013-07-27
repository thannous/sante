package com.cloudtech.sante.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Vaccin {
	@DatabaseField(generatedId=true)
	private int idVaccin;
	@DatabaseField
	private Date doDate;
	@DatabaseField
	private String nameVaccin;
	@DatabaseField
	private int idUserVaccin;
	
	public Vaccin() {
		super();
		
	}
	
	public Vaccin(int idVaccin, Date doDate, String nameVaccin, int idUserVaccin) {
		super();
		this.idVaccin = idVaccin;
		this.doDate = doDate;
		this.nameVaccin = nameVaccin;
		this.idUserVaccin = idUserVaccin;
	}

	public int getIdVaccin() {
		return idVaccin;
	}
	
	public void setIdVaccin(int idVaccin) {
		this.idVaccin = idVaccin;
	}
	
	public Date getDoDate() {
		return doDate;
	}
	
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
	
	public String getNameVaccin() {
		return nameVaccin;
	}
	
	public void setNameVaccin(String nameVaccin) {
		this.nameVaccin = nameVaccin;
	}
	
	public int getUser() {
		return idUserVaccin;
	}
	
	public void setUser(int idUserVaccin) {
		this.idUserVaccin = idUserVaccin;
	}

	@Override
	public String toString() {
		return "Vaccin [idVaccin=" + idVaccin + ", doDate=" + doDate
				+ ", nameVaccin=" + nameVaccin + "]";
	}
	
}