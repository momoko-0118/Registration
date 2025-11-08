package com.diworksdev.Registration.dto;

public class ListDTO {
	
	public String id;
	public String familyName;
	public String lastName;
	public String familyNameKana;
	public String lastNameKana;
	public String mail;
	public String gender;
	public String authority;
	public String deleteFlg;
	public String registered_time;
	public String update_time;
	
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getFamilyName() {
		return this.familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getFamilyNameKana() {
		return this.familyNameKana;
	}
	
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana=familyNameKana;
	}
	
	public String getLastNameKana() {
		return this.lastNameKana;
	}
	
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana=lastNameKana;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail=mail;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority=authority;
	}
	
	public String getDeleteFlg() {
		return this.deleteFlg;
	}
	
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}
	
	public String getRegistered_time() {
		return this.registered_time;
	}
	
	public void setRegistered_time(String registered_time) {
		this.registered_time=registered_time;
	}
	
	public String getUpdate_time() {
		return this.update_time;
	}
	
	public void setUpdate_time(String update_time) {
		this.update_time=update_time;
	}

}