package com.diworksdev.Registration.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegistConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private int gender;
	private int postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private int authority;
	
	public Map<String,Object>session;
	private String errorMessage;
	
	public String execute() {
		String result=SUCCESS;
		
		if(!(familyName.equals(""))) {
			session.put("familyName",familyName);
		}else {
			setErrorMessage("名前（姓）が未入力です");
			result=ERROR;
		}
		if(!(lastName.equals(""))) {
				session.put("lastName",lastName);
		}else {
			setErrorMessage("名前（名）が未入力です");
			result=ERROR;
		}
		if(!(familyNameKana.equals(""))) {
			session.put("familyNameKana",familyNameKana);
		}else {
			setErrorMessage("カナ（姓）が未入力です");
			result=ERROR;
		}
		if(!(lastNameKana.equals(""))) {
				session.put("lastNameKana",lastNameKana);
		}else {
			setErrorMessage("カナ（姓）が未入力です");
			result=ERROR;
		}
		if(!(mail.equals(""))) {
			session.put("mail",mail);
		}else {
			setErrorMessage("メールアドレスが未入力です");
			result=ERROR;
		}
		if(!(password.equals(""))) {
				session.put("password",password);
		}else {
			setErrorMessage("パスワードが未入力です");
			result=ERROR;
		}
		if(postalCode !=0) {
				session.put("postalCode",postalCode);
		}else {
			setErrorMessage("郵便番号が未入力です");
			result=ERROR;
		}
		if(!(prefecture.equals(""))) {
			session.put("prefecture",prefecture);
		}else {
			setErrorMessage("住所（都道府県）が未入力です");
			result=ERROR;
		}
		if(!(address1.equals(""))) {
				session.put("address1",address1);
		}else {
			setErrorMessage("住所（市区町村）が未入力です");
			result=ERROR;
		}
		if(!(address2.equals(""))) {
			session.put("address2",address2);
		}else {
			setErrorMessage("住所（番地）が未入力です");
			result=ERROR;
		}
		return result;
	}
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana=familyNameKana;
	}
	
	public String getLastNameKana() {
		return lastNameKana;
	}
	
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana=lastNameKana;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail=mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender=gender;
	}
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode=postalCode;
	}
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture=prefecture;
	}
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1=address1;
	}
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2=address2;
	}
	public int getAuthority() {
		return authority;
	}
	
	public void setAuthority(int authority) {
		this.authority=authority;
	}
	
	public Map<String,Object>getSession(){
		return session;
	}
	
	@Override
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
}