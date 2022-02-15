
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <spring:url var="style" value="/style" />
<!DOCTYPE html>
<html lang="en">
<head>
	<title>LOGIN</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>



<body onload='document.loginForm.j_username.focus();'>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="/home"><i class="flaticon-university"></i>LITTLE FLOWER CHILDREN SCHOOL<br><small>MAU</small></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> Menu
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="/" class="nav-link">Home</a></li>
          <li class="nav-item"><a href="about" class="nav-link">About</a></li>
          <li class="nav-item"><a href="contact" class="nav-link">Contact Us</a></li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
          <li class="nav-item cta"><a href="login" class="nav-link"><span>Login</span></a></li>
          </c:if>
          <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li class="nav-item cta"><a href="/j_spring_security_logout" class="nav-link"><span>Logout</span></a></li>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>

	<div class="container-contact100">
		
		<div class="wrap-contact100">
			
				<span class="contact100-form-title-1">
					LITTLE FLOWER CHILDREN SCHOOL
				</span>

				<span class="contact100-form-title-2">
					Login with Username and Password 
				</span>
			
			
			
			<%
				String errorString = (String) request.getAttribute("error");
				if (errorString != null && errorString.trim().equals("true")) {
					out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
				}
			%>
				<form class="contact100-form validate-form" name='loginForm' action="<c:url value='${pageContext.request.contextPath}/j_spring_security_check"' />" method='POST' >
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">User:</span>
					<input class="input100" type="text" name="userName" placeholder="Enter username">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid password is required">
					<span class="label-input100">Password:</span>
					<input class="input100" type="password" name="password" placeholder="Enter password">
					<span class="focus-input100"></span>
				</div>


				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="${style}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${style}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${style}/vendor/bootstrap/js/popper.js"></script>
	<script src="${style}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${style}/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${style}/vendor/daterangepicker/moment.min.js"></script>
	<script src="${style}/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${style}/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="${style}/js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="${style}/js/main2.js"></script>



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
