<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<style>
.img{width: 100px;
height:100px;
}
.zoomin .img:hover { width: 250px; height: 300px; }

}</style>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link xmlns:sec="http://www.springframework.org/security/tags">
<title>View All products</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:black;">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="home" style="color:white;">Home</a></li>
      
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
         
      <li><a href="${pageContext.request.contextPath}/logout" style="color:white;"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
<div ng-app="myApp" ng-controller="customersCtrl">


            
<br><br><br><table class="table">
 
  <tr ng-repeat="x in names | filter:searchBy" >
    <td style="text-align=:right;"> <img  class="img" src='<x:url value="/resources/images/{{ x.image}}" />'/></td>
    <td>{{x.Name}}<br>
    {{x.Price}}<br>
    {{x.Description}}<br>
   
     
    <a href="${pageContext.servletContext.contextPath}/viewproduct?id={{x.id}}"><span>View</span></a>
   
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.servletContext.contextPath}/editproduct?id={{x.id}}"><span>Edit</span></a>
   <a href="${pageContext.servletContext.contextPath}/delete?id={{x.id}}"><span>Delete</span></a>
   </sec:authorize></td></tr>
  <tr> <sec:authorize access="hasRole('ROLE_ADMIN')">
<td><a href="addpro" class="btn btn-info" style="background-color:black;">Add Product</a></td>
 </sec:authorize>
 
  </tr>
 
</table>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list")
    .then(function (response) {$scope.names = response.data;});
});
</script>

</div>
</div>	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>