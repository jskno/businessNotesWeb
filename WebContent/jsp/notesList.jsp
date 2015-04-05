<%@page import="model.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<table id="grid">
		<thead>
			<tr>
				<th id="th-noteTitle">Note Title</th>
				<th id="th-noteText">Note Text</th>
			</tr>
		</thead>
		<tbody>
		<%
	        List<Note> notesList = (List<Note>)request.getAttribute("notesList");
    	    Iterator<Note> iterator = notesList.iterator();
	        while (iterator.hasNext()) {
	        	Note note = (Note)iterator.next();
        		int noteTitle = note.getId();
          		String noteText = note.getNoteText();
         %>
			<tr>
				<td scope="row" id="r100"><%=noteTitle%></td>
				<td scope="row" id="r100"><%=noteText%></td>
			</tr>
		 <%
         	 }
         %>
		</tbody>
	</table>
</body>
</html>