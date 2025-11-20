package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.Registration.dto.ListDTO;
import com.diworksdev.Registration.util.DBConnector;

public class UserInfoDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public ListDTO getUser(int id) throws SQLException {	
		ListDTO dto=new ListDTO();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,git.user_gender,lut.postal_code,lut.prefecture,"
				+ "lut.address_1,lut.address_2,ait.user_authority,fit.flg,"
				+ "lut.registered_time,lut.update_time FROM login_user_transaction lut "
				+ "LEFT JOIN gender_info_transaction git ON lut.gender=git.id "
				+ "LEFT JOIN authority_info_transaction ait ON lut.authority=ait.id "
				+ "LEFT JOIN flg_info_transaction fit ON lut.delete_flg=fit.id "
				+ "WHERE lut.id = ? ORDER BY lut.registered_time DESC";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			System.out.println("更新前の取得");
			System.out.println(id);
			if(resultSet.next()) {
				dto.setId(resultSet.getString("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setLastNameKana(resultSet.getString("last_name_kana"));	
				dto.setMail(resultSet.getString("mail"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("user_gender"));
				dto.setPostal_Code(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress_1(resultSet.getString("address_1"));
				dto.setAddress_2(resultSet.getString("address_2"));
				dto.setAuthority(resultSet.getString("user_authority"));
				System.out.println("更新時の取得");
				System.out.println(dto.getFamilyName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getFamilyNameKana());
				System.out.println(dto.getLastNameKana());
				System.out.println(dto.getMail());
				System.out.println(dto.getGender());
				System.out.println(dto.getAuthority());
			} else {
				return null;
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return dto;
	}

}