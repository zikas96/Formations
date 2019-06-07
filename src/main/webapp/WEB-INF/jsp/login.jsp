<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<c:url value="/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
<c:url value="/css/myStyle.css" var="myCss" />
	<link href="${myCss}" rel="stylesheet" />
</head>
<body style="background-image: url(/image/site-belfort.jpg);">
	<div class="col-md-6 col-sm-6 col-xs-12 spacer col-md-offset-3" style="opacity: 0.8;filter: alpha(opacity=60)">

		<div class="panel panel-primary">
			<div class="panel-heading">Authentification</div>
			<div class="panel-body">
				<form action="login" method="post">
					<div class="form-group">
						<label class="control-label">Login: </label>
						<input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus/>
						
					</div>
					<div class="form-group">
						<label class="control-label">¨Password: </label>
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
					<div>
						<a href="Client/registerClient">Insription</a>
					</div>
					<div>
						<a href="Mdp">Mot de pass oublié</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>