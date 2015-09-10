/**
 * 
 */

var addThread;
var addThreadValue;
var note;
var noteId;
var companyTelephone;
var companyEmail;

$('#newThreadButton').click(function() {
    origin = "Supplier";
    addIdsList();
    
});

function addIdsList() {
	
	var table = document.getElementById("list");
	for(var i=0; i<table.rows.length - 1;i++){
		//addThread = table.rows[i+1].cells[0].innerHTML.getElementsByTagName('input')[0].checked;
		addThreadValue = table.rows[i+1].cells[0].getElementsByTagName('input')[0].checked;
//		addThreadValue = table.rows[i+1].cells[0].getElementById("addThread").checked;
		if(addThreadValue) {
			noteId = table.rows[i+1].cells[1].innerHTML;
			createAndFillIds(noteId, i);
		}
	}
}


function getData(row) {
//	addThread = row.getElementsById("addThread");
    //companyName = company.getElementsByTagName("companyName")[0];
//	addThreadValue = row.getElementsById("noteId");
    //companyNameValue = companyName.childNodes[0].nodeValue;
	addThread = row.cells[0];
	noteId = row.cells[1];
}

function createAndFillIds(noteId, i) {
	// get reference to select element
	var listNode;
	listNode = document.getElementById('noteIdsList');
	// create new option element
	var input = document.createElement('input'); 
	input.setAttribute("type", "hidden");
	input.setAttribute("class", "form-control");
	input.setAttribute("name", "IdsList");
	input.setAttribute("id", "noteId" + i);
	input.setAttribute("value", noteId);
	// create text node to add to option element (opt)
	//input.appendChild( document.createAttribute("type") );
	
	// set value property of opt
	//opt.value = companyIdValue; 
	// add opt to end of select box (sel)
	listNode.appendChild(input); 
}

function process(responseXML) {
	if (responseXML == null) {
		alert("There is no answer from the Server.");
		return false;
	} else {
		companies = responseXML.getElementsByTagName("company");
		if (companies.length > 0) {
			for (loop = 0; loop < company.length; loop++) {
				getData(companies[loop]);
				createAndFillInOption(origin);
			}
		}
	}
}