<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant Registration</title>
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

<form:form action="saveMerchant" modelAttribute="merchantobj">
	<fieldset>
	    <legend class="text-danger border-bottom border-black mb-3">Merchant Registration</legend>	
	     
	  <div class="mb-3">
	    <label for="name" class="form-label">Enter Name<span class="text-danger"> *</span></label>
	    <form:input path="name" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="mobileno" class="form-label">Enter Mobile number<span class="text-danger"> *</span></label>
	    <form:input path="mobileno" class="form-control border-black"/>
	  </div>
	  <div class="mb-3">
	    <label for="email" class="form-label">Enter Email<span class="text-danger"> *</span></label>
	    <form:input path="email" class="form-control border-black"/>
	  </div> 
	
	  <div class="mb-3">
	    
	    <div class="row">
	    	<div class="col">
	    		<label class="form-label">Enter Password<span class="text-danger"> *</span></label>
	    	</div>
	    	<div class="col">
	    		<input type="checkbox" onclick="show()" class="form-check-input border-black" />
	    		<label class="form-check-label">Show Password</label>
	    	</div>
	    </div>
	    <form:password path="password" class="form-control border-black" id="pswd"/>    
	  
	  </div>  
	
	<input type="submit" class="btn btn-success" />	
	</fieldset>
</form:form>
	
</div>
</body>

<script type="text/javascript">
	function show() {
		  var x = document.getElementById("pswd");
		  if (x.type === "password") {
		    x.type = "text";
		  } else {
		    x.type = "password";
		  }
		} 
</script>
</html>