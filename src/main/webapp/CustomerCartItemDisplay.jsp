<%@page import="com.jsp.shoppingcart.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Item in Cart</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	#container{
		text-align: center;
		border: 1px solid black;
		box-shadow: 0 0 3px black;
		border-radius: 7px;
		width: 480px;
	}
	caption{
		font-weight: bold;
		font-size: 20px;
	}
	.card-header,.btn,a,span{
		font-weight: bold;	
	}
	
</style>
</head>
<body>
<% List<Item> items = (List<Item>) request.getAttribute("itemList"); 
	double totalPrice = (double)request.getAttribute("totalPrice");
%>
<div class="container p-4">
<% if(items!=null){ if(items.size()>0){ %>
<div class="card">
	<div class="card-header bg-dark text-white">List of items</div>
    <div class="card-body">
		<table class="table">
		<thead align="center">
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Category</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody align="center">
			<% for(Item i : items){ %>
				<tr>
				<td><%= i.getBrand() %></td>
				<td><%= i.getModel() %></td>
				<td><%= i.getCategory() %></td>
				<td><%= i.getQuantity() %></td>
				<td><%= i.getPrice() %></td>
				<td><a href="removeItemfromCart">Remove</a></td>
			</tr>
			<% } %>	
		</tbody>
		</table>
		<div class="float-end me-4">
			<span class="p-2">Total Price: <%= totalPrice %></span>
		</div>
	</div>
</div>
	<a href="displayAllProduct" class="btn btn-warning mt-2 me-2">Go back</a>
	<a href="removeAllItemFromCart" class="btn btn-warning mt-2">Remove All</a>
	<a href="buyItemInCart" class="btn btn-warning mt-2 float-end">Place Order</a>
<% }else { %>
<div class="container p-5 mt-3 " id="container">
	<h4 class="text-danger mb-4">The cart is Empty!</h4>
	<a href="displayAllProduct" class="btn btn-warning">Shop Now</a>
</div>
<% }} %>
</div>

</body>
</html>