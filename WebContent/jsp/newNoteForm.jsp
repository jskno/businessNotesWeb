<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>New Note</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    			<%@ include file="navBar.jsp" %>
    		</div>
    	</div>
		<div class="well">
			<h3>New Note</h3>
  			<p>Form to introduce a new note.</p>
  		</div>
  		<form class="form-horizontal" role="form" action="" method="POST">
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="noteTitle">Note title:</label>
      			<div class="col-sm-10">
        		<input type="text" class="form-control" id="noteTitle" placeholder="Enter title">
      			</div>
    		</div>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="noteText">Note Text:</label>
     			<div class="col-sm-10">          
        		<textarea class="form-control" rows="5" id="noteText"></textarea>
      			</div>
    		</div>
    		<div class="form-group">
      			<label for="customer" class="control-label col-sm-2">Customer:</label>
      			<div class="col-sm-8">
    				<select class="form-control col-sm-8" id="customer">
        				<option>1</option>
        				<option>2</option>
        				<option>3</option>
        				<option>4</option>
      				</select>
      			</div>
      			<div class="col-sm-2">
      				<a href="newCustomer.jsp" class="btn btn-info" role="button">New Customer</a>
      			</div>
      		</div>
      		<div class="form-group">
      			<label for="supplier" class="control-label col-sm-2">Supplier:</label>
      			<div class="col-sm-8">
    				<select class="form-control col-sm-8" id="supplier">
        				<option>1</option>
        				<option>2</option>
        				<option>3</option>
        				<option>4</option>
      				</select>
      			</div>
      			<div class="col-sm-2">
      				<a href="newSupplier.jsp" class="btn btn-info" role="button">New Supplier</a>
      			</div>
      		</div>
      		<div class="form-group">
      			<label for="product" class="control-label col-sm-2">Product:</label>
      			<div class="col-sm-8">
    				<select class="form-control" id="product">
        				<option>1</option>
        				<option>2</option>
        				<option>3</option>
        				<option>4</option>
      				</select>
      			</div>
      			<div class="col-sm-2">
      				<a href="newProduct.jsp" class="btn btn-info" role="button">New Product</a>
      			</div>
      		</div>
    		<div class="form-group">        
				<div class="col-sm-offset-2 col-sm-10">
       			<div class="checkbox">
          			<label><input type="checkbox"> Remember me</label>
	        	</div>
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