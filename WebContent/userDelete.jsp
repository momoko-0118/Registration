
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
		<title>UserDelete画面</title>
		
		<style type="text/css">
		/*=======TAG LAYOUT=======*/
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
			
		/*========ID LAYOUT=========*/
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
			
			#text-right{
				display:inline-block;
				text-align:right;
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
				<p>UserDelete</p>
			</div>
			<div>
				<s:if test="#session.loginAuthority == 1">
					<s:if test="user">
						<h3>アカウント削除画面</h3>
						<table>
							<s:form method="post" action="UserDeleteConfirmAction">
								<s:iterator value="user">
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
											表示されません
										</td>
									</tr>
									<tr id="box">
										<td>
											<label>性別</label>
										</td>
										<td>
											<s:property value="userGender" escape="false"/>
										</td>
									</tr>
									<tr id="box">
										<td>
											<label>郵便番号</label>
										</td>
										<td>
											<s:property value="postal_code" escape="false"/>
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
											<s:property value="address_1" escape="false"/>
										</td>
									</tr>
									<tr id="box">
										<td>
											<label>住所（番地）</label>
										</td>
										<td>
											<s:property value="address_2" escape="false"/>
										</td>
									</tr>
									<tr id="box">
										<td>
											<label>アカウント権限</label>
										</td>
										<td>
											<s:property value="userAuthority" escape="false"/>
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
								</s:iterator>	
								<input type="hidden" name="id" value="<s:property value='id'/>" />				
								<s:submit value="確認する"/>
							</s:form>
							<s:form method="post" action="ListAction">
								<s:submit value="前に戻る"/>
							</s:form>
						</table>
					</s:if>
				</s:if>
				<s:else>
					エラーが発生しました
				</s:else>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>

</html>
