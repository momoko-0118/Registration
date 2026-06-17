package com.diworksdev.Registration.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.Registration.dao.SearchListDAO;
import com.diworksdev.Registration.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchListAction extends ActionSupport implements SessionAware {
	
	private String familyNameSL;
    private String lastNameSL;
    private String familyNameKanaSL;
    private String lastNameKanaSL;
    private String mailSL;
    private int genderSL;
    private int authoritySL;
    private Map<String, Object> session;
	
	private List<ListDTO> users = new ArrayList<>();
	private SearchListDAO searchListDAO = new SearchListDAO();
	public Map<String, Object> map = new HashMap<>();

    @Override
    public String execute() {
        try {
        	session.put("familyNameSL", familyNameSL);
            session.put("lastNameSL", lastNameSL);
            session.put("familyNameKanaSL", familyNameKanaSL);
            session.put("lastNameKanaSL", lastNameKanaSL);
            session.put("mailSL", mailSL);
            session.put("genderSL", genderSL);
            session.put("authoritySL", authoritySL);
            
            map.put("familyNameSL",familyNameSL);
            map.put("lastNameSL",lastNameSL);
            map.put("familyNameKanaSL",familyNameKanaSL);
            map.put("lastNameKanaSL",lastNameKanaSL);
            map.put("mailSL",mailSL);
            map.put("genderSL",genderSL);
            map.put("authoritySL",authoritySL);
           
            users = searchListDAO.getSearchList(map);
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public List<ListDTO> getUsers() {
        return users;
    }

    public String getFamilyNameSL() {
        return familyNameSL;
    }

    public void setFamilyNameSL(String familyNameSL) {
        this.familyNameSL = familyNameSL;
    }

    public String getLastNameSL() {
        return lastNameSL;
    }

    public void setLastNameSL(String lastNameSL) {
        this.lastNameSL = lastNameSL;
    }

    public String getFamilyNameKanaSL() {
        return familyNameKanaSL;
    }

    public void setFamilyNameKanaSL(String familyNameKanaSL) {
        this.familyNameKanaSL = familyNameKanaSL;
    }

    public String getLastNameKanaSL() {
        return lastNameKanaSL;
    }

    public void setLastNameKanaSL(String lastNameKanaSL) {
        this.lastNameKanaSL = lastNameKanaSL;
    }

    public String getMailSL() {
        return mailSL;
    }

    public void setMailSL(String mailSL) {
        this.mailSL = mailSL;
    }

    public int getGenderSL() {
        return genderSL;
    }

    public void setGenderSL(int genderSL) {
        this.genderSL = genderSL;
    }

    public int getAuthoritySL() {
        return authoritySL;
    }

    public void setAuthoritySL(int authoritySL) {
        this.authoritySL = authoritySL;
    }

}
