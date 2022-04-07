<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css"></style>

</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4">

			</div>
			<div class=col-md-4>
				<br> <br> <br> <br> <br> <br>

				<form action="forgot" method="get" id="forgot"
					role="form">
               <input type="hidden" value="${userEmail}" name="userEmail">
					<div class="form-group">
						<h4 class=>Enter Your Registered Email Here:-</h4>
						<br>
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-envelope"></span>
							</div>
							<input name="userEmail" id="email" type="email"
								class="form-control input-lg" placeholder="Enter Email" required
								data-parsley-type="email">
						</div>
					</div>
					<button  href="sendemail" type="submit" class="btn btn-success btn-block btn-lg">
						<span class="glyphicon glyphicon-send"></span> SEND LINK
                      <!--  <a href="sendemail">Send Link</a> -->
					</button>
					<div class="alert alert-success">
						<strong>${msg}</strong> 
						<p class="text-danger">${send}</p>
						
						</div>
						
					
				</form>


				<div class="modal-footer">
					<p>
						Remember Password ? <a id="loginModal1"
							href="http://localhost:4344/lms/">Login Here!</a>
					</p>
				</div>

			</div>

			<div class=col-md-4></div>
		</div>
	</div>

	<!-- forgot password content -->