<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.Supplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Suppliers List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Suppliers List</h3>
  			<p>Table showing all the suppliers alphabetically ordered.</p>
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
    			@SuppressWarnings("unchecked")
    			List<Supplier> suppliersList = (List<Supplier>)request.getAttribute("suppliersList");
    	    	Iterator<Supplier> iterator = suppliersList.iterator();
	        	while (iterator.hasNext()) {
    	    	Supplier supplier = (Supplier) iterator.next();
        		String companyName = supplier.getCompany().getCompanyName();
          		String contactName = supplier.getContactName();
          		String contactTelephone = supplier.getContactTelephone();
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