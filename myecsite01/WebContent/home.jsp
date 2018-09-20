<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="itemtoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>Home画面</title>
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

	 <script>
    $(document).ready(function(){
      $('.abc').bxSlider({
       auto: true,
       mode: 'fade',
       pause: 5000,
       speed: 2000
                         });
    });
 	</script>


	<style type="text/css">
	body{
	margin:0;
	padding:0;
	line-height:1.6;
	letter-spacing:1px;
	font-family:Verdana,Helvetica,sans-serif;
	font-size:12px;
	color:#333;
	background-image:url("haikei1.jpg");
	}

	table{
	text-align:center;
	margin:0 auto;
	}

	#top{
	width:780px;
	margin:30px auto;
	border:1px solid #333;

	}

	#header{
	height:50px;
	padding:30px;
	background-color:#CCCCCC;
	background-size:cover;
	text-align:left;
	font-size:20px;

	}

	#main{
	width:100%;
	height:800px;
	text-align:center;
	}

	.abc img{
	width:700px;
	max-width:100%;
	display: block;
	margin: 0 auto;

	}

	.bx-wrapper {
  	margin: 30 auto;
  	-moz-box-shadow: none;
  	-webkit-box-shadow: none;
  	box-shadow: none;
  	border: none;
  	background: none;

  }

	#footer{
	width:100%;
	height:50px;
	background-color:#CCCCCC;
	text-align:center;
	line-height:50px;
	font-size:10px;
	color:white;
	clear:both;
	}

	#text-center{

	display:inline-block;
	text-align:center;
	}

	</style>
</head>
<body>

	<div id="header">
		<div id="pr">
		<h1>Ocha</h1>
		</div>
	</div>
	<div id="main">

		<div id="top"><p>Home</p></div>
	    <div><ul class="abc">
	      <li><img src="Home2.jpg"></li>
	      <li><img src="Home3.jpg"></li>
	      <li><img src="Home.jpg"></li>
	      <li><img src="Home4.jpg"></li>
	      <li><img src="Home5.jpg"></li>
	   </ul>
	   </div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入へ"/>
			</s:form>
			<s:if test="#session.id != null">
				<p>ログアウトする場合は
				<a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>
			</s:if>
		</div>
	</div>
	<div id="footer">
		<div id="pr"> Copyright © 2018 MYECSITE01. All Rights Reserved. </div>
	</div>

</body>
</html>