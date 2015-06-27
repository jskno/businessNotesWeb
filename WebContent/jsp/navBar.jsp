<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        body {
            padding-top: 70px;
        }
    </style>
<title>Navbar Sample</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="jsp/newNoteForm.jsp" class="navbar-brand">Home Page</a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hamburger-navigation">
                    <!-- placeholder -->
                    <span class="sr-only">Navigation toggle</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="hamburger-navigation">
                <ul class="nav navbar-nav" role="menu">
                    <!-- existing links -->
                    <li><a href="#" class="active">Current Page</a><span class="sr-only">current</span></li>
                    <li><a href="#">Note</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Customer<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Supplier<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Product<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Database<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown">Tools<span class="caret" /></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Option one</a></li>
                            <li><a href="#">Option two</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>
   
</body>
</html>