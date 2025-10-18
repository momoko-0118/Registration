package com.diworksdev.Registration.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegistConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String lastName;
	private String familyNameKana;
	private String lastNameKana;
	private String mail;
	private String password;
	private String password2;
	private int gender;
	private String gen;
	private int postalCode;
	private String prefecture;
	private String address1;
	private String address2;
	private int authority;
	private String autho;
	
	public Map<String,Object>session;
	private String errorMessage;
	private String errorFamilyName;
	private String errorLastName;
	private String errorFamilyNameKana;
	private String errorLastNameKana;
	private String errorMail;
	private String errorPassword;
	private String errorGender;
	private String errorPostalCode;
	private String errorPrefecture;
	private String errorAddress1;
	private String errorAddress2;
	private String errorAuthority;
	
	private String[] pre = {"北海道", "青森", "岩手", "宮城", "秋田", "山形", "福島",
			"茨城", "栃木", "群馬", "埼玉", "千葉", "東京", "神奈川","新潟", "富山",
			"石川", "福井", "山梨", "長野", "岐阜", "静岡", "愛知", "三重",
	        "滋賀", "京都", "大阪", "兵庫", "奈良", "和歌山","鳥取", "島根", "岡山",
	        "広島", "山口", "徳島", "香川", "愛媛", "高知",
	        "福岡", "佐賀", "長崎", "熊本", "大分", "宮崎", "鹿児島", "沖縄"};
	public String execute() {
		String result=SUCCESS;
		
		MessageDigest sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] sha256Byte = sha256.digest("password".getBytes());			
			System.out.println(sha256.digest("password".getBytes()));
			System.out.println(sha256Byte);
			session.put("sha256Byte",sha256Byte);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		if(!(familyName.equals("")) || familyName.length() > 10) {
			session.put("familyName",familyName);
		}else {
			setErrorFamilyName("名前（姓）が未入力です");
			result=ERROR;
		}
		if(!(lastName.equals(""))) {
				session.put("lastName",lastName);
		}else {
			setErrorLastName("名前（名）が未入力です");
			result=ERROR;
		}
		if(!(familyNameKana.equals(""))) {
			session.put("familyNameKana",familyNameKana);
		}else {
			setErrorFamilyNameKana("カナ（姓）が未入力です");
			result=ERROR;
		}
		if(!(lastNameKana.equals(""))) {
				session.put("lastNameKana",lastNameKana);
		}else {
			setErrorLastNameKana("カナ（姓）が未入力です");
			result=ERROR;
		}
		if(!(mail.equals(""))) {
			session.put("mail",mail);
		}else {
			setErrorMail("メールアドレスが未入力です");
			result=ERROR;
		}
		
		if(!(password.equals(""))) {	
			session.put("password", password); 
			this.password2=String.format("%"+password.length()+"s","").replace(' ', '●');
			System.out.println(password.length());
			System.out.println(String.format("%"+password.length()+"s",""));
			session.put("password2", password2);
			System.out.println(password2);
		} else {
		    setErrorPassword("パスワードが未入力です");
		    result = ERROR;
		}
		
		if(gender==0) {
			// 男
			this.gen="男";
			session.put("gender",gender);
			//session.put("gen",this.gen);
		}else if(gender==1) {
			// 女
			this.gen="女";
			session.put("gender",gender);
			//session.put("gen",this.gen);
		}else {
			setErrorGender("性別が未入力です");
			result=ERROR;
		}
		
		if(postalCode !=0) {
				session.put("postalCode",postalCode);
		}else {
			setErrorPostalCode("郵便番号が未入力です");
			result=ERROR;
		}
		if(prefecture !=null && Arrays.asList(pre).contains(prefecture)) {
			session.put("prefecture",prefecture);
		}else {
			setErrorPrefecture("住所（都道府県）が未入力です");
			result=ERROR;
		}
		if(!(address1.equals(""))) {
				session.put("address1",address1);
		}else {
			setErrorAddress1("住所（市区町村）が未入力です");
			result=ERROR;
		}
		if(!(address2.equals(""))) {
			session.put("address2",address2);
		}else {
			setErrorAddress2("住所（番地）が未入力です");
			result=ERROR;
		}
		
		if(authority==0) {
			this.autho="一般";
			session.put("authority",authority);
		}else if(authority==1){
			this.autho="管理者";
			session.put("authority",authority);
		}else {
			setErrorAuthority("権限が未入力です");
			result=ERROR;
		}
		System.out.println(session);
		return result;
	}
	
	public String getSha256Byte() {
		return getSha256Byte();
	}
	
	public void setSha256Byte(String sha256Byte) {
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword2() {
		return password2;
	}
	
	public void setPassword2(String password2) {
		this.password2=password2;
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
	
	public String getPostalCode() {
		return String.format("%07d", postalCode);
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode=postalCode;
	}
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture=prefecture;
	}
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1=address1;
	}
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2=address2;
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
	
	public Map<String,Object>getSession(){
		return session;
	}
	
	@Override
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	
	public String getErrorFamilyName() {
		return errorFamilyName;
	}
	
	public void setErrorFamilyName(String errorFamilyName) {
		this.errorFamilyName=errorFamilyName;
	}
	
	public String getErrorLastName() {
		return errorLastName;
	}
	
	public void setErrorLastName(String errorLastName) {
		this.errorLastName=errorLastName;
	}
	
	public String getErrorFamilyNameKana() {
		return errorFamilyNameKana;
	}
	
	public void setErrorFamilyNameKana(String errorFamilyNameKana) {
		this.errorFamilyNameKana=errorFamilyNameKana;
	}
	
	public String getErrorLastNameKana() {
		return errorLastNameKana;
	}
	
	public void setErrorLastNameKana(String errorLastNameKana) {
		this.errorLastNameKana=errorLastNameKana;
	}
	
	public String getErrorMail() {
		return errorMail;
	}
	
	public void setErrorMail(String errorMail) {
		this.errorMail=errorMail;
	}
	
	public String getErrorPassword() {
		return errorPassword;
	}
	
	public void setErrorPassword(String errorPassword) {
		this.errorPassword=errorPassword;
	}
	
	public String getErrorGender() {
		return errorGender;
	}
	
	public void setErrorGender(String errorGender) {
		this.errorGender=errorGender;
	}
	
	public String getErrorPostalCode() {
		return errorPostalCode;
	}
	
	public void setErrorPostalCode(String errorPostalCode) {
		this.errorPostalCode=errorPostalCode;
	}
	
	public String getErrorPrefecture() {
		return errorPrefecture;
	}
	
	public void setErrorPrefecture(String errorPrefecture) {
		this.errorPrefecture=errorPrefecture;
	}
	
	public String getErrorAddress1() {
		return errorAddress1;
	}
	
	public void setErrorAddress1(String errorAddress1) {
		this.errorAddress1=errorAddress1;
	}
	
	public String getErrorAddress2() {
		return errorAddress2;
	}
	
	public void setErrorAddress2(String errorAddress2) {
		this.errorAddress2=errorAddress2;
	}
	
	public String getErrorAuthority() {
		return errorAuthority;
	}
	
	public void setErrorAuthority(String errorAuthority) {
		this.errorAuthority=errorAuthority;
	}
	
	public String[] getPre() {
		return pre;
	}
	
	public void setPre(String[] pre) {
		this.pre=pre;
	}
}