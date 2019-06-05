<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
<c:url value="/css/myStyle.css" var="myCss" />
	<link href="${myCss}" rel="stylesheet" />
<title>Register Client</title>
</head>
<body>
<div class="col-md-6 col-sm-6 col-xs-12 spacer col-md-offset-3"style="opacity: 0.8;filter: alpha(opacity=60)" >
		<div class="panel panel-default ">
			<div class="panel-heading">Saisie d'un Utilisateur</div>
			<div class="panel-body">
			
				<form action="registration" action="post" >
				
					<div class="form-group">
						<label class="control-label">Nom: </label>
						<input type="text" name="lastName" class="form-control">
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prenom: </label>
						<input type="text" name="firstName" class="form-control">
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label class="control-label">Email: </label>
						<input type="text" name="email" class="form-control"/>
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label class="control-label">Password: </label>
						<input type="password" name="password" class="form-control"/>
						<span class="text-danger"></span>
					</div>
					<div class="form-group">
						<label class="control-label">Téléphone: </label>
						<input type="text"  name="phone" class="form-control"/>
						<span class="text-danger" ></span>
					</div>
					<div class="form-group">
						<label class="control-label">Adresse: </label>
						<input type="text"  name="adresse" class="form-control"/>
						<span class="text-danger" ></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Save</button>
						<button class="btn btn-link" style="right: left"><a>Cancel</a></button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>