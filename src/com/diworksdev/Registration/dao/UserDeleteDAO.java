package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.Registration.dto.ListDTO;
import com.diworksdev.Registration.util.DBConnector;

public class UserDeleteDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public ArrayList<ListDTO> getAllList()
	throws SQLException{		
		ArrayList<ListDTO> list=new ArrayList<>();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,git.user_gender,lut.postal_code,"
				+ "lut.prefecture,lut.address_1,lut.address_2,ait.user_authority "
				+ "FROM login_user_transaction lut "
				+ "LEFT JOIN gender_info_transaction git ON lut.gender=git.id "
				+ "LEFT JOIN authority_info_transaction ait ON lut.authority=ait.id ";
		
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
				dto.setMail(resultSet.getString("password"));
				dto.setGender(resultSet.getString("user_gender"));
				dto.setMail(resultSet.getString("postal_code"));
				dto.setMail(resultSet.getString("prefecture"));
				dto.setMail(resultSet.getString("address_1"));
				dto.setMail(resultSet.getString("address_2"));
				dto.setAuthority(resultSet.getString("user_authority"));
				list.add(dto);
				System.out.println(dto.getFamilyName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getFamilyNameKana());
				System.out.println(dto.getLastNameKana());
				System.out.println(dto.getMail());
				System.out.println(dto.getGender());
				System.out.println(dto.getAuthority());
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return list;
	}

}