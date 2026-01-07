package com.diworksdev.Registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.Registration.dto.ListDTO;
import com.diworksdev.Registration.util.DBConnector;
import com.diworksdev.Registration.util.DateUtil;

public class UserInfoDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public ListDTO getUser(int id) throws SQLException {	
		ListDTO dto=new ListDTO();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,lut.gender,git.user_gender,lut.postal_code,lut.prefecture,"
				+ "lut.address_1,lut.address_2,lut.authority,ait.user_authority,fit.flg,"
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
				dto.setGender(resultSet.getString("gender"));
				dto.setPostal_Code(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress_1(resultSet.getString("address_1"));
				dto.setAddress_2(resultSet.getString("address_2"));
				dto.setUserAuthority(resultSet.getString("user_authority"));
				dto.setAuthority(resultSet.getString("authority"));
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
	
	public int deleteUser(int id) throws SQLException {	
	    String sql = "UPDATE login_user_transaction SET delete_flg = ? WHERE id = ?";

	    int result = 0;

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, 1);  
	        preparedStatement.setInt(2, id); 

	        result = preparedStatement.executeUpdate(); 

	        System.out.println("更新対象ID: " + id);
	        System.out.println("更新件数   : " + result);

	        if (result > 0) {
	            System.out.println("更新成功");
	        } else {
	            System.out.println("対象データなし");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        connection.close();
	    }
	    return result; 
	}

	public ListDTO updateUser(int id) throws SQLException {	
		ListDTO dto=new ListDTO();
		String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,lut.password,lut.gender,git.user_gender,lut.postal_code,lut.prefecture,"
				+ "lut.address_1,lut.address_2,lut.authority,ait.user_authority,fit.flg,"
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
				dto.setGender(resultSet.getString("gender"));
				dto.setPostal_Code(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress_1(resultSet.getString("address_1"));
				dto.setAddress_2(resultSet.getString("address_2"));
				dto.setUserAuthority(resultSet.getString("user_authority"));
				dto.setAuthority(resultSet.getString("authority"));
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
	
	private String sqlWithoutPassword="UPDATE login_user_transaction SET family_name = ?,last_name =?,family_name_kana = ?,last_name_kana = ?,"
			+ "mail = ?,gender = ?,postal_code = ?,prefecture = ?,address_1 = ?,address_2 = ?,authority = ?,"
			+ "delete_flg = ?,update_time = ? WHERE id = ?";
	public boolean updateUserWithoutPassword(String familyName,String lastName,String familyNameKana,String lastNameKana,String mail,
			String gender,String postal_code,String prefecture,String address_1,String address_2,String authority,String deleteFlg,String id) {
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlWithoutPassword);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameKana);
			preparedStatement.setString(4,lastNameKana);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,gender);
			preparedStatement.setString(7,postal_code);
			preparedStatement.setString(8,prefecture);
			preparedStatement.setString(9,address_1);
			preparedStatement.setString(10,address_2);
			preparedStatement.setString(11,authority);
			preparedStatement.setString(12,deleteFlg);
			preparedStatement.setString(13,dateUtil.getDate());
			preparedStatement.setString(14,id);
			preparedStatement.execute();			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private String sqlWithPassword="UPDATE login_user_transaction SET family_name = ?,last_name =?,family_name_kana = ?,last_name_kana = ?,"
			+ "mail = ?,password = ?,gender = ?,postal_code = ?,prefecture = ?,address_1 = ?,address_2 = ?,authority = ?,"
			+ "delete_flg = ?,update_time = ? WHERE id = ?";
	public boolean updateUserWithPassword(String familyName,String lastName,String familyNameKana,String lastNameKana,String mail,String password,
			String gender,String postal_code,String prefecture,String address_1,String address_2,String authority,String deleteFlg,String id) {
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlWithPassword);
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