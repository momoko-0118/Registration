package com.diworksdev.Registration.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.Registration.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	
	private RegistCompleteDAO RegistCompleteDAO=new RegistCompleteDAO();
	
	public String execute() throws SQLException{
		System.out.println(session);		
		RegistCompleteDAO.createUser(session.get("familyName").toString(),
				session.get("lastName").toString(),
				session.get("familyNameKana").toString(),
				session.get("lastNameKana").toString(),
				session.get("mail").toString(),
				session.get("password").toString(),
				session.get("gender").toString(),
				session.get("postalCode").toString(),
				session.get("prefecture").toString(),
				session.get("address1").toString(),
				session.get("address2").toString(),
				session.get("authority").toString());
		String result=SUCCESS;
		return result;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}