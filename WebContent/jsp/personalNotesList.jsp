<%@page import="java.util.Date"%>
<%@page import="model.NoteVO"%>
<%@page import="model.BusinessNoteVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>BusinessNotes List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>BusinessNotes List</h3>
  			<p>Table showing all notes chronologically ordered.</p>
  		</div>
  		<table class="table table-condensed">
    		<thead>
     			<tr>
					<th>Creation Date</th>
        			<th>Title</th>
       				<th>Text</th>
       				<th>Customer</th>
        			<th>Supplier</th>
       				<th>Product</th>
       				<th></th>
       				<th></th>
     			</tr>
   			</thead>
    		<tbody>
    		<%
	        	List<BusinessNoteVO> notesList = (List<BusinessNoteVO>)request.getAttribute("notesList");
    	    	Iterator<BusinessNoteVO> iterator = notesList.iterator();
	        	while (iterator.hasNext()) {
	        	BusinessNoteVO note = (BusinessNoteVO) iterator.next();
        		Date creationDate = note.getCreationDate();
          		String noteTitle = note.getNoteTitle();
          		String noteText = note.getNoteText();
          		String noteCustomer = note.getCustomer().getCompanyName();
          		String noteSupplier = note.getSupplier().getCompanyName();
          		String noteProduct = note.getProduct().getProductCode();
         	%>
				<tr>
					<td><%=creationDate%></td>
					<td><%=noteTitle%></td>
					<td><%=noteText%></td>
					<td><%=noteCustomer%></td>
					<td><%=noteSupplier%></td>
					<td><%=noteProduct%></td>
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