package com.diworksdev.Registration.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.Registration.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	
	private String errorMessage;
	private RegistCompleteDAO RegistCompleteDAO=new RegistCompleteDAO();
	
	public String execute() throws SQLException{
		
		String password = session.get("password").toString();
				
		MessageDigest sha256;
		String pass = "";
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] hash = sha256.digest(password.getBytes());	
			StringBuilder sb = new StringBuilder();
			for(byte b : hash){
			    sb.append(String.format("%02x", b));
			}
			pass = sb.toString();
			System.out.println(sha256.digest(password.getBytes()));
			System.out.println(pass);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		boolean data=RegistCompleteDAO.createUser(session.get("familyName").toString(),
				session.get("lastName").toString(),
				session.get("familyNameKana").toString(),
				session.get("lastNameKana").toString(),
				session.get("mail").toString(),
				pass,
				session.get("gender").toString(),
				session.get("postalCode").toString(),
				session.get("prefecture").toString(),
				session.get("address1").toString(),
				session.get("address2").toString(),
				session.get("authority").toString(),
				session.get("deleteFlg").toString());
		String result = SUCCESS;
		if(!data) {
			result=ERROR;
			setErrorMessage("エラーが発生したためアカウント登録できません。");
		}
		return result;				
	}
	
	public String getPassword() {
		return getPassword();
	}
	
	public void setPassword(String password) {
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}