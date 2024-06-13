<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Item"%>
<%@page import="com.jsp.shoppingcart.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Bill</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
    #main{
        max-width: 1080px;
    }
    #price{
        
        position: sticky;
        top: 104px;
    }
    .btn,span{
        font-weight: bold;
    }
    .bg-white{
        border-radius: 5px;
        padding: 5px 15px;
        box-shadow: 0 0 4px black;
    }
</style>
</head>
<body>
<% Orders o = (Orders)request.getAttribute("orderDetail"); 
	List<Item> items = o.getItems();
%>
<div class="container mt-5" id="main">
        <div class="bg-white mb-3"><h1 class="text-success">Order placed</h1></div>
        <div class="row">
            <div class="container col-8">
                <div class="card mb-2 shadow-sm border-black">
                    <div class="card-body">
                        <p class="card-text"><span>Name: </span><%= o.getName() %></p>
                        <p class="card-text"><span>Address: </span><%= o.getAddress() %></p>
                        <p class="card-text"><span>Mobile number: </span><%= o.getMobileno() %></p>
                    </div>
                </div>
                <% for(Item i:items){ %>
                    <div class="card mb-1 shadow-sm border-black">
                        <div class="card-body">
                            <table class="table table-borderless">
                                <tr>
                                    <td><p><span>Brand: </span><%= i.getBrand() %></p></td>
                                    <td><p><span>Category: </span><%= i.getCategory() %></p></td>
                                    <td><p><span>Model: </span><%= i.getModel() %></p></td>
                                </tr>
                                <tr>
                                    <td><p><span>Price: </span><%= i.getPrice() %></p></td>
                                    <td><p><span>Quantity: </span><%= i.getQuantity() %></p></td>
                                </tr>
                            </table>    
                        </div>
                    </div>  
                <% } %>
            </div>
            <div class="col-4">
                <div id="price">
                    <div class="card mb-2 shadow-sm border-black" style="height: 137px;">
                        <div class="card-body">
                            <p class="card-title fw-bold">Total Price: <%= o.getTotal_price() %></p>
                        </div>
                    </div>
                    <a href="CustomerOptions.jsp" class="btn btn-warning float-end">Option Menu</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>