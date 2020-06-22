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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="${contextPath}/resources/css/bootstrap-year-calendar.min.css" rel="stylesheet">

<style type="text/css">
ul {list-style-type: none;}
body {font-family: Verdana, sans-serif;}

/* Month header */
.month {
  padding: 8px 4px;
  width: 100%;
  background: #1abc9c;
  text-align: center;
}

.inactive {
    background-color: grey;
}

/* Month list */
.month ul {
  margin: 0;
  padding: 0;
}

.month ul li {
  color: white;
  font-size: 20px;
  text-transform: uppercase;
  letter-spacing: 3px;
}

/* Previous button inside month header */
.month .prev {
  float: left;
  padding-top: 10px;
}

/* Next button */
.month .next {
  float: right;
  padding-top: 10px;
}

/* Weekdays (Mon-Sun) */
.weekdays {
  margin: 0;
  padding: 10px 0;
  background-color:#ddd;
}

.weekdays li {
  display: inline-block;
  width: 13.6%;
  color: #666;
  text-align: center;
}

/* Days (1-31) */
.days {
  padding: 10px 0;
  background: #eee;
  margin: 0;
}

.days li {
  list-style-type: none;
  display: inline-block;
  width: 13.6%;
  text-align: center;
  margin-bottom: 5px;
  font-size:12px;
  color: #777;
}

/* Highlight the "current" day */
.days li .active {
  padding: 5px;
  background: #1abc9c;
  color: white !important
}


</style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse" style = "background-color: #337ab7;font-weight: bold;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">schoology</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="#">UPGRADE</a></li>
      <li class="active"><a href="#">COURSES</a></li>
      <li><a href="#">GROUPS</a></li>
      <li><a href="#">RESOURCES</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right" style = "margin-right: 30px;">
    	<li>
    	<input type="hidden" id="context" value="${contextPath}"/>
    	</li>
    	<c:if test="${pageContext.request.userPrincipal.name != null}">
    	<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" id="csrftoken" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
	      <li><!-- <a href="#"><span class="glyphicon glyphicon-user"></span> SIGN UP</a> -->
	      	<div class="dropdown" style="margin-top: 9px;">
	  			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" style="width: 161px;background-color: transparent;border-width: inherit;">${pageContext.request.userPrincipal.name}</button>
	  			<ul class="dropdown-menu">
	    			<li><a onclick="document.forms['logoutForm'].submit()">LOGOUT</a></li>
	    			
	  			</ul>
			</div>
	      
	      </li>
      </c:if>
      
    </ul>
  </div>
</nav>
<div class="container" >
	<h2>Courses</h2>
	<div id="maincontainer">
	</div>
	
	<div class="month" id ="year">
	  <ul>
		  <li>
		  	<button type="button" class="btn inactive" onclick="year('2016')" id="2016">2016</button>
	    	<button type="button" class="btn inactive" onclick="year('2017')" id="2017">2017</button>
	    	<button type="button" class="btn inactive" onclick="year('2018')" id="2018">2018</button>
	    	<button type="button" class="btn inactive" onclick="year('2019')" id="2019">2019</button>
	    	<button type="button" class="btn btn-primary" onclick="year('2020')" id="2020">2020</button>
		  </li>
	  </ul>
	</div>

	<div class="month" id="month">
		<ul>
	    	<li>
			    <button type="button" class="btn inactive"  onclick="month('1')" id="1">January</button>
			    <button type="button" class="btn inactive" onclick="month('2')" id="2">February</button>
			    <button type="button" class="btn inactive" onclick="month('3')" id="3">March</button>
			    <button type="button" class="btn inactive" onclick="month('4')" id="4">April</button>
			    <button type="button" class="btn inactive" onclick="month('5')" id="5">May</button>
			    <button type="button" class="btn btn-primary" onclick="month('6')" id="6">June</button>
			    <button type="button" class="btn inactive" onclick="month('7')" id="7">July</button>
		    	<button type="button" class="btn inactive" onclick="month('8')" id="8">August</button>
		    	<button type="button" class="btn inactive" onclick="month('9')" id="9">September</button>
		    	<button type="button" class="btn inactive" onclick="month('10')" id="10">October</button>
		    	<button type="button" class="btn inactive" onclick="month('11')" id="11">November</button>
		    	<button type="button" class="btn inactive" onclick="month('12')" id="12">December</button>
	   		</li>
		</ul>
	</div>

	<ul class="weekdays" id="weekday">
	  <li>Mo</li>
	  <li>Tu</li>
	  <li>We</li>
	  <li>Th</li>
	  <li>Fr</li>
	  <li>Sa</li>
	  <li>Su</li>
	</ul>

	<ul class="days" id="day">
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
		<li>6</li>
		<li>7</li>
		<li>8</li>
		<li>9</li>
		<li>10</li>
		<li>11</li>
		<li>12</li>
		<li>13</li>
		<li>14</li>
		<li>15</li>
		<li>16</li>
		<li>17</li>
		<li>18</li>
		<li>19</li>
		<li>20</li>
		<li>21</li>
		<li>22</li>
		<li><span class="active">23</span></li>
		<li>24</li>
		<li>25</li>
		<li>26</li>
		<li>27</li>
		<li>28</li>
		<li>29</li>
		<li>30</li>
	</ul>
