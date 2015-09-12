/**
 * 
 */

var checked;
var addThreadValue;
var note;
var noteId;
var companyTelephone;
var companyEmail;

$('#newThreadButton').click(function() {
    addIdsList();
    
});

function addIdsList() {
	
	var table = document.getElementById("list");
	// iterates though each rows and gets the check value
	for(var i=0; i<table.rows.length - 1;i++){
		checked = table.rows[i+1].cells[0].getElementsByTagName('input')[0].checked;
		if(checked) {
			noteId = table.rows[i+1].cells[1].innerHTML;
			createAndFillIds(noteId, i);
		}
	}
}

function createAndFillIds(noteId, i) {
	// gets the node reference where the notes list will be created
	var listNode;
	listNode = document.getElementById('noteIdsList');
	// creates new input element with the appropriate attributes
	var input = document.createElement('input'); 
	input.setAttribute("type", "hidden");
	input.setAttribute("class", "form-control");
	input.setAttribute("name", "IdsList");
	input.setAttribute("id", "noteId" + i);
	input.setAttribute("value", noteId);
	// add the input node to the list node
	listNode.appendChild(input); 
}
