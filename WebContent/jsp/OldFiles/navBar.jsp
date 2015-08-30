<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jsp/exportTable.jsp"></script>
    <style>
        body {
            padding-top: 70px;
        }
    </style>
<title>Navbar Sample</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="jsp/newNoteForm.jsp" class="navbar-brand">Home Page</a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hamburger-navigation">
                    <!-- placeholder -->
                    <span class="sr-only">Navigation toggle</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="hamburger-navigation">
                <ul class="nav navbar-nav" role="menu">
                    <!-- existing links -->
                    <li><a href="#" class="active">Current Page</a><span class="sr-only">current</span></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Note<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="/BusinessNotesWeb/notes?action=newNote">New Note</a></li>
                            <li><a href="/BusinessNotesWeb/notes?action=notesList">Notes List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Customer<span class="caret" /></a>
                        <ul class="dropdown-menu">
                        	<li><a href="/BusinessNotesWeb/notes?action=newCustomer" >New Customer</a></li>
                            <li><a href="/BusinessNotesWeb/notes?action=customersList" >Customers List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Supplier<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="/BusinessNotesWeb/notes?action=newSupplier">New Supplier</a></li>
                            <li><a href="/BusinessNotesWeb/notes?action=suppliersList">Suppliers List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Product<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="/BusinessNotesWeb/notes?action=newProduct">New Product</a></li>
                            <li><a href="/BusinessNotesWeb/notes?action=productsList">Products List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Company<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="/BusinessNotesWeb/notes?action=newCompany">New Company</a></li>
                            <li><a href="/BusinessNotesWeb/notes?action=companiesList">Companies List</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Database<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#" data-toggle="modal" data-target="#importTableModal">Import Table</a></li>
                            <li><a href="#" data-toggle="modal" data-target="#exportTableModal">Export Table</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Tools<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>
   </nav>
</body>

<!-- INI MODALS -->
<div id="exportTableModal" class="modal fade in" role="dialog">
	<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<form id="exportTable" class="form-horizontal" role="form" action="notes" method="POST">
		<input type="hidden" name="action" value="exportTable"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Export Table</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-4" for="tableName">Table Name:</label>
	      			<div class="col-sm-8">
		        		<select class="form-control" data-header="Select a Table" name="tableName" 
    						id="tableName">
    						<option value="company">Companies Table</option>
    						<option value="customer">Customers Table</option>
    						<option value="note">Notes Table</option>
    						<option value="product">Products Table</option>
    						<option value="supplier">Suppliers Table</option>
    					</select>
    				</div>
    				<div class="col-sm-10 col-sm-offset-2">
	    				<h5> The file will be saved in your desktop directory </h5>
	    			</div>
	    		</div>
	    		<div class="form-group">
      				<label class="control-label col-sm-4" for="fileName">File Name:</label>
      				<div class="col-sm-8">
        				<input type="text" class="form-control" name="fileName" id="fileName" 
        					placeholder="Enter name">
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

<div id="importTableModal" class="modal fade in" role="dialog">
	<div class="modal-dialog">
	
<div class="modal-content">
		<form id="importTable" class="form-horizontal" role="form" action="notes" method="POST">
		<input type="hidden" name="action" value="importTable"/>
	
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Import Table</h4>
			</div>
	
			<div class="modal-body">
	    		<div class="form-group">
	      			<label class="control-label col-sm-2" for="tableName">Table Name:</label>
	      			<div class="col-sm-10">
		        		<select class="form-control" data-header="Select a Table" name="tableName" 
    						id="tableName">
    						<option value="company">Companies Table</option>
    						<option value="customer">Customers Table</option>
    						<option value="note">Notes Table</option>
    						<option value="product">Products Table</option>
    						<option value="supplier">Suppliers Table</option>
    					</select>
    				</div>
	    		</div>
	    		<div class="col-sm-10 col-sm-offset-2">
	    			<h3> Select a file from your desktop </h3>
	    		</div>
	    		<div class="form-group">
	    			<div class="col-sm-10 col-sm-offset-2">
		    			<input type="file" name="myFile" id="myFile">
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
<!-- END MODALS -->

</html>