package com.diworksdev.Registration.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.Registration.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	
	private String errorMessage;
	private UserInfoDAO UserInfoDAO=new UserInfoDAO();
	private int id;
	
	public String execute() throws SQLException{
		
		session.put("id",id);
		
		boolean data;
		if (session.get("password") == null) {
	        // パスワード変更なし → password列を更新しないSQLへ
	        data = UserInfoDAO.updateUserWithoutPassword(
	            session.get("familyName").toString(),
	            session.get("lastName").toString(),
	            session.get("familyNameKana").toString(),
	            session.get("lastNameKana").toString(),
	            session.get("mail").toString(),
	            session.get("gender").toString(),
	            session.get("postal_code").toString(),
	            session.get("prefecture").toString(),
	            session.get("address_1").toString(),
	            session.get("address_2").toString(),
	            session.get("authority").toString(),
	            session.get("deleteFlg").toString(),
	            session.get("id").toString()
	        );
	    } else {
	    	MessageDigest sha256;
			try {
				sha256 = MessageDigest.getInstance("SHA-256");
				byte[] password = sha256.digest("password".getBytes());			
				System.out.println(sha256.digest("pass".getBytes()));
				System.out.println(password);
				session.put("password",password);
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
	        data = UserInfoDAO.updateUserWithPassword(
	            session.get("familyName").toString(),
	            session.get("lastName").toString(),
	            session.get("familyNameKana").toString(),
	            session.get("lastNameKana").toString(),
	            session.get("mail").toString(),
	            session.get("password").toString(),
	            session.get("gender").toString(),
	            session.get("postal_code").toString(),
	            session.get("prefecture").toString(),
	            session.get("address_1").toString(),
	            session.get("address_2").toString(),
	            session.get("authority").toString(),
	            session.get("deleteFlg").toString(),
	            session.get("id").toString()
	        );
	    }

	    if (!data) {
	        setErrorMessage("エラーが発生したためアカウント登録できません。");
	        return ERROR;
	    }
	    return SUCCESS;
	}
	
	public String getPassword() {
		return getPassword();
	}
	
	public void setPassword(String password) {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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