<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html >
<%
String imageURL=application.getInitParameter("imageURL"); 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<!-- <link rel="stylesheet" href="css/notesApp.css" type="text/css" />  
<script src="js/bookstore.js" type="text/javascript"></script> -->
<style>
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px; 
}
#section {
    width:350px;
    float:left;
    padding:10px; 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px; 
}
</style>
</head>


<body>
	<div id="header">
		<jsp:include page="header.jsp" flush="true" /><br />
	</div>

	<div id="nav">
		<jsp:include page="navigationMenu.jsp" flush="true" />
	</div>
	<div>
		<span class="label" style="margin-left: 15px;">List of Last Notes</span>
	</div>
	<div id="section">
		<jsp:include page="oldNotesList.jsp" flush="true" />
	</div>
		 
</body>
</html>

