<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>New Product</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>New Product</h3>
  			<p>Form to introduce a new product.</p>
  		</div>
  		<form class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="nextStep" id="nextStep" value="addProduct"/>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="productCode">Product Code:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="productCode" id="productCode"
        				placeholder="Enter the product code">
      			</div>
    		</div>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="productDescription">Product Description:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="productDescription" id="productDescription" 
        				placeholder="Enter the product description">
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