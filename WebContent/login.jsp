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
		<title>UserCreateComplete画面</title>
		
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
		
		h3{
			font-size:50px;
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
				<p>Login</p>
			</div>
			<div>
				<s:form action="LoginAction">
					<table>
						<tr>
							<td>
								<label>メールアドレス</label>
							</td>
							<td>
								<s:textfield name="loginMail"/>
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード</label>
							</td>
							<td>
								<s:password name="loginPassword"/>
							</td>
						</tr>
						<tr>
							<td>
								<s:submit value="ログイン"/>
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
					</table>
				</s:form>
			</div>
			
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
</html>