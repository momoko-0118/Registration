package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.Registration.dto.UserUpdateDTO;
import com.diworksdev.Registration.util.DBConnector;
import com.diworksdev.Registration.util.DateUtil;

public class UserUpdateDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public UserUpdateDTO getUser(int id) throws SQLException {	
		UserUpdateDTO dto=new UserUpdateDTO();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,lut.gender,git.user_gender,lut.postal_code,lut.prefecture,"
				+ "lut.address_1,lut.address_2,lut.authority,ait.user_authority,fit.flg,lut.delete_flg,"
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
				dto.setUserGender(resultSet.getString("user_gender"));
				dto.setGender(resultSet.getInt("gender"));
				dto.setPostal_Code(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress_1(resultSet.getString("address_1"));
				dto.setAddress_2(resultSet.getString("address_2"));
				dto.setUserAuthority(resultSet.getString("user_authority"));
				dto.setAuthority(resultSet.getInt("authority"));
				dto.setDeleteFlg(resultSet.getInt("delete_flg"));
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
	
	public UserUpdateDTO updateUser(int id) throws SQLException {	
		UserUpdateDTO dto=new UserUpdateDTO();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,lut.gender,git.user_gender,lut.postal_code,lut.prefecture,"
				+ "lut.address_1,lut.address_2,lut.authority,ait.user_authority,fit.flg,lut.delete_flg,"
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
				dto.setUserGender(resultSet.getString("user_gender"));
				dto.setGender(resultSet.getInt("gender"));
				dto.setPostal_Code(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress_1(resultSet.getString("address_1"));
				dto.setAddress_2(resultSet.getString("address_2"));
				dto.setUserAuthority(resultSet.getString("user_authority"));
				dto.setAuthority(resultSet.getInt("authority"));
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
	
	private DateUtil dateUtil=new DateUtil();
	private String sql="UPDATE login_user_transaction SET family_name = ?,last_name =?,family_name_kana = ?,last_name_kana = ?,"
			+ "mail = ?,password = ?,gender = ?,postal_code = ?,prefecture = ?,address_1 = ?,address_2 = ?,authority = ?,"
			+ "delete_flg = ?,update_time = ? WHERE id = ?";

	public boolean updateUser(String familyName,String lastName,String familyNameKana,String lastNameKana,String mail,String password,
			String gender,String postal_code,String prefecture,String address_1,String address_2,String authority,String deleteFlg,String id) {
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameKana);
			preparedStatement.setString(4,lastNameKana);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,password);
			preparedStatement.setString(7,gender);
			preparedStatement.setString(8,postal_code);
			preparedStatement.setString(9,prefecture);
			preparedStatement.setString(10,address_1);
			preparedStatement.setString(11,address_2);
			preparedStatement.setString(12,authority);
			preparedStatement.setString(13,deleteFlg);
			preparedStatement.setString(14,dateUtil.getDate());
			preparedStatement.setString(15,id);
			preparedStatement.execute();			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}