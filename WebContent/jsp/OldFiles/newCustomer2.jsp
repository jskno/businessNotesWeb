<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- <script src="js/webSocketScriptModified.js"></script>  -->
<title>New Customer2</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
    		<div class="col-sm-12">
    			<jsp:include page="navBar.jsp" flush="true" />
    		</div>
    	</div>
		
		<div class="well">
			<h3>New Customer3</h3>
  			<p>Form to introduce a new customer2.</p>
  		</div>
  		
  		<div id="status">Connecting...</div>
  		<ul id="messages"></ul>
  		<form id="message-form" action="#" method="post">
    		<textarea id="message" placeholder="Write your message here..." required></textarea>
    		<button type="submit">Send Message</button>
    		<button type="button" id="close">Close Connection</button>
  		</form>
  
  		<form id="newCustomer2" class="form-horizontal" role="form" action="notes/addElement" method="POST">
  		<input type="hidden" name="action" value="addCustomer2"/>
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
        				placeholder="Enter the company name">
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

<script>
$(document).ready(function() {
    $('#newCustomer2').formValidation({
        framework: 'bootstrap',
        excluded: [':disabled'],
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	taxID: {
                validators: {
                    notEmpty: {
                        message: 'The tax ID is required'
                    }
                }
            },
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
<script>
$(document).ready(function() {
	
	// Get references to elements on the page.
	var form = document.getElementById('message-form');
	var messageField = document.getElementById('message');
	vat taxIDfield = document.getElementById('taxID');
	var messagesList = document.getElementById('messages');
	var socketStatus = document.getElementById('status');
	var closeBtn = document.getElementById('close');
	  
	var socket;
	try {
		socket = new WebSocket(
			'ws://localhost:8080/BusinessNotesWeb/notes/ws'); //?action=checkTaxID
	} catch(error) {
		return;
	}
	
	// Handle any errors that occur.
	socket.onerror = function(error) {
	  console.log('WebSocket Error: ' + error);
	};
	
	// Show a connected message when the WebSocket is opened.
	socket.onopen = function(event) {
	  socketStatus.innerHTML = 'Connected to: ' + event.currentTarget.URL;
	  socketStatus.className = 'open';
	};
	
	// Handle messages sent by the server.
	socket.onmessage = function(event) {
	  var message = event.data;
	  messagesList.innerHTML += '<li class="received"><span>Received:</span>' +
	                             message + '</li>';
	};
	
	// Show a disconnected message when the WebSocket is closed.
	socket.onclose = function(event) {
	  socketStatus.innerHTML = 'Disconnected from WebSocket.';
	  socketStatus.className = 'closed';
	};
	
	// Send a message when the form is submitted.
	$('#taxID').onchange = function(e) {
	  e.preventDefault();

	  // Retrieve the message from the textarea.
	  var message = messageField.value;
	  var taxID = taxIDfield.value;

	  // Send the message through the WebSocket.
	  socket.send(taxID);

	  // Add the message to the messages list.
	  messagesList.innerHTML += '<li class="sent"><span>Sent:</span>' + taxID +
	                            '</li>';

	  // Clear out the message field.
	  messageField.value = '';

	  return false;
	};
	
	
})</script>
</html>