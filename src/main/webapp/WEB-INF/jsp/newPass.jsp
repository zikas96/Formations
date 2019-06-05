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
			<div class="panel-heading">Renitialiser mot de passe</div>
			<div class="panel-body">
				<form action="/Client/getPass" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label">Login: </label>
						<input type="email"  name="email" class="form-control" placeholder="Email"/>
						<span style="display: none">Vous receverez votre mot de pass sur votre Email</span>
					</div>
					
					
					<div>
						<button type="submit" class="btn btn-primary">Envoyer</button>
					</div>


				</form>
			</div>
		</div>
	</div>
</body>
</html>