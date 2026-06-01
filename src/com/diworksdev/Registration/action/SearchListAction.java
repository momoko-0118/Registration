package com.diworksdev.Registration.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diworksdev.Registration.dao.SearchListDAO;
import com.diworksdev.Registration.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchListAction extends ActionSupport{
	
	private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String mail;
    private int gender;
    private int authority;
	
	private List<ListDTO> users = new ArrayList<>();
	private SearchListDAO searchListDAO = new SearchListDAO();
	public Map<String, Object> map = new HashMap<>();

    @Override
    public String execute() {
        try {
            map.put("familyName",familyName);
            map.put("lastName",lastName);
            map.put("familyNameKana",familyNameKana);
            map.put("lastNameKana",lastNameKana);
            map.put("mail",mail);
            map.put("gender",gender);
            map.put("authority",authority);
           
            users = searchListDAO.getSearchList(map);
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<ListDTO> getUsers() {
        return users;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyNameKana() {
        return familyNameKana;
    }

    public void setFamilyNameKana(String familyNameKana) {
        this.familyNameKana = familyNameKana;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

}
