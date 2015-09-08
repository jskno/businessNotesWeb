<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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