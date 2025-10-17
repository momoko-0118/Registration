<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="Content-Style-Type" content="text/css"/>
		<meta http-equiv="Content-Script-Type" content="text/javascript"/>
		<meta http-equiv="imagetoolbar" content="no"/>
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<title>UserCreate画面</title>
		
		<style type="text/css">
		/*=====TAG LAYOUT=====*/
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}
		
		table{
			text-align:center;
			margin:0 auto;
		}
		
		span{
			color:red;
		}
		
		/*=====ID LAYOUT=====*/
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}
		
		#header{
			width:100%;
			height:80px;
			background-color:black;
		}
		
		#main{
			width:100%;
			height:500px;
			text-align:center;
		}
		
		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}
		</style>		
	</head>

	<body>
		<div id="header">
			<div id="pr">
			</div>
		</div>
		<div id="main">
			<div id="top">
				<p>UserCreate</p>
			</div>
			<div>
				<table>
					<s:form action="RegistConfirmAction">
						<tr>
							<td>
								<label>名前（姓）</label><br>
								<span>
									<s:if test="errorFamilyName !=''">
										<s:property value="errorFamilyName" escape="false"/>	
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="familyName" value="" maxlength="10" 
								pattern="[\u4E00-\u9FFF\u3005-\u3007\u3041-\u3096]*"/>
							</td>
							<td>
								<label>名前（名）</label><br>
								<span>
									<s:if test="errorLastName !=''">
										<s:property value="errorLastName" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="lastName" value="" maxlength="10" 
								pattern="[\u4E00-\u9FFF\u3005-\u3007\u3041-\u3096]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>カナ（姓）</label><br>
								<span>
									<s:if test="errorLastName !=''">
										<s:property value="errorLastName" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="familyNameKana" value="" maxlength="10" 
								pattern="[\u30A1-\u30FA]*"/>
							</td>
							<td>
								<label>カナ（名）</label><br>
								<span>
									<s:if test="errorLastNameKana !=''">
										<s:property value="errorLastNameKana" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="lastNameKana" value="" maxlength="10" 
								pattern="[\u30A1-\u30FA]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>メールアドレス</label><br>
								<span>
									<s:if test="errorMail !=''">
										<s:property value="errorMail" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="email" name="mail" value="" maxlength="100"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード</label><br>
								<span>
									<s:if test="errorPassword !=''">
										<s:property value="errorPassword" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="password" name="password" value="" maxlength="10" pattern="[a-zA-Z0-9]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>性別</label><br>
								<span>
									<s:if test="errorGender !=''">
										<s:property value="errorGender" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="radio" name="gender" value="0" checked="checked">男
								<input type="radio" name="gender" value="1">女
							</td>
						</tr>
						<tr>
							<td>
								<label>郵便番号</label><br>
								<span>
									<s:if test="errorPostalCode !=''">
										<s:property value="errorPostalCode" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="postalCode" value="" maxlength="7" 
								pattern="[0-9]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（都道府県）</label><br>
								<span>
									<s:if test="errorPrefecture !=''">
										<s:property value="errorPrefecture" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<select class="dropdown" name="prefecture">
								<option value=""></option>
								<script>
									var pre=["北海道", "青森", "岩手", "宮城", "秋田", "山形", "福島",
										"茨城", "栃木", "群馬", "埼玉", "千葉", "東京", "神奈川","新潟", "富山",
										"石川", "福井", "山梨", "長野", "岐阜", "静岡", "愛知", "三重",
								        "滋賀", "京都", "大阪", "兵庫", "奈良", "和歌山","鳥取", "島根", "岡山",
								        "広島", "山口", "徳島", "香川", "愛媛", "高知",
								        "福岡", "佐賀", "長崎", "熊本", "大分", "宮崎", "鹿児島", "沖縄"];
									for(var i=0; i < pre.length; i++){
										document.write("<option>" + pre[i] + "</option>");
									}
								</script> 									
								</select>												
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（市区町村）</label><br>
								<span>
									<s:if test="errorAddress1 !=''">
										<s:property value="errorAddress1" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input class="text" name="address1" value="" maxlength="10" 
								pattern="[\u4E00-\u9FFF\u3005-\u3007\u3041-\u3096\u30A1-\u30FA0-9\sー]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（番地）</label><br>
								<span>
									<s:if test="errorAddress2 !=''">
										<s:property value="errorAddress2" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<input type="text" name="address2" value="" maxlength="100"
								pattern="[-\u4E00-\u9FFF\u3005-\u3007\u3041-\u3096\u30A1-\u30FA0-9０-９\sー]*"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>アカウント権限</label><br>
								<span>
									<s:if test="errorAuthority !=''">
										<s:property value="errorAuthority" escape="false"/>
									</s:if>
								</span>
							</td>
							<td>
								<select class="dropdown" name="authority">
    	            				<option value="0">一般</option>
    	            				<option value="1">管理者</option>
    	            				
 				               </select>
 							</td>
						</tr>
						<s:submit value="確認する"/>
					</s:form>
				</table>
			</div>
			<div id="footer">
				<div id="pr">
				</div>
			</div>
		</div>
	</body>
</html>