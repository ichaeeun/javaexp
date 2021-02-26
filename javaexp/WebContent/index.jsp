<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
<!-- 
/Users/ichaeeun/apache-tomcat-9.0.41/lib에서 
jsp-api.jar, servlet-api.jar 복사해서 
javaexp\WebContent\WEB-INF\lib 폴더에 위치. 
 -->

<%
	String name = "홍길동";
	int age = 25;
	String prod = "사과"; //DB에서 가져온 내용을 java로만 초기 할당할 수 있다. 
	//index.jsp=> indexServlet.java(java+html) html로 최종만들어서 client에 전달
%>
<h2>이름: <%=name %></h2>
<h3>html코드도 개발하고</h3>
<h4>나이:<%=age %></h4>
<h3>물건:<%=prod %></h3>
</body>
</html>