package com.diworksdev.Registration.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.Registration.dao.ListDAO;
import com.diworksdev.Registration.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {

    private List<ListDTO> users = new ArrayList<>();
    private final ListDAO listDAO = new ListDAO();

    @Override
    public String execute() {
        try {
            users = listDAO.getAllList();
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<ListDTO> getUsers() {
        return users;
    }
}
