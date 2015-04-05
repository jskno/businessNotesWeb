<!DOCTYPE html>
<html lang="en-US">
<head>
	<title>New Note</title>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="css/newNoteCss.css">
</head>

<body>
<form action="action_page.php">
<div id=text>
Note Title:<br />
<input type="text" name="titlenote" size="40" required/><br />

Note Text:<br />
<textarea name="notetext" rows="10" cols="60" placeholder="Write here your note" required>
</textarea><br /><br />
</div>
<div id=subopt>
Customer
<input list="customers" name="customer" size="40" />
<datalist id="customers">
  <option value="Internet Explorer" />
  <option value="Firefox" />
  <option value="Chrome" />
  <option value="Opera" />
  <option value="Safari" />
</datalist>
<button type="button" onclick="alert('Hello World!')">Add Customer</button>
<br />
Suppliers
<input list="suppliers" name="supplier" size="40" />
<datalist id="suppliers">
  <option value="volvo" />
  <option value="saab" />
  <option value="fiat" />
  <option value="audi" />
</datalist>
<button type="button" onclick="alert('Hello World!')">Add Supplier</button>
<br />
Product
<input list="products" name="product" size="40" />
<datalist id="products">
  <option value="volvo"/>
  <option value="saab"/>
  <option value="fiat"/>
  <option value="audi"/>
</datalist>
<button type="button" onclick="alert('Hello World!')">Add Product</button>
<br /><br />
<input type="radio" name="status" value="pending" checked="checked"/>Pending
<br />
<input type="radio" name="status" value="notpending"/>Not Pending
<br /><br />
</div>
<div id="submit">
<input type="submit" value="Submit"/>
</div>
</form>
</body>

</html>