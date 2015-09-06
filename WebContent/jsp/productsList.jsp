<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Products List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Products List</h3>
  			<p>Table showing all the products alphabetically ordered.</p>
  		</div>
  		<table class="table table-condensed">
    		<thead>
     			<tr>
					<th>Product Code</th>
        			<th>Product Description</th>
       				<th></th>
       				<th></th>
       			</tr>
   			</thead>
    		<tbody>
    		<%
    			@SuppressWarnings("unchecked")
    			List<ProductVO> productsList = (List<ProductVO>)request.getAttribute("productsList");
    	    	Iterator<ProductVO> iterator = productsList.iterator();
	        	while (iterator.hasNext()) {
	        	ProductVO product = (ProductVO) iterator.next();
        		String productCode = product.getProductCode();
          		String productDescription = product.getProductDescription();
         	%>
				<tr>
					<td><%=productCode%></td>
					<td><%=productDescription%></td>
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