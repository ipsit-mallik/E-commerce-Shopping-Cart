<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant Main Menu</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
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
	.btn{
		font-weight: bold;
		font-size: 17px;
	}
</style>
</head>
<body>
<div class="container mt-5 border border-black p-5" >
	
	<h1 class="text-danger mb-4 border-bottom border-danger border-2">Welcome Merchant !!</h1>	
	<div class="container-fluid mt-3">
		<a href="addMerchant" class="btn btn-primary mb-3  d-block">Register</a>
		<a href="MerchantloginForm.jsp" class="btn btn-primary d-block">Login</a>
	</div>
	<h4 class="text-success mb-4">${msg}</h4>
</div>
</body>
</html>