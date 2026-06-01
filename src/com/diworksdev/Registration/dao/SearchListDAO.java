package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.diworksdev.Registration.dto.ListDTO;
import com.diworksdev.Registration.util.DBConnector;

public class SearchListDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();	
	
	public ArrayList<ListDTO> getSearchList(Map<String, Object> map) throws SQLException{	
		ArrayList<ListDTO> list=new ArrayList<>();
		
		//<String,Object>でmapを定義しているので型がObjectで返ってくる。なので(String)map.get~で型を指定する
		String familyName = (String)map.get("familyName");
	    String lastName = (String)map.get("lastName");
	    String familyNameKana = (String)map.get("familyNameKana");
	    String lastNameKana = (String)map.get("lastNameKana");
	    String mail= (String)map.get("mail");
	    //int gender = (int)map.get("gender");
	    //int authority = (int)map.get("authority");
	    
		String sql="SELECT * FROM login_user_transaction";
		
		if(familyName != null && !familyName.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where family_name = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, familyName);			
		}
		if(lastName != null && !lastName.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where last_name = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, lastName);			
		}
		if(familyNameKana != null && !familyNameKana.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where family_name_kana = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, familyNameKana);			
		}
		if(lastNameKana != null && !lastNameKana.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where last_name_kana = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, lastNameKana);			
		}
		if(mail != null && !mail.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where mail = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);			
		}
		/*genderとauthorityの選択が必須になっているが、必須じゃないほうがよさそうでは？要確認
		if(gender != null && !gender.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where gender = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, gender);			
		}
		if(mail != null && !mail.isEmpty()) {
			sql="SELECT * FROM login_user_transaction where mail = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);			
		}*/
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ListDTO dto=new ListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setLastNameKana(resultSet.getString("last_name_kana"));	
				dto.setMail(resultSet.getString("mail"));
				dto.setGender(resultSet.getString("user_gender"));
				dto.setAuthority(resultSet.getString("user_authority"));
				dto.setDeleteFlg(resultSet.getString("flg"));
				dto.setRegistered_time(resultSet.getString("registered_time"));
				dto.setUpdate_time(resultSet.getString("update_time"));
				list.add(dto);
				System.out.println(dto.getFamilyName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getFamilyNameKana());
				System.out.println(dto.getLastNameKana());
				System.out.println(dto.getMail());
				System.out.println(dto.getGender());
				System.out.println(dto.getAuthority());
				System.out.println(dto.getDeleteFlg());
				System.out.println(dto.getRegistered_time());
				System.out.println(dto.getUpdate_time());
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return list;
	}

}
