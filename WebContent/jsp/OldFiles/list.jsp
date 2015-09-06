<%@page import="model.NoteVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.CompanyVO"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<table id="grid">
		<thead>
			<tr>
				<th id="th-companyList">Company Name</th>
				<th id="th-companyEmail">Company Email</th>
			</tr>
		</thead>
		<tbody>
		<%
	        List<CompanyVO> companyList = (List<CompanyVO>)request.getAttribute("companiesList");
    	    Iterator<CompanyVO> iterator = companyList.iterator();
	        while (iterator.hasNext()) {
    	    	CompanyVO company = (CompanyVO)iterator.next();
        		String companyName = company.getCompanyName();
          		String companyEmail = company.getCompanyEmail();
         %>
			<tr>
				<td scope="row" id="r100"><%=companyName%></td>
				<td scope="row" id="r100"><%=companyEmail%></td>
			</tr>
		 <%
         	 }
         %>
		</tbody>
	</table>
</body>
</html>