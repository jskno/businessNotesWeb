<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Note Home</title>
<link rel="stylesheet" href="css/newNoteCssHome.css">
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" flush="true" />
	</div>
	<div id="leftMenu">
		<jsp:include page="navigationMenu.jsp" flush="true" />
	</div>
	<div id="rightFrame">
		<jsp:include page="newNote.jsp" flush="true" />
	</div>
</body>
</html>