<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse" style = "background-color: #337ab7;font-weight: bold;margin-top: -40px;">
  <div class="container-fluid">
    <div class="navbar-header" style="margin-left: 50px;">
      <a class="navbar-brand" href="#">safe-cabs</a>
    </div>
    <ul class="nav navbar-nav navbar-right" style = "margin-right: 30px;">
    	<li><a onclick="login()"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
      <li><!-- <a href="#"><span class="glyphicon glyphicon-user"></span> SIGN UP</a> -->
      	<div class="dropdown" style="margin-top: 9px;">
  			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="signupdropdown" style="width: 161px;background-color: transparent;border-width: inherit;">SIGN UP</button>
  			<ul class="dropdown-menu">
    			<li><a href="${contextPath}/registration">User</a></li>
    			<%-- <li><a href="${contextPath}/registration/Customer">Customer</a></li> --%>
  			</ul>
		</div>
      </li>
    </ul>
  </div>
</nav>
<div class="container col-md-4 col-md-offset-4" id = "signindiv" style="display: ${error != null || message != null ? 'block' : 'none'}">
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="User Id/Email Id"
                   autofocus/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script>
function login() {
  document.getElementById("signindiv").style.display = "block";
}
</script>
</body>
</html>
