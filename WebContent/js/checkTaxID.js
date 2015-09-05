/**
 * 
 */
var taxID;
var xmlhttp;
var responseXML;
var string = "come on";

var companyAdded;
var customerAdded;

var companyId;
var companyName;
var companyTelephone;
var companyEmail;

var roleId;
var contactName;
var contactTelephone;
var creditRating;
var customerDiscount;
var customerAdded;
var customerAdded2;

var addCustomerUrl = "notes/addElement";
var closeCustomerUrl = "notes";
var addCustomerNextStep = "addCustomer2";
var closeCustomerNextStep = "newCustomer2";


$('#taxID').change(function() {
	clearForm();
	taxID = $(this).val(); // get the current value of the input field.
    xmlhttp = initRequest();
    //xmlhttp.onreadystatechange= 
    sendMessageToServer();
    
});

function reqListener () {
	  console.log(this.responseText);
}

function transferComplete(evt) {
//  alert("The transfer is complete.");
}

function transferFailed(evt) {
  alert("An error occurred while transferring the file.");
}

function transferCanceled(evt) {
  alert("The transfer has been canceled by the user.");
}

function updateProgress(evt) {
}

function initRequest() {
	
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.addEventListener("load", reqListener);
	xmlhttp.addEventListener("progress", updateProgress, false);
	xmlhttp.addEventListener("load", transferComplete, false);
	xmlhttp.addEventListener("error", transferFailed, false);
	xmlhttp.addEventListener("abort", transferCanceled, false);
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
   	} else if(xmlhttp.readyState==3) {
   		customerAdded2 = "LOADING !!!!";
   	} else if(xmlhttp.readyState==2) {
   		customerAdded2 = "HEADERS_RECEIVED !!!!";
   	} else if(xmlhttp.readyState==1) {
   		customerAdded2 = "OPENED !!!!";
   	} else if(xmlhttp.readyState==0) {
   		customerAdded2 = "UNSENT !!!!";
   	}
	fillInFields();
   	
}

function process(responseXML) {
	if (responseXML == null) {
		alert("There is no answer from the Server.");
        return false;
    } else {
    	
        customerAdded = responseXML.getElementsByTagName("customerAdded")[0].childNodes[0].nodeValue;
        companyAdded = responseXML.getElementsByTagName("companyAdded")[0].childNodes[0].nodeValue;

        if (companyAdded == 1) {
        	populateCompanyForm();
        	disableCompanyForm(true);

        	if (customerAdded == 1) {
        		populateCustomerForm();
            	disableCustomerForm(true);
            	setSubmitForm("Close", closeCustomerUrl, closeCustomerNextStep);
            	alert("The customer already exists.");
        	}
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

function populateCustomerForm() {
	contactName = responseXML.getElementsByTagName("contactName")[0].childNodes[0].nodeValue;
	contactTelephone = responseXML.getElementsByTagName("contactTelephone")[0].childNodes[0].nodeValue;
	creditRating = responseXML.getElementsByTagName("creditRating")[0].childNodes[0].nodeValue;
	customerDiscount = responseXML.getElementsByTagName("customerDiscount")[0].childNodes[0].nodeValue;
	document.getElementById("contactName").value = contactName;
	document.getElementById("contactTelephone").value = contactTelephone;
	document.getElementById("creditRating").value = creditRating;
	document.getElementById("customerDiscount").value = customerDiscount;        		
	
}

function disableCompanyForm(value) {
	document.getElementById('companyName').disabled = value;
	document.getElementById('companyTelephone').disabled = value;
	document.getElementById('companyEmail').disabled = value;
}

function disableCustomerForm(value) {
	document.getElementById('contactName').disabled = value;
	document.getElementById('contactTelephone').disabled = value;
	document.getElementById('creditRating').disabled = value;
	document.getElementById('customerDiscount').disabled = value;
}

function setSubmitForm(textButton, url, step) {
	// Modify the button label
	var submitButton = document.getElementById("submitButton");
	submitButton.innerHTML = textButton;
	
	// Modify the url that calls the appropiate Servlet
//	var actionForm = document.getElementById("newCustomer2").action; // Using the id
//	actionForm = url;
	$("#newCustomer2").attr("action", url);
	
	// Modify the nextStep parameter that indicates which way to follow in the Servlet.
//	var nextStepValue = document.newCustomer2.nextStep // Using the name
//	nextStepValue = step;
//	$("#form_id").attr("nextStep"); //will retrieve it // Using jquery
//	$("#newCustomer2").attr("nextStep", nextStep); //will set it
//	var nextStepValue = document.getElementById("newCustomer2").nextStep; // Using the id
//	nextStepValue = step;
//	$('#nextStep').val(step);
	document.getElementById("nextStep").value = step;
}

function clearForm() {
	disableCompanyForm(false);
	disableCustomerForm(false);
	clearFields();
	setSubmitForm("Submit", addCustomerUrl, addCustomerNextStep);
	
function clearFields() {
	document.getElementById("companyId").value = "";
	document.getElementById("companyName").value = "";
	document.getElementById("companyTelephone").value = "";
	document.getElementById("companyEmail").value = "";
	document.getElementById("contactName").value = "";
	document.getElementById("contactTelephone").value = "";
	document.getElementById("creditRating").value = "";
	document.getElementById("customerDiscount").value = "";
}

}
function fillInFields() {
//	document.getElementById("companyNameLabel").innerHTML = customerAdded2;	
}
