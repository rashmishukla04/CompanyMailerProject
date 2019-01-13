<html>
	<head>
		  <title>CompanyMailer</title>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="jumbotron text-center">
		<h1>Company Mailer</h1>
		</div>
		 <div class="container">
			<div class="row">
			  <div class="col-md-8">
				<div class="container">
				<form name="frm" action="RegisterServlet1" method="post">
					<table>
					  <tr><td>Name :</td><td><input type="text" name="name" required></td></tr>
					  <tr><td>Email :</td><td><input type="text" name="email" required>@cmailer.com</td></tr>
					  <tr><td>Password :</td><td><input type="password" name="password" required></td></tr>
					  <tr><td>Gender :</td><td><input type="radio" name="gnder" value="male" required>Male<input type="radio" name="gnder" value="female">Female</td></tr>
					  <tr><td>DOB:</td><td><input type="date" name="dob" required></td></tr>
					  <tr><td>Address:</td><td><textarea type="text" name="address" rows="5" col="15" required></textarea></td></tr>
					  <tr><td>City :</td><td><input type="text" name="city" required></td></tr>
					  <tr><td>State :</td><td><input type="text" name="state" required></td></tr>
					  <tr><td>Country :</td><td><select name="country" required>
					  <option>Select country :</option>
					  <option>India</option>
					  <option>USA</option>
					  <option>China</option>
					  <option>other</option>
					  </select></td></tr>
					  <tr><td>Contact :</td><td><input type="text" name="contact" required></td></tr>
					   <tr><td><input type="submit" name="sbt"></input></td><td><input type="button" name="reset" Value="Reset"></input></td></tr>
					</table>
				</form>
				</div>
			  </div>
			  <div class="col-md-4">
			    <div class="container">
					<form name="frm1" action="LoginServlet" method="post">
					<table>
						<tr>Login Here!</tr>
							<tr><td>Email::</td><td><input type="text" name="Email"></td></tr>
							<tr><td>Password::</td><td><input type="password" name="password"></td></tr>
							<tr><td colspan="2"><input type="submit" name="sbt"></input></td></tr>
						
					</table>
				</form>
				</div>
			  </div>
			</div>
		</div>
	</body>
</html>