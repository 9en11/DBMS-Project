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
.feepay{
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
   <sec:authorize access="hasRole('ADMIN')">
  
      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="/admin" class="nav-link">Admin</a></li>
          <li class="nav-item"><a href="/admin/register" class="nav-link">Add new user</a></li>
          <li class="nav-item"><a href="<c:url value="/j_spring_security_logout" />" class="nav-link">Logout</a></li>
          
        </ul>
      </div>
</sec:authorize>
<sec:authorize access="hasRole('STUDENT')">

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="/student" class="nav-link">Dashboard</a></li>
          <li class="nav-item"><a href="/student/viewprofile" class="nav-link">View Profile</a></li>
          <li class="nav-item"><a href="/student/viewsubjects"class="nav-link">View Your Subjects</a></li>
          <li class="nav-item"><a href="/student/feestatus" class="nav-link">Fee Status</a></li>
         
     
          <li class="nav-item"><a href="<c:url value="/j_spring_security_logout" />" class="nav-link"><span>LOGOUT</span></a></li>
        </ul>
      </div>
      
      </sec:authorize>
    </div>
  </nav>
    <div class="cap" > Student Profile</div>
  			<table id="customers">
			 
			<tbody>
        	
        	<tr>
	        	<td><b>Admission No.:</b></td>
	        	<td>${student.adm_no}</td>
        	</tr>
        	<tr>
	        	<td><b>First Name</b></td>
	        	<td>${student.first_name}</td>
        	</tr>
        	<tr>
	        	<td><b>Middle Name</b></td>
	        	<td>${student.middle_name}</td>
        	</tr>
        	<tr>
	        	<td><b>Last Name</b></td>
	        	<td>${student.last_name}</td>
        	</tr>
        	<tr>
	        	<td><b>Gender</b></td>
	        	<td>${student.sex}</td>
        	</tr>
        	<tr>
	        	<td><b>DOB</b></td>
	        	<td>${student.dob}</td>
        	</tr>
        	<tr>
	        	<td><b>Mobile No</b></td>
	        	<td>${student.contact_no}</td>
        	</tr>
        	<tr>
	        	<td><b>Email ID</b></td>
	        	<td>${student.email}</td>
        	</tr>
        		<tr>
	        	<td><b>School ID</b></td>
	        	<td>${student.school_id}</td>
        	</tr>
        		<tr>
	        	<td><b>Bus No:</b></td>
	        	<td>${student.bus_no}</td>
        	</tr>
        	<tr>
	        	<td><b>Address</b></td>
	        	<td>${student.address}</td>
        	</tr>
        
        	
		  </tbody>
		</table>
		<div class="feepay">
    <sec:authorize access="hasRole('ADMIN')">
   <a href="/admin/feestatus/${student.adm_no}" class="nav-link">PAY FEE</a>
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
