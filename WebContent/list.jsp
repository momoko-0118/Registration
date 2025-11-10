
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
				<p>List</p>
			</div>
			<div>
				<s:if test="users">
					<h3>アカウント一覧画面</h3>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>名前（姓）</th>
							<th>名前（名）</th>
							<th>カナ（姓）</th>
							<th>カナ（名）</th>
							<th>メールアドレス</th>
							<th>性別</th>
							<th>アカウント権限</th>
							<th>削除フラグ</th>
							<th>登録日時</th>
							<th>更新日時</th>
							<th colspan="2">操作</th>
						</tr>
						<s:iterator value="users">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="familyName"/></td>
								<td><s:property value="lastName"/></td>
								<td><s:property value="familyNameKana"/></td>
								<td><s:property value="lastNameKana"/></td>
								<td><s:property value="mail"/></td>
								<td><s:property value="gender"/></td>
								<td><s:property value="authority"/></td>
								<td><s:property value="deleteFlg"/></td>
								<td><s:property value="registered_time"/></td>
								<td><s:property value="update_time"/></td>
								<td><button class="button">更新</button></td>
								<td><button class="button">削除</button></td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
				<s:else>
					<h3>情報はありません。</h3>
				</s:else>
				<s:if test="session.message !=null">
					<h3><s:property value="message"/></h3>
				</s:if>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>

</html>
