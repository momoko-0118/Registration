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
								<s:if test="errorMessage !=''">
									<s:property value="errorMessage" escape="false"/>
								</s:if>
							</td>
							<td>
								<input type="text" name="familyName" value=""/>
							</td>
							<td>
								<label>名前（名）</label><br>
								<s:if test="errorMessage !=''">
									<s:property value="errorMessage" escape="false"/>
								</s:if>
							</td>
							<td>
								<input type="text" name="lastName" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>カナ（姓）</label>
							</td>
							<td>
								<input type="text" name="familyNameKana" value=""/>
							</td>
							<td>
								<label>カナ（名）</label>
							</td>
							<td>
								<input type="text" name="lastNameKana" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>メールアドレス</label>
							</td>
							<td>
								<input type="text" name="mail" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード</label>
							</td>
							<td>
								<input type="password" name="password" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>性別</label>
							</td>
							<td>
								<input type="radio" name="gender" value="0" checked="checked">男
								<input type="radio" name="gender" value="1">女
							</td>
						</tr>
						<tr>
							<td>
								<label>郵便番号</label>
							</td>
							<td>
								<input type="text" name="postalCode" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（都道府県）</label>
							</td>
							<td>
								<select class="dropdown" name="prefecture">
 									<option value="" selected></option>
    								<option value="北海道">北海道</option>
   									<option value="青森県">青森県</option>
    								<option value="岩手県">岩手県</option>
   									<option value="宮城県">宮城県</option>
    								<option value="秋田県">秋田県</option>
    								<option value="山形県">山形県</option>
    								<option value="福島県">福島県</option>
    								<option value="茨城県">茨城県</option>
    								<option value="栃木県">栃木県</option>
    								<option value="群馬県">群馬県</option>
    								<option value="埼玉県">埼玉県</option>
    								<option value="千葉県">千葉県</option>
    								<option value="東京都">東京都</option>
    								<option value="神奈川県">神奈川県</option>
    								<option value="新潟県">新潟県</option>
    								<option value="富山県">富山県</option>
    								<option value="石川県">石川県</option>
    								<option value="福井県">福井県</option>
    								<option value="山梨県">山梨県</option>
    								<option value="長野県">長野県</option>
    								<option value="岐阜県">岐阜県</option>
    								<option value="静岡県">静岡県</option>
    								<option value="愛知県">愛知県</option>
    								<option value="三重県">三重県</option>
    								<option value="滋賀県">滋賀県</option>
    								<option value="京都府">京都府</option>
    								<option value="大阪府">大阪府</option>
    								<option value="兵庫県">兵庫県</option>
    								<option value="奈良県">奈良県</option>
    								<option value="和歌山県">和歌山県</option>
    								<option value="鳥取県">鳥取県</option>
    								<option value="島根県">島根県</option>
    								<option value="岡山県">岡山県</option>
    								<option value="広島県">広島県</option>
    								<option value="山口県">山口県</option>
    								<option value="徳島県">徳島県</option>
    								<option value="香川県">香川県</option>
    								<option value="愛媛県">愛媛県</option>
    								<option value="高知県">高知県</option>
    								<option value="福岡県">福岡県</option>
    								<option value="佐賀県">佐賀県</option>
    								<option value="長崎県">長崎県</option>
    								<option value="熊本県">熊本県</option>
    								<option value="大分県">大分県</option>
    								<option value="宮崎県">宮崎県</option>
    								<option value="鹿児島県">鹿児島県</option>
    								<option value="沖縄県">沖縄県</option>
								</select>												
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（市区町村）</label>
							</td>
							<td>
								<input class="text" name="address1" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>住所（番地）</label>
							</td>
							<td>
								<input type="text" name="address2" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>アカウント権限</label>
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