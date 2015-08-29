/**
 * 
 */
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
		socket = new WebSocket('ws://' + window.location.host + 
				'<c:url value="/notes/ws/"> \
					<c:param name="action" value="${action}" ></c:url>');
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
	
	
})