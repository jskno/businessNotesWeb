<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.CustomerVO"%>
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
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Customers List</h3>
  			<p>Table showing all the customers alphabetically ordered.</p>
  		</div>
  		<table class="table table-condensed">
    		<thead>
     			<tr>
     				<th>Tax ID</th>
					<th>Company Name</th>
        			<th>Contact Name</th>
       				<th>Contact Telephone</th>
       				<th>Credit Rating</th>
       				<th>Customer Discount days</th>
       				<th></th>
       				<th></th>
     			</tr>
   			</thead>
    		<tbody>
    		<%
    			@SuppressWarnings("unchecked")
	        	List<CustomerVO> customersList = (List<CustomerVO>)request.getAttribute("customersList");
    	    	Iterator<CustomerVO> iterator = customersList.iterator();
	        	while (iterator.hasNext()) {
	        	CustomerVO customer = (CustomerVO) iterator.next();
	        	String taxID = customer.getCompanyTaxID();
        		String companyName = customer.getCompanyName();
          		String contactName = customer.getContactName();
          		String contactTelephone = customer.getContactTelephone();
          		Integer creditRating = customer.getCreditRating();
          		Double customerDiscount = customer.getCustomerDiscount();
         	%>
				<tr>
					<td><%=taxID%></td>
					<td><%=companyName%></td>
					<td><%=contactName%></td>
					<td><%=contactTelephone%></td>
					<td><%=creditRating%></td>
					<td><%=customerDiscount%></td>
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