<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Personal Shopper</title>
	</head>
	<body>
		
		<form action="RegisterServlet" method="post">
			<fieldset>
			<legend> Registration Form</legend>
			User Name:<br/><input type="text" name="userName"/><br/>
			Password:<br/><input type="password" name="password"/><br/>
			Date of Birth: <br/><input type="date" name="dob" /><br/>
			Address:<br/> <textarea name="address" /></textarea><br/>
			Email:<br/><input type="text" name="email" /><br/>
			Phone: <br/><input type="tel" name="phone" /><br/>
			
			<br/>
			<input type="submit" value="Register"/>
			</fieldset>
		</form>
	</body>
</html>
