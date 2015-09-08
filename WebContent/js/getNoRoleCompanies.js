/**
 * 
 */
var xmlhttp;
var responseXML;
var origin;
var x;

var company
var companyAdded;
var companyId;
var companyName;
var companyTelephone;
var companyEmail;

$('#newSupplierButton').click(function() {
    origin = "Supplier";
    xmlhttp = initRequest();
    sendMessageToServer();
    
});

$('#newCustomerButton').click(function() {
    origin = "Customer";
    xmlhttp = initRequest();
    sendMessageToServer();
    
});

function initRequest() {
	
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

function sendMessageToServer() {
	var url = "notes/ajax?action=getNoRoleCompanies&origin=" + origin;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();	
	xmlhttp.onreadystatechange = callback;
	
}

function callback() {
	if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		responseXML = xmlhttp.responseXML
		process(responseXML);
   	}
}

function process(responseXML) {
	if (responseXML == null) {
		alert("There is no answer from the Server.");
        return false;
    } else {
        company = responseXML.getElementsByTagName("company");
        if (company.length > 0) {
        	for (loop = 0; loop < company.length; loop++) {
                getData(company[loop]);
                createAndFillInOption(origin);
            }
        }
    }
}

function getData(company) {
	companyId = company.getElementsByTagName("companyId")[0];
    companyName = company.getElementsByTagName("companyName")[0];
    companyIdValue = companyId.childNodes[0].nodeValue;;
    companyNameValue = companyName.childNodes[0].nodeValue;
}

function createAndFillInOption(origin) {
	// get reference to select element
	var sel;
	if(origin == "Customer") {
		sel = document.getElementById('customerCompanyId');
	} else if(origin == "Supplier") {
		sel = document.getElementById('supplierCompanyId');
	}
	// create new option element
	var opt = document.createElement('option'); 
	// create text node to add to option element (opt)
	opt.appendChild( document.createTextNode(companyNameValue) );
	// set value property of opt
	opt.value = companyIdValue; 
	// add opt to end of select box (sel)
	sel.appendChild(opt); 
}