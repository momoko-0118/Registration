package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.Registration.dto.ListDTO;
import com.diworksdev.Registration.util.DBConnector;

public class ListDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public ArrayList<ListDTO> getAllList()
	throws SQLException{		
		ArrayList<ListDTO> list=new ArrayList<>();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,git.user_gender,ait.user_authority,fit.flg,"
				+ "lut.registered_time,lut.update_time FROM login_user_transaction lut "
				+ "LEFT JOIN gender_info_transaction git ON lut.gender=git.id "
				+ "LEFT JOIN authority_info_transaction ait ON lut.authority=ait.id "
				+ "LEFT JOIN flg_info_transaction fit ON lut.delete_flg=fit.id "
				+ "ORDER BY lut.registered_time DESC";
		
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