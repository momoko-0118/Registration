package com.diworksdev.Registration.dto;

public class UserUpdateDTO {
	
	public String id;
	public String familyName;
	public String lastName;
	public String familyNameKana;
	public String lastNameKana;
	public String mail;
	public String password;
	public int gender;
	public String userGender;
	public String postal_code;
	public String prefecture;
	public String address_1;
	public String address_2;
	public int authority;
	public String userAuthority;
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
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public int getGender() {
		return this.gender;
	}
	
	public void setGender(int gender) {
		this.gender=gender;
	}
	
	public String getUserGender() {
		return this.userGender;
	}
	
	public void setUserGender(String userGender) {
		this.userGender=userGender;
	}
	
	public String getPostal_Code() {
		return this.postal_code;
	}
	
	public void setPostal_Code(String postal_code) {
		this.postal_code=postal_code;
	}
	
	public String getPrefecture() {
		return this.prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture=prefecture;
	}
	
	public String getAddress_1() {
		return this.address_1;
	}
	
	public void setAddress_1(String address_1) {
		this.address_1=address_1;
	}
	
	public String getAddress_2() {
		return this.address_2;
	}
	
	public void setAddress_2(String address_2) {
		this.address_2=address_2;
	}
	
	public int getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(int authority) {
		this.authority=authority;
	}
	
	public String getUserAuthority() {
		return this.userAuthority;
	}
	
	public void setUserAuthority(String userAuthority) {
		this.userAuthority=userAuthority;
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