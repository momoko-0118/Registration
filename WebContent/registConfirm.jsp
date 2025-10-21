
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
		<title>UserCreateConfirm画面</title>
		
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
				<p>UserCreateConfirm</p>
			</div>
			<div>
				<h3>登録する内容は以下でよろしいですか</h3>
				<table>
					<s:form method="post" action="RegistCompleteAction">
						<tr id="box">
							<td>
								<label>名前（姓）</label>
							</td>
							<td>
								<s:property value="familyName" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>名前（名）</label>
							</td>
							<td>
								<s:property value="lastName" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>カナ（姓）</label>
							</td>
							<td>
								<s:property value="familyNameKana" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>カナ（名）</label>
							</td>
							<td>
								<s:property value="lastNameKana" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>メールアドレス</label>
							</td>
							<td>
								<s:property value="mail" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>パスワード</label>
							</td>
							<td>
								<s:property value="pass2" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>性別</label>
							</td>
							<td>
								<s:property value="gen" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>郵便番号</label>
							</td>
							<td>
								<s:property value="postalCode" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（都道府県）</label>
							</td>
							<td>
								<s:property value="prefecture" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（市区町村）</label>
							</td>
							<td>
								<s:property value="address1" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>住所（番地）</label>
							</td>
							<td>
								<s:property value="address2" escape="false"/>
							</td>
						</tr>
						<tr id="box">
							<td>
								<label>アカウント権限</label>
							</td>
							<td>
								<s:property value="autho" escape="false"/>
							</td>
							<td>
							<br>
								<span>
									<s:if test="errorMessage !=''">
										<s:property value="errorMessage" escape="false"/>
									</s:if>
								</span>
							</td>
						</tr>						
						<s:submit value="登録する"/>
					</s:form>
					<s:form method="post" action="RegistAction">
						<input type="button" value="前に戻る" onclick="history.back()"/>
					</s:form>
				</table>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
</html>
