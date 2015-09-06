<%@page import="model.CompanyVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.CompanyVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Companies List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Companies List</h3>
  			<p>Table showing all the companies alphabetically ordered.</p>
  		</div>
  		<table class="table table-condensed">
    		<thead>
     			<tr>
     				<th>Tax ID</th>
					<th>Company Name</th>
        			<th>Company Telephone</th>
       				<th>Company Email</th>
       				<th></th>
       				<th></th>
     			</tr>
   			</thead>
    		<tbody>
    		<%
    			@SuppressWarnings("unchecked")
    			List<CompanyVO> companiesList = (List<CompanyVO>)request.getAttribute("companiesList");
    	    	Iterator<CompanyVO> iterator = companiesList.iterator();
	        	while (iterator.hasNext()) {
	        	CompanyVO company = (CompanyVO) iterator.next();
	        	String taxID = company.getTaxID();
        		String companyName = company.getCompanyName();
          		String companyTelephone = company.getCompanyTelephone();
          		String companyEmail = company.getCompanyEmail();
         	%>
				<tr>
					<td><%=taxID%></td>
					<td><%=companyName%></td>
					<td><%=companyTelephone%></td>
					<td><%=companyEmail%></td>
					<td><a href="#">View</a></td>
					<td><a href="#">Delete</a></td>
				</tr>
		 	<%
         		 }
        	%>
			</tbody>
		</table>
	</div>

</body>
</html>