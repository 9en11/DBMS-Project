<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Login</title>
</head>
<style>

/* Bordered form */
form {
  border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}



/* /* Center the avatar image inside this container */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

 */

/* Add padding to containers */
.container {
  padding: 16px;
}



/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.roll_no {
    display: block;
    float: none;
  }

}

</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="formbody">
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
   <div class="imgcontainer">
     <img src="${static}/images/student.png" alt="Avatar" class="avatar" width="100" height="100">
  </div> 

  <div class="container">
    <label for="adm_no"><b>USER NAME:</b></label>
    <input type="text" placeholder="Enter Your Username" name="userName" required>

    <label for="roll_no"><b>PASSWORD:</b></label>
    <input type="text" placeholder="Enter Your Password" name="password" required>

    <button type="submit">Login</button>
   <!--  <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label> -->
  </div>

<!--   <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div> -->
</form>
</div>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>