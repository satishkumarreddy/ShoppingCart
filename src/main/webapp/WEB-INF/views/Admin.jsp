<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">ShoppingCart</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li class="active"><a href="viewproducts">ManageProducts</a></li>
      <li class="active"><a href="viewsuppliers">ManageSuppliers</a></li>
    
        </ul>
        <ul class="nav navbar-nav navbar-right">
				  <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
         </div>
         </nav>
         <jsp:include page="footer.jsp"></jsp:include>
         </body>
         </html>
         
        
        
      
                          
      

   
     
    
        
      
 
    
  


</body>
</html>
