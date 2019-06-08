<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



 
<head>
<c:url value="/css/style.css" var="style" />
	<link href="${style}" rel="stylesheet" />
<c:url value="/css/materia/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
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
<title>Insert title here</title>
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
      	<a class="nav-link" href="/Course/listc">Cours <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Sessions</a>
      </li>

 
    </ul>
    
  </div>
</nav>


</header>
<body>
<div class="container mySpace">
		<div class="row">
		<div class="col-md-3">
		<form action="/Session/listcs" class="form-inline" name="dropDownCities">
	        <i style="color:#343a40; padding-right:10px;font-size: 25px;" class="fas fa-thumbtack"></i>
	        <div class="form-group mb-2">
	         <select class="form-control" style="height:calc(2.25rem + 17px); width:100px;" name="city" id="cityName" onchange="document.dropDownCities.submit()">
		    	<option value=""></option>
		    	<c:forEach items="${locations}" var="lo">
		    		<option>${lo.city}</option>
		    	</c:forEach>
			  	<option value="">All</option>
				
			</select>
	        </div>
	     </form>
	     </div>
	     <div class="col-md-3">
	     <form action="/Session/listcs" class="form-inline" name="filterByDate">
	     	<i style="color:#343a40; padding-right:10px;font-size: 25px;" class="far fa-calendar-alt"></i>
	        <div class="form-group mb-2">
	         <input type="date" id="datepicker" width="200" class="form-control" name="date" onchange="document.filterByDate.submit()" placeholder="" />
	        </div>
	     </form>
	     </div>
	     </div>
	    <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4',format: 'dd-mm-yyyy'
        });
    	</script>
		<div class="card">
			<div class="card card-body">
				<table class="table table-hover">
					<thead>
						<tr>
						  <th>ID</th>
				          <th>Start Date</th>
				          <th>End Date</th>
				          <th>Percent of Participants</th>
				          <th>Max</th>
				          <th>Course</th>
				          <th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageCourseSessions.content}" var="ses">
							<tr>
								<td>${ses.id}</td>
								<td>${ses.startDate}</td>
								<td>${ses.endDate}</td>
								<c:set var="user" value="CourseSessionRepository.sumClient(${ses.id})" />
								
								<td >${ses.clients.size()*100/ses.number} %</td>
								<td>${ses.number}</td>
								<td>${ses.courseId.title}</td>
								<td>${ses.locationId.city}</td>
								<td><a type="button" class="btn btn-dark" style="color:white; cursor:pointer" href="inscription?codeS=${ses.id}">S'inscrire</a></td>
							</tr>
						</c:forEach>
						
					</tbody>

				</table>
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