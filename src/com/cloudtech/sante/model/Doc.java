package com.cloudtech.sante.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Doc {
	@DatabaseField(generatedId=true)
	private int idDoc;
	@DatabaseField
	private int category;
	@DatabaseField
	private int idPicture;
	@DatabaseField
	private String title;
	@DatabaseField
	private int idUserDoc;
	
	public Doc() {
		super();

	}

	public Doc(int idDoc, int category, int idPicture, String title, int idUserDoc) {
		super();
		this.idDoc = idDoc;
		this.category = category;
		this.idPicture = idPicture;
		this.title = title;
		this.idUserDoc = idUserDoc;
	}

	public int getIdDoc() {
		return idDoc;
	}
	
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getIdPicture() {
		return idPicture;
	}
	
	public void setIdPicture(int idPicture) {
		this.idPicture = idPicture;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getUser() {
		return idUserDoc;
	}
	
	public void setUser(int idUserDoc) {
		this.idUserDoc = idUserDoc;
	}

	@Override
	public String toString() {
		return "Doc [idDoc=" + idDoc + ", category=" + category
				+ ", idPicture=" + idPicture + ", title=" + title + "]";
	}
}