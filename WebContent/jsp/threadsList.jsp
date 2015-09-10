<%@page import="model.ThreadVO"%>
<%@page import="java.util.Date"%>
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
<title>Threads List</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>Threads List</h3>
  			<p>Table showing all threads chronologically ordered.</p>
  		</div>
  		<table id="list" class="table table-condensed">
    		<thead>
     			<tr>
     				<th style="display:none;">threadId</th>
					<th>Creation Date</th>
        			<th>Title</th>
       				<th>Number of Notes</th>
       				<th></th>
       				<th></th>
     			</tr>
   			</thead>
    		<tbody>
    		<%
	        	List<ThreadVO> threadsList = (List<ThreadVO>)request.getAttribute("threadsList");
    	    	Iterator<ThreadVO> iterator = threadsList.iterator();
	        	while (iterator.hasNext()) {
	        	ThreadVO thread = (ThreadVO) iterator.next();
	        	int threadId = thread.getThreadId();
        		Date creationDate = thread.getCreationDate();
        		String threadTitle = thread.getThreadTitle();
          		Integer notesNumber = thread.getNotesList().size();
         	%>
				<tr>
         			<td style="display:none;"><%=threadId%></td>
					<td><%=creationDate%></td>
					<td><%=threadTitle%></td>
					<td><%=notesNumber%></td>
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