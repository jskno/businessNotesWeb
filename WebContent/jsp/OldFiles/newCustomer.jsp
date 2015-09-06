<%@page import="model.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    @SuppressWarnings("unchecked")
    List<CompanyVO> companiesList =
            (List<CompanyVO>)request.getAttribute("companiesList");
%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>New Customer</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>New Customer</h3>
  			<p>Form to introduce a new customer.</p>
  		</div>
  		<form class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="action" value="addCustomer"/>
  		   		<div class="form-group">
      			<label class="control-label col-sm-2" for="CompanyVOId">CompanyVO Name:</label>
      			<div class="col-sm-8">
    				<select class="form-control" data-header="Select a CompanyVO" name="CompanyVOId" 
    						id="CompanyVOId">
    				<% 
    					for(CompanyVO eachCompanyVO : companiesList) {
    				%>
    						<option value="<%= eachCompanyVO.getCompanyId() %>">
    							<%= eachCompanyVO.getCompanyName()%>
    						</option>
    						
    				<%	
						}
    				%>
        			</select>
      			</div>
      			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						data-target="#newCompanyVOModal">New CompanyVO</button>
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
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Submit</button>
      			</div>
    		</div>
  		</form>
	</div>

</body>

<!-- Modal -->
<div id="newCompanyVOModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="newCompanyVOModalForm" class="form-horizontal" role="form" action="notes/addElement" method="POST">
		<input type="hidden" name="action" value="addCompanyVO"/>
		<input type="hidden" name="originScreen" value="newCustomerForm"/>	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New CompanyVO</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="CompanyVOName">CompanyVO Name:</label>
	      			<div class="col-sm-10">
		        		<input type="text" class="form-control" name="CompanyVOName" id="CompanyVOName" 
		        				placeholder="Enter name">
	    			</div>
	    		</div>
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="CompanyVOTelephone">Telephone Number:</label>
	     			<div class="col-sm-10">          
		        		<input type="text" class="form-control" name="CompanyVOTelephone" id="CompanyVOTelephone" 
		        				placeholder="Enter telephone">
	      			</div>
	    		</div>
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="CompanyVOEmail">Email:</label>
	     			<div class="col-sm-10">          
		        		<input type="text" class="form-control" name="CompanyVOEmail" id="CompanyVOEmail" 
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
    $('#newCompanyVOModalForm').formValidation({
        framework: 'bootstrap',
        excluded: [':disabled'],
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	CompanyVOName: {
                validators: {
                    notEmpty: {
                        message: 'The Company name is required'
                    }
                }
            },
            CompanyVOTelephone: {
                validators: {
                    notEmpty: {
                        message: 'The Company telephone is required'
                    }
                }
            },
            CompanyVOEmail: {
                validators: {
                    notEmpty: {
                        message: 'The Company email is required'
                    }
                }
            },
        }
    });
});
</script>

</html>