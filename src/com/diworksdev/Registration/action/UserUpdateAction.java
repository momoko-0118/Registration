package com.diworksdev.Registration.action; 
import java.sql.SQLException;

import com.diworksdev.Registration.dao.UserUpdateDAO;
import com.diworksdev.Registration.dto.UserUpdateDTO;
import com.opensymphony.xwork2.ActionSupport; 

public class UserUpdateAction extends ActionSupport { 
	private int id; 
	private String familyName; 
	private String lastName; 
	private String familyNameKana; 
	private String lastNameKana; 
	private String mail; 
	private String pass2; 
	private String password; 
	private int gender; 
	private String gen; 
	private String postal_code; 
	private String prefecture; 
	private String address_1; 
	private String address_2; 
	private int authority; 
	private String autho; 
	private int deleteFlg; 
	
	private UserUpdateDTO user = new UserUpdateDTO(); 
	private final UserUpdateDAO userUpdateDAO = new UserUpdateDAO(); 
	
	@Override 
	public String execute() { 
		try { 
			if (familyName == null) { 
				user = userUpdateDAO.getUser(id); 
			} else { 
				user = new UserUpdateDTO(); 
				user.setId(String.valueOf(id)); 
				user.setFamilyName(familyName); 
				user.setLastName(lastName); 
				user.setFamilyNameKana(familyNameKana); 
				user.setLastNameKana(lastNameKana); 
				user.setMail(mail); 
				user.setPassword(password); 
				user.setGender(gender); 
				user.setPostal_Code(postal_code); 
				user.setPrefecture(prefecture); 
				user.setAddress_1(address_1); 
				user.setAddress_2(address_2); 
				user.setAuthority(authority); 
			} 
			System.out.println("UserUpdateAction user = " + user); 
			return SUCCESS; 
		} catch (SQLException e) { 
			e.printStackTrace(); return ERROR; 
		} 
	} 
	
	public UserUpdateDTO getUser() { 
		return user; 
	} 
	
	public void setUser(UserUpdateDTO user) { 
		this.user = user; 
	} 
	
	public int getId() { 
		return id; 
	} 
	
	public void setId(int id) { 
		this.id = id; 
	}

	public String getFamilyName() { 
		return familyName; 
	}
	
	public void setFamilyName(String familyName) { 
		this.familyName=familyName; 
	} 
	
	public String getLastName() { 
		return lastName; 
	} 
	
	public void setLastName(String lastName) { 
		this.lastName=lastName; 
	} 
	
	public String getFamilyNameKana() { 
		return familyNameKana; 
	} 
	
	public void setFamilyNameKana(String familyNameKana) { 
		this.familyNameKana=familyNameKana; 
	} 
	
	public String getLastNameKana() { 
		return lastNameKana; 
	} 
	
	public void setLastNameKana(String lastNameKana) { 
		this.lastNameKana=lastNameKana; 
	} 
	
	public String getMail() { 
		return mail; 
	} 
	
	public void setMail(String mail) { 
		this.mail=mail; 
	} 
	
	public String getPass2() { 
		return pass2; 
	} 
	
	public void setPass2(String pass2) { 
		this.pass2=pass2; 
	} 
	
	public String getPassword() { 
		return password; 
	} 
	
	public void setPassword(String password) { 
		this.password=password; 
	} 
	
	public int getGender() { 
		return gender; 
	} 
	
	public void setGender(int gender) { 
		this.gender=gender; 
	} 
	
	public String getGen() { 
		return gen; 
	} 
	
	public void setGen(String gen) { 
		this.gen=gen; 
	} 
	
	public String getPostal_code() { 
		return postal_code;
	} 
	
	public void setPostal_code(String postal_code) { 
		this.postal_code=postal_code; 
	} 
	
	public String getPrefecture() { 
		return prefecture; 
	} 
	
	public void setPrefecture(String prefecture) { 
		this.prefecture=prefecture; 
	} 
	
	public String getAddress_1() { 
		return address_1; 
	} 
	
	public void setAddress_1(String address_1) { 
		this.address_1=address_1; 
	} 
	
	public String getAddress_2() { 
		return address_2; 
	} 
	
	public void setAddress_2(String address_2) { 
		this.address_2=address_2; 
	} 
	
	public int getAuthority() { 
		return authority; 
	} 
	
	public void setAuthority(int authority) { 
		this.authority=authority; 
	} 
	
	public String getAutho() { 
		return autho; 
	}
	
	public void setAutho(String autho) { 
		this.autho=autho; 
	} 
	
	public int getDeleteFlg() { 
		return deleteFlg; 
	} 
	
	public void setDeleteFlg(int deleteFlg) { 
		this.deleteFlg=deleteFlg; 
	}
}