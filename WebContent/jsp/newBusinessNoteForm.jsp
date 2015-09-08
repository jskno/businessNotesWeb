<%@page import="model.ProductVO"%>
<%@page import="model.SupplierVO"%>
<%@page import="model.CustomerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    @SuppressWarnings("unchecked")
    List<CustomerVO> customersList =
            (List<CustomerVO>)request.getAttribute("customersList");
	@SuppressWarnings("unchecked")
	List<SupplierVO> suppliersList =
			(List<SupplierVO>) request.getAttribute("suppliersList");
	@SuppressWarnings("unchecked")
	List<ProductVO> productsList =
			(List<ProductVO>) request.getAttribute("productsList");
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
    			<jsp:include page="dynamicNavBar.jsp" flush="true" />
    		</div>
    	</div>
		<div class="well">
			<h3>New Note</h3>
  			<p>Form to introduce a new note.</p>
  		</div>
  		<form class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="nextStep" id="nextStep" value="addBusinessNote"/>
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
    					<option value=""></option>
    					<%
    					for(CustomerVO eachCustomer : customersList) {
    					%>
    					<option value="<%=eachCustomer.getRoleId()%>">
    					<%=eachCustomer.getCompanyName()%>
    					</option>
    					<%
    					}
    					%>
        			</select>
        		</div>
     			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						id="newCustomerButton" data-target="#newCustomerModal">New Customer</button>
      			</div>        			
      		</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="supplierId">Supplier:</label>
      			<div class="col-sm-8">
    				<select class="form-control col-sm-8" name="supplierId" id="supplierId">
    					<option value=""></option>
        				<%
    					for(SupplierVO eachSupplier : suppliersList) {
    					%>
    					<option value="<%=eachSupplier.getRoleId()%>">
    					<%=eachSupplier.getCompanyName()%>
    					</option>
    					<%
    					}
    					%>
      				</select>
      			</div>
     			<div class="col-sm-2">
      				<!-- Trigger the modal with a button -->
      				<button type="button" class="btn btn-info btn-md" data-toggle="modal" 
      						id="newSupplierButton" data-target="#newSupplierModal">New Supplier</button>
      			</div>      				
      		</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="productId">Product:</label>
      			<div class="col-sm-8">
    				<select class="form-control" name="productId" id="productId">
    					<option value=""></option>
        				<%
    					for(ProductVO eachProduct : productsList) {
    					%>
    					<option value="<%=eachProduct.getProductId()%>">
    					<%=eachProduct.getProductCode() + "   " + eachProduct.getProductDescription()%>
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
<jsp:include page="modal/NewBusNoteFormCustomerModal.jsp" flush="false" />
<jsp:include page="modal/NewBusNoteFormSupplierModal.jsp" flush="false" />
<jsp:include page="modal/NewBusNoteFormProductModal.jsp" flush="false" />
<script src="js/getNoRoleCompanies.js"></script>
<!--  FIN MODALS -->

</body>
</html>