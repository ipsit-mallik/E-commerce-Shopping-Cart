<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	caption{
		font-weight: bold;
		font-size: 20px;
	}
	a{
		font-weight: bold;	
	}
</style>
</head>
<body>
<% Merchant m = (Merchant) session.getAttribute("merchantinfo"); 
	List<Product> products = m.getProducts();
%>
<div class="container-fluid p-4">
<table class="table caption-top ">
<caption class="text-danger">List of Products</caption>
<thead class="table-secondary">
	<tr>
		<th>Id</th>
		<th>Brand</th>
		<th>Model</th>
		<th>Category</th>
		<th>Price</th>
		<th>Stock</th>	
		<th>Update</th>
		<th>Delete</th>
	</tr>
</thead>
	<tbody>
	<% for(Product p : products){ %>
		<tr>
			<th><%= p.getId() %></th>
			<td><%= p.getBrand() %></td>
			<td><%= p.getModel() %></td>
			<td><%= p.getCategory() %></td>
			<td><%= p.getPrice() %></td>
			<td><%= p.getStock() %></td>
			<td><a href="updateProduct?id=<%= p.getId() %>" class="link-primary">Update</a></td>
			<td><a href="deleteProduct?id=<%= p.getId() %>" class="link-danger">Delete</a></td>
		</tr>
	<% } %>
	</tbody>
</table>
<a href="MerchantOptions.jsp" class="link-primary">Options menu</a>
</div>
</body>
</html>