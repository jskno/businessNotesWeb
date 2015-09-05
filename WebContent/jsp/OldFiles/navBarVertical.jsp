<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style>
        body {
            padding-top: 70px;
        }
    </style>
<title>Nav Bar</title>
</head>
<body>
<div class="container">
  <h3>Vertical Pills</h3>
  <div class="row">
  	<div class="col-md-3">
      <ul class="nav nav-pills nav-stacked">
      	<li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
   			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1
    		<span class="caret"></span></a>
    		<ul class="dropdown-menu">
      			<li><a href="#">Submenu 1-1</a></li>
      			<li><a href="#">Submenu 1-2</a></li>
      			<li><a href="#">Submenu 1-3</a></li> 
    		</ul>
  		</li>
        <li><a href="#">Menu 2</a></li>
        <li><a href="#">Menu 3</a></li>
      </ul>
    </div>
    <div class="col-md-3">
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div class="col-md-3"> 
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div class="col-md-3"> 
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div class="clearfix visible-lg"></div>
  </div>
</div>
</body>
</html>