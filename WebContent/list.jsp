
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
		<title>List画面</title>
		
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
				width:80;
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
				height:800px;
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
				<p>List</p>
			</div>
			<div>
				<s:if test="#session.loginAuthority == 1">
					<h3>アカウント一覧画面</h3>
					<s:form action="SearchListAction">
						<table border="1">
							<tr>
								<td>名前（姓）</td>
								<td><input type="text" name="familyNameSL" maxlength="100"/></td>
								<td>名前（名）</td>
								<td><input type="text" name="lastNameSL" maxlength="100"/></td>
							</tr>
							<tr>
								<td>カナ（姓）</td>
								<td><input type="text" name="familyNameKanaSL" maxlength="100"/></td>
								<td>カナ（名）</td>
								<td><input type="text" name="lastNameKanaSL" maxlength="100"/></td>
							</tr>
							<tr>
								<td>メールアドレス</td>
								<td><input type="text" name="mailSL" maxlength="100"/></td>
								<td>性別</td>
								<td>
									<input type="radio" name="genderSL" value="2" <s:if test="genderSL == 2">checked="checked"</s:if>checked>未選択
									<input type="radio" name="genderSL" value="0" <s:if test="genderSL == 0">checked="checked"</s:if>>男
									<input type="radio" name="genderSL" value="1" <s:if test="genderSL == 1">checked="checked"</s:if>>女
								</td>
							</tr>
							<tr>
								<td>アカウント権限</td>
								<td>
									<select class="dropdown" name="authoritySL">
										<option value="2" <s:if test="authoritySL == 2">selected="selected"</s:if>>未選択</option>
										<option value="0" <s:if test="authoritySL == 0">selected="selected"</s:if>>一般</option>
										<option value="1" <s:if test="authoritySL == 1">selected="selected"</s:if>>管理者</option>
									</select>
								</td>
								<td colspan="2">
								</td>
							</tr>
						</table>
						<div style="width:600px; margin:10px auto 0; text-align:right;">
						    <input type="submit" value="検索">
						</div>
					</s:form>
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
