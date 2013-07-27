package com.cloudtech.sante.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Treatment {
	@DatabaseField(generatedId=true)
	private int idTreatment;
	@DatabaseField
	private String nameTreatment;
	@DatabaseField
	private Date startDate;
	@DatabaseField
	private Date  finishDate;
	@DatabaseField
	private int idUserTreatment;
	
	public Treatment() {
		super();

	}

	public Treatment(int idTreatment, String nameTreatment, Date startDate,
			Date finishDate, int idUserTreatment) {
		super();
		this.idTreatment = idTreatment;
		this.nameTreatment = nameTreatment;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.idUserTreatment = idUserTreatment;
	}

	public int getIdTreatment() {
		return idTreatment;
	}
	
	public void setIdTreatment(int idTreatment) {
		this.idTreatment = idTreatment;
	}
	
	public String getNameTreatment() {
		return nameTreatment;
	}
	
	public void setNameTreatment(String nameTreatment) {
		this.nameTreatment = nameTreatment;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	public int getUser() {
		return idUserTreatment;
	}
	
	public void setUser(int idUserTreatment) {
		this.idUserTreatment = idUserTreatment;
	}

	@Override
	public String toString() {
		return "Treatment [idTreatment=" + idTreatment + ", nameTreatment="
				+ nameTreatment + ", startDate=" + startDate + ", finishDate="
				+ finishDate + "]";
	}
	
}