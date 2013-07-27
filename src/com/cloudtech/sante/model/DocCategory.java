package com.cloudtech.sante.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class DocCategory {
	@DatabaseField(generatedId=true)
	private int idDocCategory;
	@DatabaseField
	private String nameDocCategory;
	
	public DocCategory() {
		super();

	}

	public DocCategory(int idDocCategory, String nameDocCategory) {
		super();
		this.idDocCategory = idDocCategory;
		this.nameDocCategory = nameDocCategory;
	}

	public int getIdDocCategory() {
		return idDocCategory;
	}
	
	public void setIdDocCategory(int idDocCategory) {
		this.idDocCategory = idDocCategory;
	}
	
	public String getNameDocCategory() {
		return nameDocCategory;
	}
	
	public void setNameDocCategory(String nameDocCategory) {
		this.nameDocCategory = nameDocCategory;
	}
	
	@Override
	public String toString() {
		return "DocCategory [idDocCategory=" + idDocCategory
				+ ", nameDocCategory=" + nameDocCategory + "]";
	}
}