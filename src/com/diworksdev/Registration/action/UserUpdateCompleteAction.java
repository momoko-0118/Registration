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
	
	private UserInfoDAO userInfoDAO=new UserInfoDAO();
	private int id;
	private String message;
	
	public String execute() throws SQLException{
		
		session.put("id",id);
		
		boolean data;
		if (session.get("password") == null) {
	        // パスワード変更なし → password列を更新しないSQLへ
	        data = userInfoDAO.updateUserWithoutPassword(
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
	        data = userInfoDAO.updateUserWithPassword(
	            session.get("familyName").toString(),
	            session.get("lastName").toString(),
	            session.get("familyNameKana").toString(),
	            session.get("lastNameKana").toString(),
	            session.get("mail").toString(),
	            pass,
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

            if (data) {
            	setMessage("更新完了しました");
            	return SUCCESS;
            }
            setMessage("エラーが発生したためアカウント更新できません。");
            return ERROR;
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
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}