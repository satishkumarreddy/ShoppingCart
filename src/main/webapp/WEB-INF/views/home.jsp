<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
body{

background-repeat: no-repeat;
background-position: right top;
background: url("<c:url value="/resources/images/background.jpg" />")
}
footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/bootstrap.css/"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/fonts/glyphicons-halflings-regular.woff2/"/>"/>

 
<!-- jQuery library -->


<!-- Latest compiled JavaScript -->

</head>
<body>
<jsp:include page="header.jsp"></jsp:include> <br>
<jsp:include page="courosel.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>