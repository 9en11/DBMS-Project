<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>
<spring:url var="style" value="/style" />
<html>


<head>
<title>dbms</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

    <link rel="stylesheet" href="${style}/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${style}/css/animate.css">
    
    <link rel="stylesheet" href="${style}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${style}/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${style}/css/magnific-popup.css">

    <link rel="stylesheet" href="${style}/css/aos.css">

    <link rel="stylesheet" href="${style}/css/ionicons.min.css">

    <link rel="stylesheet" href="${style}/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${style}/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="${style}/css/flaticon.css">
    <link rel="stylesheet" href="${style}/css/icomoon.css">
    <link rel="stylesheet" href="${style}/css/style.css">
<style>


#customers {
  font-family: poppins-Regular;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
.cap{
 font-family: poppins-Regular;
 text-align: centre;
margin-left: 40%;
  width: 50%;
  font-size:25px;
 font-color: Black;
  padding: 10px;
}
.viewstudents{
margin:auto;
width:50%;
}

</style>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">


<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="/dbms"><i class="flaticon-university"></i>LITTLE FLOWER CHILDREN SCHOOL<br><small>MAU</small></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> Menu
      </button>

     <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="/teacher" class="nav-link">Dashboard</a></li>
          <li class="nav-item"><a href="/teacher/viewprofile" class="nav-link">View Profile</a></li>
          <li class="nav-item"><a href="/teacher/viewyoursubjects"class="nav-link">View Your Subjects</a></li>
          <li class="nav-item"><a href="/teacher/viewyourclass" class="nav-link">View Your Class</a></li>
     
          <li class="nav-item"><a href="<c:url value="/j_spring_security_logout" />" class="nav-link"><span>LOGOUT</span></a></li>
        </ul>
      </div>
    </div>
  </nav>
    <div class="cap" > Class Details</div>
  			<table id="customers">
			 
			<tbody>
        	
        	<tr>
	        	<td><b>Class Id</b></td>
	        	<td>${class.class_id}</td>
        	</tr>
        	
        	        
        	<tr>
	        	<td><b>School ID</b></td>
	        	<td>${class.school_id}</td>
        	</tr>
        	
        	<tr>
	        	<td><b>Class</b></td>
	        	<td>${class.class_name}</td>
        	</tr>

        	<tr>
	        	<td><b>Class Teacher Id</b></td>
	        	<td>${teacher.id}</td>
        	</tr>
                  
        	<tr>
	        	<td><b>Class Teacher Name</b></td>
	        	<td>${teacher.name}</td>
        	</tr>
        	
		  </tbody>
		</table>
      
      
      <div class="viewstudents">
    <sec:authorize access="hasRole('TEACHER')">
   <a href="/teacher/viewstudents" class="nav-link">View Your Students</a>
</sec:authorize>
		</div>	
      
        	
			
</c:if>


<script src="${style}/js/jquery.min.js"></script>
  <script src="${style}/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${style}/js/popper.min.js"></script>
  <script src="${style}/js/bootstrap.min.js"></script>
  <script src="${style}/js/jquery.easing.1.3.js"></script>
  <script src="${style}/js/jquery.waypoints.min.js"></script>
  <script src="${style}/js/jquery.stellar.min.js"></script>
  <script src="${style}/js/owl.carousel.min.js"></script>
  <script src="${style}/js/jquery.magnific-popup.min.js"></script>
  <script src="${style}/js/aos.js"></script>
  <script src="${style}/js/jquery.animateNumber.min.js"></script>
  <script src="${style}/js/bootstrap-datepicker.js"></script>
  <script src="${style}/js/jquery.timepicker.min.js"></script>
  <script src="${style}/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${style}/js/google-map.js"></script>
  <script src="${style}/js/main.js"></script>
  

</body>
</html>
