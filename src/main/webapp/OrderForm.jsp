<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Form</title>
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
<form:form action="saveOrder" modelAttribute="orderObj">
	<fieldset>
	    <legend class="text-danger border-bottom border-black mb-3">Order Details</legend>	
	     
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Name<span class="text-danger"> *</span></label>
	    <form:input path="name" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="address" class="form-label">Enter Address<span class="text-danger"> *</span></label>
	    <form:textarea path="address" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="mobileno" class="form-label">Enter Mobile number<span class="text-danger"> *</span></label>
	    <form:input path="mobileno" class="form-control border-black"/>
	  </div>
	  
	  <input type="submit" class="btn btn-warning" value="Buy Now" />
	 </fieldset>
</form:form>
</div>
</body>
</html>