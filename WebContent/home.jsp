<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
    <title>演習</title>
    <link rel="stylesheet"type="text/css"href="./css/style.css">
</head>

<body>
    <img src="${pageContext.request.contextPath}/pic/diblog_logo.jpg">
    <header>
        <ul>
            <li> <span id="top">トップ</span></li>
            <li>プロフィール</li>
            <li>D.I.Blogについて</li>
            <li><a href='<s:url action="RegistAction"/>'>アカウント登録</a></li>
            <li><a href='<s:url action="ListAction"/>'>アカウント一覧</a></li>
            <li>登録フォーム</li>
            <li>問い合わせ</li>
            <li>その他</li>
        </ul>
    </header>
    
    
    <main>
        <div class="main-container">
            <div class="left">
                <h1>プログラミングに役立つ書籍</h1>
                2017年1月15日<br>
                <img src="${pageContext.request.contextPath}/pic/bookstore.jpg"><br>
                <h2>D.I.BlogはD.I.Worksが提供する演習課題です。</h2>
                <h3>記事中身</h3>
                
                <div class="box2">  
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic1.jpg">
                        <p>ドメイン取得方法</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic2.jpg">
                        <p>快適な職場環境</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic3.jpg">
                        <p>Linuxの基礎</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic4.jpg">
                        <p>マーケティング入門</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic5.jpg">
                        <p>アクティブラーニング</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic6.jpg">
                        <p>CSSの効率的な勉強方法</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic7.jpg">
                        <p>リーダブルコードとは</p>
                    </div>
                    <div class="box_pic2">
                        <img src="${pageContext.request.contextPath}/pic/pic8.jpg">
                        <p>HTMLSの可能性</p>
                    </div>
                </div>
            </div>
            <div class="right">
                <h4>人気の記事</h4><br>
                <div class="box3">
                PHPオススメ本<br>
                PHP　MyAdminの使い方<br>
                いま人気のエディタTops<br>
                HTMLの基礎<br>
                </div>
                <h5>オススメリンク</h5>
                <div class="box3">
                ﾃﾞｨｰｱｲﾜｰｸｽ株式会社<br>
                XAMPPのダウンロード<br>
                Eclipseのダウンロード<br>
                Braketsのダウンロード<br>
                </div>
                <h5>カテゴリ</h5>
                <div class="box3">
                HTML<br>
                PHP<br>
                MySQL<br>
                JavaScript
                </div>
            </div>
        </div>
    </main>
    
    <footer>
        Copyright D.I.works|D.I.blog id the one which provides A to Z about programming
    </footer>
    
</body>



</html>