/**
 * 
 */
var taxID;
var string = "come on";
var url;

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

$('#taxID').change(function() {
	taxID = $(this).val(); // get the current value of the input field.
	url = "notes/ajax?action=checkCompany&taxID=" + taxID;
	some_function2(url, some_function2);
});

function some_function2(url, callback) {
	var httpRequest; // create our XMLHttpRequest object
	if (window.XMLHttpRequest) {
	    httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
	    // Internet Explorer is stupid
	    httpRequest = new
	           ActiveXObject("Microsoft.XMLHTTP");
	}
	httpRequest.onreadystatechange = function() {
	   // inline function to check the status
	   // of our request
	   // this is called on every state change
	   if (httpRequest.readyState === 4 &&
			httpRequest.status === 200) {
	           callback.call(httpRequest.responseXML);
	          // call the callback function
	   }
	};
	httpRequest.open('GET', url);
	httpRequest.send();
}

// call the function
some_function2("text.xml", function() {
    console.log(this);
});

console.log("this will run before the above callback");


