<%@page import="model.Product"%>
<%@page import="model.Supplier"%>
<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    @SuppressWarnings("unchecked")
    List<Customer> customersList =
            (List<Customer>)request.getAttribute("customersList");
	@SuppressWarnings("unchecked")
	List<Supplier> suppliersList =
			(List<Supplier>) request.getAttribute("suppliersList");
	@SuppressWarnings("unchecked")
	List<Product> productsList =
			(List<Product>) request.getAttribute("productsList");
%>
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
  		<form class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="action" value="addNote"/>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="noteTitle">Note title:</label>
      			<div class="col-sm-10">
        		<input type="text" class="form-control" name="noteTitle" id="noteTitle" 
        				placeholder="Enter title">
      			</div>
    		</div>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="noteText">Note Text:</label>
     			<div class="col-sm-10">          
        		<textarea class="form-control" rows="5" name="noteText" id="noteText"></textarea>
      			</div>
    		</div>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="customerId">Customer:</label>
      			<div class="col-sm-8">
    				<select class="form-control col-sm-8" name="customerId" id="customerId">
    					<%
    					for(Customer eachCustomer : customersList) {
    					%>
    					<option value="<%=eachCustomer.getId()%>">
    					<%=eachCustomer.getCompany().getCompanyName()%>
    					</option>
    					<%
    					}
    					%>
        			</select>
        		</div>
     			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						data-target="#newCustomerModal">New Customer</button>
      			</div>        			
      		</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="supplierId">Supplier:</label>
      			<div class="col-sm-8">
    				<select class="form-control col-sm-8" name="supplierId" id="supplierId">
        				<%
    					for(Supplier eachSupplier : suppliersList) {
    					%>
    					<option value="<%=eachSupplier.getId()%>">
    					<%=eachSupplier.getCompany().getCompanyName()%>
    					</option>
    					<%
    					}
    					%>
      				</select>
      			</div>
     			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						data-target="#newSupplierModal">New Supplier</button>
      			</div>      				
      		</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="productId">Product:</label>
      			<div class="col-sm-8">
    				<select class="form-control" name="productId" id="productId">
        				<%
    					for(Product eachProduct : productsList) {
    					%>
    					<option value="<%=eachProduct.getId()%>">
    					<%=eachProduct.getProductCode() + eachProduct.getProductDescription()%>
    					</option>
    					<%
    					}
    					%>
      				</select>
      			</div>
     			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						data-target="#newProductModal">New Product</button>
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

<!--  INI MODALS -->
<div id="newCustomerModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="newCustomerModalForm" class="form-horizontal" role="form" action="notes" method="POST">
		<input type="hidden" name="action" value="onlyCreateCustomer"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New Customer</h4>
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
				
<script>
$(document).ready(function() {
    $('#newCompanyModalForm').formValidation({
        framework: 'bootstrap',
        excluded: [':disabled'],
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	companyName: {
                validators: {
                    notEmpty: {
                        message: 'The company name is required'
                    }
                }
            },
            companyTelephone: {
                validators: {
                    notEmpty: {
                        message: 'The company telephone is required'
                    }
                }
            },
            companyEmail: {
                validators: {
                    notEmpty: {
                        message: 'The company email is required'
                    }
                }
            },
        }
    });
});
</script>

<div id="newSupplierModal" class="modal fade" role="dialog">
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
				
<script>
$(document).ready(function() {
    $('#newCompanyModalForm').formValidation({
        framework: 'bootstrap',
        excluded: [':disabled'],
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	companyName: {
                validators: {
                    notEmpty: {
                        message: 'The company name is required'
                    }
                }
            },
            companyTelephone: {
                validators: {
                    notEmpty: {
                        message: 'The company telephone is required'
                    }
                }
            },
            companyEmail: {
                validators: {
                    notEmpty: {
                        message: 'The company email is required'
                    }
                }
            },
        }
    });
});
</script>

<div id="newProductModal" class="modal fade" role="dialog">
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
				
<script>
$(document).ready(function() {
    $('#newCompanyModalForm').formValidation({
        framework: 'bootstrap',
        excluded: [':disabled'],
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	companyName: {
                validators: {
                    notEmpty: {
                        message: 'The company name is required'
                    }
                }
            },
            companyTelephone: {
                validators: {
                    notEmpty: {
                        message: 'The company telephone is required'
                    }
                }
            },
            companyEmail: {
                validators: {
                    notEmpty: {
                        message: 'The company email is required'
                    }
                }
            },
        }
    });
});
</script>

<!-- FIN MODALS -->

</body>
</html>