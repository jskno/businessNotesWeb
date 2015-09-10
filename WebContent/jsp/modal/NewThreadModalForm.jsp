<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.BusinessNoteVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Thread Modal</title>
</head>
<body>
<!--  INI MODALS -->

<div id="NewThreadModalForm" class="modal fade" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="newThreadModalForm" class="form-horizontal" role="form" action="notes/addElement" method="POST">
		<input type="hidden" name="nextStep" id="nextStep" value="addThread"/>
		<input type="hidden" name="screenOrigin" value="notesListForm"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New Thread</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-4" for="threadTitle">Thread Title:</label>
	      			<div class="col-sm-8">
		        		<input type="text" class="form-control" name="threadTitle" id="threadTitle" 
		        				placeholder="Enter title">
	    			</div>
	    		</div>
	    		<div class="form-group">
	      			<div class="col-sm-8" id=noteIdsList>
	    			</div>
	    		</div>
    		</div>
	    	
 			<div class="modal-footer">
 				<button type="submit" class="btn btn-default">Submit</button>
 				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
 			</div>
 		</form>
	</div>
	</div>
</div>
<!-- FIN MODALS -->
</body>
</html>