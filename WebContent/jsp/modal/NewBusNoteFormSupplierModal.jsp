<%@page import="model.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
//    @SuppressWarnings("unchecked")
//    List<CompanyVO> companyList =
//            (List<CompanyVO>)request.getAttribute("noCustomerCompaniesList");
%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Supplier Modal</title>
</head>
<body>
<!--  INI MODALS -->

<div id="newSupplierModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="newSupplierModalForm" class="form-horizontal" role="form" action="notes/addElement" method="POST">
		<input type="hidden" name="nextStep" id="nextStep" value="addSupplier"/>
		<input type="hidden" name="screenOrigin" value="newNoteForm"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New Supplier</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="companyName">Company Name:</label>
	      			<div class="col-sm-10">
		        		<select class="form-control col-sm-8" name="supplierCompanyId" id="supplierCompanyId">
    						<option value=""></option>
    					</select>
	    			</div>
	    		</div>
	    		<div class="form-group">
      			<label class="control-label col-sm-2" for="contactName">Contact Name:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="contactName" id="contactName" 
        				placeholder="Enter the contact name">
      			</div>
    			</div>
    			<div class="form-group">
      			<label class="control-label col-sm-2" for="contactTelephone">Contact Telephone:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="contactTelephone" id="contactTelephone" 
        				placeholder="Enter the contact telephone">
      			</div>
    			</div>
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="deliveryDays">Delivery Days:</label>
	     			<div class="col-sm-10">          
		        		<input type="text" class="form-control" name="deliveryDays" id="deliveryDays" 
		        				placeholder="Enter the Delivery Days">
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

<script src="js/getNoRoleCompanies.js"></script>

<!--  				
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
-->

<!-- FIN MODALS -->
</body>
</html>