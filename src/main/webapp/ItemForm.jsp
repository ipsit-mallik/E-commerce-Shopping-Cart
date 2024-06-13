<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	.container{
		width: 420px;
		border-radius: 15px;
		box-shadow: 0 0 4px black;
	}
	.btn,label,legend{
		font-weight: bold;
	}
</style>
</head>
<body>
<% Product p = (Product)request.getAttribute("productObj"); %>
<div class="container mt-5 border border-black p-5" >
<form action="addItemToCart">
<fieldset>
	<legend class="text-danger border-bottom border-black mb-3">Product Details</legend>
	
	<!-- hidden form field -->
	<input type="hidden" name="id" value="<%= p.getId() %>" readonly> 
	<div class="mb-3">
		    <label class="form-label">Brand</label>
		    <input type="text" name="brand" value="<%= p.getBrand() %>" class="form-control" readonly>
	</div>
	<div class="mb-3">
		    <label class="form-label">Model</label>
		    <input type="text" name="model" value="<%= p.getModel() %>" class="form-control" readonly>
	</div>
	<div class="mb-3">
		    <label class="form-label">Category</label>
		    <input type="text" name="category" value="<%= p.getCategory() %>" class="form-control" readonly>
	</div>
	<div class="mb-3">
		    <label class="form-label">Price</label>
		    <input type="number" name="price" value="<%= p.getPrice() %>" class="form-control" readonly>
	</div>
	<div class="mb-3">
		    <label class="form-label">Quantity</label>
		    <input type="number" name="quantity" value="1" class="form-control">
	</div>
	<input type="submit" value="Add to cart" class="btn btn-success">
</fieldset>
</form>
</div>
</body>
</html>