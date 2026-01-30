package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.Registration.dto.LoginDTO;
import com.diworksdev.Registration.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO loginDTO=new LoginDTO();
	
	public LoginDTO getLoginUserInfo(String loginMail,String loginPassword) {	
		String sql="SELECT * FROM login_user_transaction where mail=? AND password=?";
	
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, loginMail);
			preparedStatement.setString(2, loginPassword);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				loginDTO.setId(resultSet.getString("id"));
				loginDTO.setMail(resultSet.getString("mail"));
				loginDTO.setPassword(resultSet.getString("password"));
				
				if(resultSet.getString("id")!=null) {
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return loginDTO;
	}
}