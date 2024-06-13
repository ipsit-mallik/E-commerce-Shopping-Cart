<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Products</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<style>
	caption{
		font-weight: bold;
		font-size: 20px;
	}
	.btn,a{
		font-weight: bold;	
	}
	.text-light{
		text-decoration: none;
	}
</style>
</head>
<body>
<% List<Product> products = (List<Product>) request.getAttribute("productList"); %>

<div class="container-fluid p-4">
<div class="card">
<div class="card-header bg-dark">
	<div class="d-flex">
	<a href="displayAllProduct" class="text-light fs-5 me-5">List of Products</a>
		<div class="dropdown">
		<button class="btn btn-dark btn-sm dropdown-toggle" data-toggle="dropdown">Filter By</button>
		  <ul class="dropdown-menu dropdown-menu-dark">
		    <li><a href="CustomerSearchForm.jsp?id=brand" class="dropdown-item">Brand</a></li>
		    <li><a href="CustomerSearchForm.jsp?id=category" class="dropdown-item">Category</a></li>
		    <li><a href="CustomerSearchForm.jsp?id=range" class="dropdown-item">Range</a></li>
		  </ul>
		</div>
	</div>
</div>
<div class="card-body">
	<table class="table">
	<thead align="center">
		<tr>
			<th>Brand</th>
			<th>Model</th>
			<th>Category</th>
			<th>Price</th>
			<th>Add to cart</th>
		</tr>
	</thead>
	<tbody align="center">
	<% for(Product p : products){ %>
		<tr>
			<td><%= p.getBrand() %></td>
			<td><%= p.getModel() %></td>
			<td><%= p.getCategory() %></td>
			<td><%= p.getPrice() %></td>
			<td><a href="addItem?id=<%= p.getId() %>">Add</a></td>
		</tr>
	<% } %>
	</tbody>
	</table>
</div>
</div>
<div class="d-flex mt-2">
	<a href="CustomerOptions.jsp" class="btn btn-warning">Option Menu</a>
	<a href="fetchItemofCart" class="btn btn-warning ms-auto">View Cart</a>
</div>
</div>
</body>
</html>