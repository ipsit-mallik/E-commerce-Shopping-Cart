<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
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
	<!-- to hide the details of the user we are using post method -->
<form action="merchantloginvalidation" method="post"> 
<fieldset>
	<legend class="text-danger border-bottom border-black mb-3">Login Here</legend>	
		<h4 class="text-danger mt-2">${msg}</h4>
		     
		  <div class="mb-3">
		    <label for="name" class="form-label">Enter Email<span class="text-danger"> *</span></label>
		    <input type="email" name="email" class="form-control border-black"/>
		  </div>
		  <div class="mb-3">   
		    <div class="row">
		    	<div class="col">
		    		<label class="form-label">Enter Password<span class="text-danger"> *</span></label>
		    	</div>
		    	<div class="col form-check form-switch">
		    		<input type="checkbox" onclick="show()" class="form-check-input" />
		    		<label class="form-check-label">Show Password</label>
		    	</div>
		    </div>
		    <input type="password" name="password" class="form-control border-black" id="pswd"/>  
		  </div>
	<input type="submit" class="btn btn-success"/>
</fieldset>
</form>
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