<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url var="style" value="/style" />
<%@page session="true"%>

<html>


<head>
<title>Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--===============================================================================================-->
	<link rel="icon" type="image/png" href="${style}/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${style}/css/util.css">
	<link rel="stylesheet" type="text/css" href="${style}/css/main.css">
<!--===============================================================================================-->
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
margin: auto;
  width: 50%;
  font-size:25px;
/*   border: 3px solid green; */
  padding: 10px;
}
</style>
</head>
<html>
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
          <li class="nav-item active"><a href="/admin" class="nav-link">Admin</a></li>
          <li class="nav-item"><a href="/admin/register" class="nav-link">Add new user</a></li>
          <li class="nav-item"><a href="<c:url value="/j_spring_security_logout" />" class="nav-link">Logout</a></li>
          
        </ul>
      </div>
    </div>
  </nav>
    
        
        
        
        
       
        
        <div class="cap" > Add Bus Detail </div>
      	<form:form method="post" modelAttribute="bus" action="/admin/addbusdetails/">
      	<form:hidden path="bus_no"/> <form:errors path="bus_no"/>
		
		<table id="customers">
		

	
		<tbody>
		
		<tr><td>School Id</td>
		<td>
		<form:input path="school_id" type="integer" value="${bus.school_id}" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="school_id" /></td></tr>
		
		<tr><td>Driver Name</td>
		<td>
		<form:input path="driver_name" type="text" value="${bus.driver_name}" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="driver_name" /></td></tr>
		
		<tr><td>Driver Contact No:</td>
		<td>
		<form:input path="drivercontactno" type="text" value="${bus.drivercontactno}" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="drivercontactno" /></td></tr>
		
		<tr><td>Route</td>
		<td>
		<form:input path="route_string" type="text" value="${student.route_string}" required="required" /> </td><!-- bind to user.name-->
		<td><form:errors path="route_string" /></td></tr>
		
	
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td><td></td>
		</tr>
		
		</tbody>
		</table>
	</form:form>
      
        
        
        
   
        
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
