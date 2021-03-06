<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



 
<head>
<c:url value="/css/style.css" var="style" />
	<link href="${style}" rel="stylesheet" />
<c:url value="/css/materia/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
<script src="webjars/jquery/jquery.min.js"></script>
<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/js/gijgo.min.js" />"></script>
<c:url value="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/css/gijgo.min.css" var="gijgo" />
	<link href="${gijgo}" rel="stylesheet" />
<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" var="bootstrapCss1" />
	<link href="${bootstrapCss1}" rel="stylesheet" />
<c:url value="https://use.fontawesome.com/releases/v5.0.13/css/all.css" var="all" />
	<link href="${all}" rel="stylesheet" />
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" />"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des course</title>
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#"><i style="color:white;padding-right:10px;font-size: 25px;" class="fas fa-book"></i>Gestion des formations</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li  class="nav-item">
      	<a class="nav-link" href="#">Cours <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Session/listcs">Sessions</a>
      </li>
	  <li class="nav-item" style="float: right">
        <a class="nav-link" href="/login?logout">Log out</a>
      </li>
 
    </ul>
    
  </div>
</nav>


</header>
<body>

	<div  class="container mySpace">
	     <form action="listc" method="get" class="form-inline">
	        <div class="form-group mb-2">
	         <input type="text" class="form-control" name="name" placeholder="Search Title" />
	         <input type="submit" value="Search"  class="btn btn-primary"/>
	        </div>
	     </form>
		<div class="card">
			<div class="card card-body">
				<table class="table table-hover">
					<thead>
						<tr>
						  <th></th>	
						  <th>Code</th>
				          <th>Title</th>
				          <th><a href="register"><input type="submit" value="Create"  class="btn btn-primary"/></a></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${pageCourses.content}" var="op">
						<tr>
							<td><i style="color:#343a40;font-size: 25px;" class="fas fa-book"></i></td>
							<td>${op.code}</td>
							<td>${op.title}</td>
						</tr>
					</c:forEach>
					</tbody>

				</table>
			</div>
			<div class="container">
				<ul class="nav nav-pills">
				
				<c:forEach items="${pages}" var="p">
			        <c:choose>
			           <c:when test="${p==pageCourante}">
			             <span class="current"> ${p }</span>
			           </c:when>
			           <c:otherwise>
			             <span class="autrePage">
			               <a href="listc?page=${p}&name=${name}" >${p }</a>
			             </span>
			           </c:otherwise>
			        </c:choose>
        
     			</c:forEach>


				</ul>
			</div>
		</div>
	</div>
</body>
<footer>
<div>

   <p class="text text-center">
     &copy; 2019 LO54 UTBM
   </p>
</div>
</footer>
</html>