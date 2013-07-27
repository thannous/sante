package com.cloudtech.sante.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class PreviousHistory {
	@DatabaseField(id=true)
	private int id;
	@DatabaseField
	private Date doDate;
	@DatabaseField
	private String title;
	@DatabaseField
	private User user;
	
	public PreviousHistory() {
		super();

	}

	public PreviousHistory(int id, Date doDate, String title, User user) {
		super();
		this.id = id;
		this.doDate = doDate;
		this.title = title;
		this.user = user;
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PreviousHistory [id=" + id + ", doDate=" + doDate + ", title="
				+ title + "]";
	}
	
}
