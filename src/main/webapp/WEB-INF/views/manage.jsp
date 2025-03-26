<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .menu {
            display: flex;
            justify-content: center;
            gap: 20px;
        }
        .menu a {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .menu a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Quản lý</h1>
<div class="menu">
    <button onclick="window.location.href='/addProduct'">Add New Product</button>
    <a href="updateProduct.jsp">Update Product</a>
    <a href="showProduct.jsp">show list product</a>

</div>
</body>
</html>