<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Search</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	.container{
		width: 420px;
		border-radius: 15px;
		box-shadow: 0 0 4px black;
	}
	.btn{
		font-weight: bold;
		font-size: 17px;
	}
</style>
</head>
<body>
<% String s = request.getParameter("id"); %>
<%	if(s.equals("brand")){ %>
<div class="container mt-5 border border-black p-5" >
	<form action="displayProductbyBrand">
	<div class="mb-3">
		    <label class="form-label">Enter Brand</label>
		    <input type="text" name="brand" class="form-control border-black"/>
	</div>
	<input type="submit" class="btn btn-success"/>
	</form>
</div>
<% } else if(s.equals("category")){ %>
<div class="container mt-5 border border-black p-5" >
	<form action="displayProductbyCategory">
	<div class="mb-3">
			<label class="form-label">Enter Category</label>
		    <input type="text" name="category" class="form-control border-black"/>
	</div>
	<input type="submit" class="btn btn-success"/>
	</form>
</div>
<% } else { %>
<div class="container mt-5 border border-black p-5" >
	<h5 class="text-danger">Choose range</h5>
	<div class="btn-group btn-group-sm">
		<a href="displayProductbyRange?id=below-500" class="btn btn-outline-secondary">Below 500</a>
		<a href="displayProductbyRange?id=500-1000" class="btn btn-outline-secondary">500-1000</a>
		<a href="displayProductbyRange?id=above-1000" class="btn btn-outline-secondary">Above 1000</a>
	</div>
</div>	
<% } %>
</body>

</html>