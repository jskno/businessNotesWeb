<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>New Company</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>New Company</h3>
  			<p>Form to introduce a new company.</p>
  		</div>
  		<form class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="action" value="addCompany"/>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="taxID">Tax ID:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="taxID" id="taxID" 
        				placeholder="Enter the tax ID">
      			</div>
    		</div>
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
    		<div class="form-group">        
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Submit</button>
      			</div>
    		</div>
  		</form>
	</div>

</body>
</html>