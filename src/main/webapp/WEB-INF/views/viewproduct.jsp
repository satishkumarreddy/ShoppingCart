<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<style>
p {
    font-size: 100%;
}
img{width: 300px;
height:300px;
}
</style>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../jquery.imgzoom.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Product Details</title>
</head>
<nav class="navbar navbar-inverse" style="background-color:black;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home" style="color:white;">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
  <li><a href="${pageContext.request.contextPath}/Logout" style="color:white;"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<h2>Product Details</h2><br><br><br><br>
      	<div class="col-md-7">
					<div class="container">
           
             <div class="imgBox">
              <img src='<x:url value="/resources/images/${product.image}"/>'/></div></div>
            </div>
            
            
            <div class="col-md-5">
					<div class="container" >
           <p><b>Product Name:</b> ${product.name}</p><br><br>
            <p><b>Product Price:</b> ${product.price}</p><br><br>
          <p><b>Product Description:</b> ${product.description}</p><br><br>
           <a href="${pageContext.servletContext.contextPath}/viewcart?id=${product.id }" class="btn btn-info" style="background-color:black;">Add to cart </a>
							
						
           </div>
           </div>
            
            
      
					
					
      	
     <jsp:include page="footer.jsp"></jsp:include> 
   </body>
</html>
