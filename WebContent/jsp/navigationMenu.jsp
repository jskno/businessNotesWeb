<%
	String param1 = application.getInitParameter("param1");
%>
<!DOCTYPE html>
<html lang="en-US">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/notesWebCss.css">
	<!-- <script src="myscript.js" /> -->
</head>
<body>

<div id="nav">
	<ul id="menu">
		<li><a href="<%=param1%>">Home</a></li>
		<li><a href="<%=param1%>?action=lastNotes">Note</a></li>
		<li><a href="<%=param1%>?action=allCompanies">Customer</a></li>
		<li><a href="/jquery/">Supplier</a></li>
		<li><a href="/jquery/">Product</a></li>
		<li><a href="/jquery/">DataBase</a></li>
		<li><a href="/jquery/">Others</a></li>
	</ul>
</div>
</body>
</html>

