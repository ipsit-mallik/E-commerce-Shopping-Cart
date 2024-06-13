<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
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
<div class="container mt-5 border border-black p-5" >
<form:form action="saveProduct" modelAttribute="productobj">
<fieldset>
	    <legend class="text-danger border-bottom border-black mb-3">Product Details</legend>	
	     
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Brand<span class="text-danger"> *</span></label>
	    <form:input path="brand" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Category<span class="text-danger"> *</span></label>
	    <form:input path="category" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Model<span class="text-danger"> *</span></label>
	    <form:input path="model" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Price<span class="text-danger"> *</span></label>
	    <form:input path="price" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter stock<span class="text-danger"> *</span></label>
	    <form:input path="stock" class="form-control border-black"/>
	  </div>

<input type="submit" class="btn btn-success" />	
</fieldset>
</form:form>
</div>
</body>
</html>