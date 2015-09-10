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
  		<table id="list" class="table table-condensed">
    		<thead>
     			<tr>
     				<th>Add Thread</th>
     				<th style="display:none;">noteId</th>
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
	        	int noteId = note.getNoteId();
        		Date creationDate = note.getCreationDate();
        		String noteTitle = note.getNoteTitle();
          		String noteText = note.getNoteText();
          		String noteCustomer = null;
          		if(null != note.getCustomer()) {
	          		noteCustomer = note.getCustomer().getCompanyName();
           		} else {
           			noteCustomer = "";
           		}
          		String noteSupplier = null;
          		if(null != note.getSupplier()) {
          			noteSupplier = note.getSupplier().getCompanyName();
           		} else {
           			noteSupplier = "";
           		}
          		String noteProduct = null;
          		if(null != note.getProduct()) {
	          		noteProduct = note.getProduct().getProductCode();
           		} else {
           			noteProduct = "";
           		}
         	%>
				<tr>
         			<td><input id="addThread" type="checkbox"></td>
         			<td style="display:none;"><%=noteId%></td>
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
		<div class="col-sm-2">
      		<!-- Trigger the thread creation -->
   			<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      			id="newThreadButton" data-target="#NewThreadModalForm">Add Thread</button>
      	</div>
	</div>

<!--  INI MODALS -->
<jsp:include page="modal/NewThreadModalForm.jsp" flush="true" />
<script src="js/getNoteIdsList.js"></script>
<!--  FIN MODALS -->

</body>
</html>