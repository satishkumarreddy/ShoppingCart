
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 58%;
      margin: auto;
  }
  
  body{
  
    background-color: #cccccc;
}
    
 
  </style>
</head>
<body>

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="<c:url value="/resources/images/buk4.jpg" />"/> 
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/buk3.jpg" />"/>
      </div>
    
      <div class="item">
        <img  src="<c:url value="/resources/images/buk2.jpg" />"/>
      </div>

      <div class="item">
         <img src="<c:url value="/resources/images/buk1.jpg" />"/>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>  
      <div class="container">
  <br>
  <br>
  <br>
  
  <div class="row">
      
      
      
      <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3images/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/images/buk4.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
       
      
     
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3images/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/images/buk3.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="#" target="#myCarousel">
         <img src="<c:url value="/resources/images/buk2.jpg" />" style="width:255;height:300;"/>
          
        </a>
      </div>
    </div>
     <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3images/fjords.jpg" target="_blank">
          <img src="<c:url value="/resources/images/buk1.jpg" />"style="width:255;height:300;"/>
          
        </a>
      </div>
    </div>
  </div>
</div>
      


</body>
</html>
