<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>Login Form</title>
</head>
<body>
	<div class="container-fluid">
				
		<div class="well">
			<h3>Login Form</h3>
  			<p>Form to log in the application.</p>
  			<p> You must log in to access the Business Notes site.<br /><br /></p>
  			<%
  				if((Boolean) request.getAttribute("loginFailed")) {
  			%>
  				<b>The user name or password you entered are not correct.
  				Please try again.</b><br /><br />
  			<%
  				}
  			%>
  		</div>
  		
  		<form class="form-horizontal" role="form" action="login" method="POST">
  		<input type="hidden" name="nextStep" id="nextStep" value=""/>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="username">User Name:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="username" id="username"
        				placeholder="Enter the Username">
      			</div>
    		</div>
    		<div class="form-group">
      			<label class="control-label col-sm-2" for="password">Password:</label>
     			<div class="col-sm-10">          
        		<input type="text" class="form-control" name="password" id="password" 
        				placeholder="Enter the password">
      			</div>
    		</div>
    		<div class="form-group">        
      			<div class="col-sm-offset-2 col-sm-10">
        			<button type="submit" class="btn btn-default">Log in</button>
      			</div>
    		</div>
  		</form>
	</div>

</body>
</html>