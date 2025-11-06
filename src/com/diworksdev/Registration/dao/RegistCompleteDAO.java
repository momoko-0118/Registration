package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diworksdev.Registration.util.DBConnector;
import com.diworksdev.Registration.util.DateUtil;

public class RegistCompleteDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();	
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO login_user_transaction(family_name,last_name,family_name_kana,last_name_kana,"
			+ "mail,password,gender,postal_code,prefecture,address_1,address_2,authority,delete_flg,registered_time,update_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public boolean createUser(String familyName,String lastName,String familyNameKana,String lastNameKana,String mail,String password,
			String gender,String postalCode,String prefecture,String address1,String address2,String authority,String deleteFlg) {
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameKana);
			preparedStatement.setString(4,lastNameKana);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,password);
			preparedStatement.setString(7,gender);
			preparedStatement.setString(8,postalCode);
			preparedStatement.setString(9,prefecture);
			preparedStatement.setString(10,address1);
			preparedStatement.setString(11,address2);
			preparedStatement.setString(12,authority);
			preparedStatement.setString(13,deleteFlg);
			preparedStatement.setString(14,dateUtil.getDate());
			preparedStatement.setString(15,dateUtil.getDate());
			preparedStatement.execute();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
