<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Beans.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Beans確認</title>

	<style type="text/css">
		.block1{
		display:inline-block;
		width:4em;
		}
		.block2{
		display:inline-block;
		width:7em;
		}
	</style>

</head>
<body>

	<h1>Beans確認</h1>
	<form action="SerchServlet" method="post">
		名前：<input type="text" name="userName"/><br>
		<span class="block1">住所:</span><input type="radio" name="Address" value="Tokyo"/>東京<br>
		<span class="block1"></span><input type="radio" name="Address" value="chiba"/>千葉<br>
		<span class="block1"></span><input type="radio" name="Address" value="kanagawa"/>神奈川<br>
		<input type="submit" name="submit" value="POST通信"/>
	</form>
	<p style="margin-top:2.0em;"></p>
	
	<%
	List<BaseBean> listBase = (List<BaseBean>)request.getAttribute("listBase");
	if(listBase != null){
		for(int i=0; i<listBase.size(); i++){
			BaseBean bean = (BaseBean)listBase.get(i);
			
            out.println("<span class=\"block2\">ユーザー名：</span>" + bean.getUserName() + "<br>");
            out.println("<span class=\"block2\">住所：</span>" + bean.getAddress() + "<br>");
		}
	}
	
	%>
</body>
</html>