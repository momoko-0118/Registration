package com.diworksdev.Registration.action;

import java.sql.SQLException;

import com.diworksdev.Registration.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport {

    private int id;
    private String message;
    private final UserInfoDAO userInfoDAO = new UserInfoDAO();

    @Override
    public String execute() {
    	System.out.println("UserDeleteCompleteAction id" + id); 
        try {
            int result = userInfoDAO.deleteUser(id);

            if (result > 0) {
            	setMessage("削除完了しました");
            } else {
            	setMessage("対象データなし");
            }
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            setMessage("エラーが発生したためアカウント登録できません。");
            return ERROR;
        }
    }

    public void setId(int id) { 
    	this.id = id; 
    }
    
    public int getId() { 
    	return id; 
    }

    public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
}
