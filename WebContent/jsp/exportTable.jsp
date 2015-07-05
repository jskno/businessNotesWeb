<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<title>Export Table</title>
</head>
<body>

<div id="exportTableModal" class="modal fade hide" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="newCompanyModalForm" class="form-horizontal" role="form" action="notes" method="POST">
		<input type="hidden" name="action" value="onlyCreateCompany2"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New Company</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="companyName">Company Name:</label>
	      			<div class="col-sm-10">
		        		<input type="text" class="form-control" name="companyName" id="companyName" 
		        				placeholder="Enter name">
	    			</div>
	    		</div>
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="companyTelephone">Telephone Number:</label>
	     			<div class="col-sm-10">          
		        		<input type="text" class="form-control" name="companyTelephone" id="companyTelephone" 
		        				placeholder="Enter telephone">
	      			</div>
	    		</div>
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="companyEmail">Email:</label>
	     			<div class="col-sm-10">          
		        		<input type="text" class="form-control" name="companyEmail" id="companyEmail" 
		        				placeholder="Enter email">
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

</body>
</html>