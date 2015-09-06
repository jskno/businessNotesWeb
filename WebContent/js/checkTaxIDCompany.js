/**
 * 
 */
var taxID;
var xmlhttp;
var responseXML;

var companyAdded;
var supplierAdded;

var companyId;
var companyName;
var companyTelephone;
var companyEmail;

var addCompanyUrl = "notes/addElement";
var closeCompanyUrl = "notes";
var addCompanyNextStep = "addCompany";
var closeCompanyNextStep = "newCompany";


$('#taxID').change(function() {
	clearForm();
	taxID = $(this).val(); // get the current value of the input field.
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
	var url = "notes/ajax?action=checkCompany&taxID=" + taxID;
	xmlhttp.open("GET",url,true);
	xmlhttp.onreadystatechange = callback;
	xmlhttp.send();		
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
    	
        companyAdded = responseXML.getElementsByTagName("companyAdded")[0].childNodes[0].nodeValue;

        if (companyAdded == 1) {
        	populateCompanyForm();
        	disableCompanyForm(true);
        	setSubmitForm("Close", closeCompanyUrl, closeCompanyNextStep);
        	alert("The company already exists.");
        } else {
        	
        }
    }
}

function populateCompanyForm() {
	companyId = responseXML.getElementsByTagName("companyId")[0].childNodes[0].nodeValue;
	companyName = responseXML.getElementsByTagName("companyName")[0].childNodes[0].nodeValue;
	companyTelephone = responseXML.getElementsByTagName("companyTelephone")[0].childNodes[0].nodeValue;
	companyEmail = responseXML.getElementsByTagName("companyEmail")[0].childNodes[0].nodeValue;
	document.getElementById("companyId").value = companyId;
	document.getElementById("companyName").value = companyName;
	document.getElementById("companyTelephone").value = companyTelephone;
	document.getElementById("companyEmail").value = companyEmail;
}

function disableCompanyForm(value) {
	document.getElementById('companyName').disabled = value;
	document.getElementById('companyTelephone').disabled = value;
	document.getElementById('companyEmail').disabled = value;
}

function setSubmitForm(textButton, url, step) {
	// Modify the button label
	var submitButton = document.getElementById("submitButton");
	submitButton.innerHTML = textButton;
	
	// Modify the url that calls the appropiate Servlet
	$("#newCompany").attr("action", url);
	
	// Modify the nextStep parameter that indicates which way to follow in the Servlet.
	document.getElementById("nextStep").value = step;
}

function clearForm() {
	disableCompanyForm(false);
	clearFields();
	setSubmitForm("Submit", addCompanyUrl, addCompanyNextStep);
}

function clearFields() {
	document.getElementById("companyId").value = "";
	document.getElementById("companyName").value = "";
	document.getElementById("companyTelephone").value = "";
	document.getElementById("companyEmail").value = "";
}
