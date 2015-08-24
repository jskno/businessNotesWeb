<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Form</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

    <div class="modal fade" id="myLoginModal" tabindex="-1" role="dialog" aria-labelledby="myModal-label" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModal-label">Login</h4>
                </div>

                <div class="modal-body">
                    <form role="form" class="form-horizontal">

                        <div class="form-group has-feedback">
                            <label for="email" class="control-label col-md-3">Email:</label>
                            <div class="col-md-6">
                                <input type="email" class="form-control" required="required" name="email" id="email" placeholder="Email" />
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                        </div>

                        <div class="form-group has-feedback">
                            <label for="twiter" class="control-label col-md-3">Twiter:</label>
                            <div class="col-md-6">
                                <div class="input-group">
                                    <span class=" input-group-addon">@</span>
                                    <input type="text" class="form-control" required="required" name="twiter" id="twiter" placeholder="Twiter Handle" />
                                </div>
                                <span class="glyphicon form-control-feedback"></span>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" id="save">Log In</button>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <!-- Alert-->
        <div class="alert alert-success hidden" id="success-alert">
            <h2>Saved Data</h2>
            <div>Your information has been submitted</div>
        </div>

        <!-- Modal Launcher-->
        <div class="row">
            <button type="button" class="col-md-offset-3 col-md-6 btn btn-success" data-toggle="modal" data-target="#myModal">Launch Modal</button>
        </div>
    </div>

    <script src="Scripts/jquery-2.1.3.min.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>

    <script>
        $(function () {
            $('#save').click(function () {
                var formValid = true;
                $('input').each(function () {
                    //find the form group to set our success/error
                    var formGroup = $(this).parents('.form-group');

                    //find the glyphicon to show our check or X
                    var glyphicon = formGroup.find('.glyphicon');

                    //use the HTML5 checkValidity function
                    if (this.checkValidity()) {
                        //show green, remove red
                        formGroup.addClass('has success').removeClass('has-error');
                        //show check, remove X
                        glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
                    } else {
                        //show red, remove green
                        formGroup.addClass('has-error').removeClass('has-success');
                        //show X, remove check
                        glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                        // mark form as invalid
                        formValid = false;

                    }
                });
                if (formValid) {
                    // hide modal dialog
                    $('#myModal').modal('hide');
                    // show alert
                    $('#success-alert').removeClass('hidden');
                }
            });
        });

    </script>
</body>
</html>
