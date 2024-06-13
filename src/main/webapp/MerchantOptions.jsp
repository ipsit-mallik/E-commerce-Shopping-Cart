<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant Options</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
 <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
</svg>
<style>
	.container{
		text-align: center;
		width: 490px;
		border-radius: 15px;
		box-shadow: 0 0 4px black;
	}
	.container-fluid{
		width: 200px;
	}
	.btn,a{
		font-weight: bold;
		font-size: 17px;
	}
</style>
</head>
<body>
<% Merchant m = (Merchant) session.getAttribute("merchantinfo"); 
 if(m != null){ %>
<div class="container mt-5 border border-black p-5" >
	
	<h2 class="text-danger mb-4 border-bottom border-danger border-2">Available Options</h2>
	<div class="container-fluid mt-3">	
	<a href="addProduct" class="btn btn-primary mb-3 d-block">Add product</a>
	<a href="DisplayProduct.jsp" class="btn btn-primary mb-3 d-block">Display product</a>
	</div>
	<h4 class="text-success">${msg}</h4>

</div>
<% } else{ %>
 
 <div class="alert alert-danger d-flex align-items-center mt-3 ms-4 me-4" role="alert">
  	<svg class="bi flex-shrink-0 me-2 ms-5" width="25" height="25" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
  	<div>
    	<a href="MerchantloginForm.jsp" class="alert-link">Please Login First</a>
  	</div>
</div>

<% } %>
</body>
</html>