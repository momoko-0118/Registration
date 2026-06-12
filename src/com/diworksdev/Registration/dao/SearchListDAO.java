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
	    int gender = (int)map.get("gender");
	    int authority = (int)map.get("authority");
	    
	    String sql="SELECT lut.id,lut.family_name,lut.last_name,lut.family_name_kana,"
				+ "lut.last_name_kana,lut.mail,git.user_gender,ait.user_authority,fit.flg,"
				+ "lut.registered_time,lut.update_time FROM login_user_transaction lut "
				+ "LEFT JOIN gender_info_transaction git ON lut.gender=git.id "
				+ "LEFT JOIN authority_info_transaction ait ON lut.authority=ait.id "
				+ "LEFT JOIN flg_info_transaction fit ON lut.delete_flg=fit.id "
				+ "WHERE lut.family_name LIKE ? AND lut.last_name LIKE ? "
				+ "AND lut.family_name_kana LIKE ? AND lut.last_name_kana LIKE ? "
				+ "AND lut.mail LIKE ? AND (? = 2 OR lut.gender = ?) "
				+ "AND (? = 2 OR lut.authority = ?) "
				+ "ORDER BY lut.registered_time DESC";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		int n = 1;
		if(familyName.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else{
			preparedStatement.setString(n, "%" + familyName + "%");
			n++;
		}
		if(lastName.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + lastName + "%");
			n++;
		}
		if(familyNameKana.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + familyNameKana + "%");
			n++;
		}
		if(lastNameKana.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + lastNameKana + "%");
			n++;
		}
		if(mail.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + mail+ "%");
			n++;
		}
		if(gender == 0) {
			preparedStatement.setInt(n, gender);
			System.out.println(gender + "男");
			n++;
			preparedStatement.setInt(n, gender);
			n++;
		}
		else if(gender == 1) {
			preparedStatement.setInt(n, gender);
			System.out.println(gender + "女");
			n++;
			preparedStatement.setInt(n, gender);
			n++;
		}
		else {
			preparedStatement.setInt(n, gender);
			System.out.println(gender + "未選択");
			n++;
			preparedStatement.setInt(n, gender);
			n++;
		}
		if(authority == 0) {
			preparedStatement.setInt(n, authority);
			System.out.println(gender + "一般");
			n++;
			preparedStatement.setInt(n, authority);
			n++;
		}
		else if(authority == 1) {
			preparedStatement.setInt(n, authority);
			System.out.println(authority + "管理者");
			n++;
			preparedStatement.setInt(n, authority);
			n++;
		}
		else {
			preparedStatement.setInt(n, authority);
			System.out.println(gender + "未選択");
			n++;
			preparedStatement.setInt(n, authority);
			n++;
		}
		
		try {
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
				/*System.out.println(dto.getFamilyName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getFamilyNameKana());
				System.out.println(dto.getLastNameKana());
				System.out.println(dto.getMail());
				System.out.println(dto.getGender());
				System.out.println(dto.getAuthority());
				System.out.println(dto.getDeleteFlg());
				System.out.println(dto.getRegistered_time());
				System.out.println(dto.getUpdate_time());*/
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return list;
	}

}
