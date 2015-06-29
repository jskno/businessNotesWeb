<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%
	String param1 = application.getInitParameter("param1");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/notesApp.css" type="text/css" />
<script src="js/notesApp.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>
<body>
<div class="leftbar">
	<ul id="menu">
		<li><div>
			<a class="link1" href="<%=param1%>">
			<span class="label"	style="margin-left: 15px;">Home</span>
			</a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=note">
			<span style="margin-left: 15px;" class="label">Note</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=customer">
			<span style="margin-left: 15px;" class="label">Customer</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=supplier">
			<span style="margin-left: 15px;" class="label">Supplier</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=product">
			<span style="margin-left: 15px;" class="label">Product</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=database">
			<span style="margin-left: 15px;" class="label">DataBase</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=allCompanies">
			<span style="margin-left: 15px;" class="label">All Companies</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="<%=param1%>?action=lastNotes">
			<span style="margin-left: 15px;" class="label">Last Notes</span></a>
		</div></li>
		<li><div>
			<span class="label" style="margin-left: 15px;">Contact Us</span>
		</div></li>
	</ul>
	<form class="search">
		<input type="hidden" name="action" value="searchCompanies" />
		<input id="text" type="text" name="keyWord" size="12" />
		<span class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form>
</div>
</body>
</html>