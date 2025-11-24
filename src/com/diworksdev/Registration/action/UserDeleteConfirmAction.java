package com.diworksdev.Registration.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport{
	public Map<String,Object>session;
	private int id;

	public String execute() {
		return SUCCESS;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public Map<String,Object>getSession(){
		return session;
	}
	
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}

}