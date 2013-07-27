package com.cloudtech.sante.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class PreviousHistory {
	@DatabaseField(generatedId=true)
	private int id;
	@DatabaseField
	private Date doDate;
	@DatabaseField
	private String title;
	@DatabaseField
	private int idUserPreviousHistory;
	
	public PreviousHistory() {
		super();

	}

	public PreviousHistory(int id, Date doDate, String title, int idUserPreviousHistory) {
		super();
		this.id = id;
		this.doDate = doDate;
		this.title = title;
		this.idUserPreviousHistory = idUserPreviousHistory;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDoDate() {
		return doDate;
	}
	
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getUser() {
		return idUserPreviousHistory;
	}
	
	public void setUser(int idUserPreviousHistory) {
		this.idUserPreviousHistory = idUserPreviousHistory;
	}

	@Override
	public String toString() {
		return "PreviousHistory [id=" + id + ", doDate=" + doDate + ", title="
				+ title + "]";
	}
	
}