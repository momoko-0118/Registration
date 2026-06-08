
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
				<s:if test="#session.authority == 1">
					<h3>アカウント一覧画面</h3>
					<s:form action="SearchListAction">
						<table border="1">
							<tr>
								<td>名前（姓）</td>
								<td><input type="text" name="familyName" maxlength="100" value="${familyName}"/></td>
								<td>名前（名）</td>
								<td><input type="text" name="lastName" maxlength="100" value="${lastName}"/></td>
							</tr>
							<tr>
								<td>カナ（姓）</td>
								<td><input type="text" name="familyNameKana" maxlength="100" value="${familyNameKana}"/></td>
								<td>カナ（名）</td>
								<td><input type="text" name="lastNameKana" maxlength="100" value="${lastNameKana}"/></td>
							</tr>
							<tr>
								<td>メールアドレス</td>
								<td><input type="text" name="mail" maxlength="100" value="${mail}"/></td>
								<td>性別</td>
								<td>
									<input type="radio" checked="checked">未選択
									<input type="radio" name="gender" value="0" <s:if test="gender == 0">checked="checked"</s:if>>男
									<input type="radio" name="gender" value="1" <s:if test="gender == 1">checked="checked"</s:if>>女
								</td>
							</tr>
							<tr>
								<td>アカウント権限</td>
								<td>
									<select class="dropdown" name="authority">
										<option value="2">未選択</option>
										<option value="0">一般</option>
										<option value="1">管理者</option>
									</select>
								</td>
							</tr>
							<tr>
								<s:submit value="検索"/>
							</tr>
						</table>
					</s:form>
					<s:if test="users">
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
									<td>
										<s:if test="'有効'.equals(deleteFlg)">
	 										<s:form action="UserUpdateAction">
	  											<input type="hidden" name="id" value="<s:property value='id'/>" />
	 											<s:submit value="更新"/>
											</s:form>
										</s:if>
										<s:else>
											<span>更新不可</span>
										</s:else>
									</td>
									<td>
										<s:if test="'有効'.equals(deleteFlg)">
	 										<s:form action="UserDeleteAction" value="id">
	  											<input type="hidden" name="id" value="<s:property value='id'/>" />
	 											<s:submit value="削除"/>
											</s:form>
										</s:if>
										<s:else>
											<span>更新不可</span>
										</s:else>
									</td>
								</tr>
							</s:iterator>
							<s:actionerror/>
						</table>
					</s:if>
					<s:else>
						<h3>情報はありません。</h3>
					</s:else>
					<s:if test="session.message !=null">
						<h3><s:property value="message"/></h3>
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
