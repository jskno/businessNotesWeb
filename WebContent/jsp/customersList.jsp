<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Customers List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Customers List</h3>
  			<p>Table showing all the customers alphabetically ordered.</p>
  		</div>
  		<table class="table table-condensed">
    		<thead>
     			<tr>
					<th>Company Name</th>
        			<th>Contact Name</th>
       				<th>Contact Telephone</th>
     			</tr>
   			</thead>
    		<tbody>
    		<%
	        	List<Customer> customersList = (List<Customer>)request.getAttribute("customersList");
    	    	Iterator<Customer> iterator = customersList.iterator();
	        	while (iterator.hasNext()) {
	        	Customer customer = (Customer) iterator.next();
        		String companyName = customer.getCompany().getCompanyName();
          		String contactName = customer.getContactName();
          		String contactTelephone = customer.getContactTelephone();
         	%>
				<tr>
					<td><%=companyName%></td>
					<td><%=contactName%></td>
					<td><%=contactTelephone%></td>
				</tr>
		 	<%
         		 }
        	%>
			</tbody>
		</table>
	</div>

</body>
</html>