</div>
<div id="myinnertab" style="display: none" class="col-md-15 col-md-offset-0">
	<ul class="nav nav-tabs">
	  <li ><a href="#"></a></li>
	  <li><a href="#"></a></li>
	  <li class="active"><a href="#">My Courses</a></li>
	  <li><a href="#"></a></li>
	</ul>
	<div class="container" >
	<div style="margin-top: 105px;">
	<div class="col-md-10 col-md-offset-4">
	<span>Create a new course and add sections to manage your classes</span><br></div>
	<div class="col-md-10 col-md-offset-5">
	<button type="button" class="btn btn-primary" style="margin-top: 30px;" data-toggle="modal" data-target="#myModal">Join a Course</button>
	<button type="button" class="btn btn-primary" style="margin-top: 30px;" >Create a Course</button>
	</div>
	</div>
	</div>
</div>
<div class="modal-dialog modal-sm">

<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog  modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Join a Course</h4>
        </div>
        <div class="modal-body">
          <p style="font-weight: bold">Access Code: *</p> 
          <form id="joincourse" method="POST" action="${contextPath}/joincourse">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="userName" value="${pageContext.request.userPrincipal.name}"/>
       		<input class="form-control" type="text" name="accessCode" id="accesscode" placeholder="Access Code">
         </form>
        </div>
        <div class="modal-footer">
        	<button type="button" class="btn btn-primary" onclick="document.forms['joincourse'].submit()">Join</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap-year-calendar.min.js"></script>
<script>
var activeyear = 2020;
var activemonth = 1;

function year(yearno) {
	activeyear = yearno;

	$("#year .btn").removeClass("btn-primary");
	$("#year .btn").addClass("inactive");
	
	$("#"+yearno).removeClass("inactive");
	$("#"+yearno).addClass("btn-primary");
	
	getDays();
}

function month(monthno) {
	$("#month .btn").removeClass("btn-primary");
	$("#month .btn").addClass("inactive");
	
	$("#"+monthno).removeClass("inactive");
	$("#"+monthno).addClass("btn-primary");
	
	activemonth = monthno;
	getDays();
}

function getDays() {
	$.ajax({
		type: "GET",
		url: '/calendar/days?year=' + activeyear + '&month=' + activemonth,
		dataType: 'json'
	}).done(function(response){
		$("#day").empty();
		$.each(response, function(k,v) {
			if(v != "") {
				$("#day").append("<li title='" + v + "'><span class='active'>" + k + "</span></li>");
			} else {
				$("#day").append("<li>" + k + "</li>");
			}
		});		
	});
	
}

$(function() {
    $('#calendar').calendar();
});

function openNav() {
  document.getElementById("maincontainer").style.display = "none";
  document.getElementById("myinnertab").style.display = "block";
}
</script>
</body>
</html>
