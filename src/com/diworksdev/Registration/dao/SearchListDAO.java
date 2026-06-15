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
		String familyNameSL = (String)map.get("familyNameSL");
	    String lastNameSL = (String)map.get("lastNameSL");
	    String familyNameKanaSL = (String)map.get("familyNameKanaSL");
	    String lastNameKanaSL = (String)map.get("lastNameKanaSL");
	    String mailSL = (String)map.get("mailSL");
	    int genderSL = (int)map.get("genderSL");
	    int authoritySL = (int)map.get("authoritySL");
	    
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
		if(familyNameSL == null || familyNameSL.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else{
			preparedStatement.setString(n, "%" + familyNameSL + "%");
			n++;
		}
		if(lastNameSL == null || lastNameSL.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + lastNameSL + "%");
			n++;
		}
		if(familyNameKanaSL == null ||familyNameKanaSL.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + familyNameKanaSL + "%");
			n++;
		}
		if(lastNameKanaSL == null || lastNameKanaSL.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + lastNameKanaSL + "%");
			n++;
		}
		if(mailSL == null || mailSL.isEmpty()) {
			preparedStatement.setString(n, "%");
			n++;
		}
		else {
			preparedStatement.setString(n, "%" + mailSL+ "%");
			n++;
		}
		if(genderSL == 0) {
			preparedStatement.setInt(n, genderSL);
			System.out.println(genderSL + "男");
			n++;
			preparedStatement.setInt(n, genderSL);
			n++;
		}
		else if(genderSL == 1) {
			preparedStatement.setInt(n, genderSL);
			System.out.println(genderSL + "女");
			n++;
			preparedStatement.setInt(n, genderSL);
			n++;
		}
		else {
			preparedStatement.setInt(n, genderSL);
			System.out.println(genderSL + "未選択");
			n++;
			preparedStatement.setInt(n, genderSL);
			n++;
		}
		if(authoritySL == 0) {
			preparedStatement.setInt(n, authoritySL);
			System.out.println(genderSL + "一般");
			n++;
			preparedStatement.setInt(n, authoritySL);
			n++;
		}
		else if(authoritySL == 1) {
			preparedStatement.setInt(n, authoritySL);
			System.out.println(authoritySL + "管理者");
			n++;
			preparedStatement.setInt(n, authoritySL);
			n++;
		}
		else {
			preparedStatement.setInt(n, authoritySL);
			System.out.println(genderSL + "未選択");
			n++;
			preparedStatement.setInt(n, authoritySL);
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
