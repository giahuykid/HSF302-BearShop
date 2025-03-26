<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Sản Phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        form {
            display: inline-block;
            text-align: left;
            background: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Thêm Sản Phẩm</h1>
<form action="manageProductaction" method="post">

    <tr>
        <td>Name Product</td>
        <td><input type="text" name="txtproductName" required></td>
    </tr>

    <tr>
        <td>Price</td>
        <td><input type="text" name="txtproductPrice" required></td>
    </tr>

    <tr>
        <td>Brand</td>
        <td><input type="text" name="txtproductBrand" required></td>
    </tr>

    <tr>
        <td>Date</td>
        <td><input type="text" name="txtcreatedDate" required></td>
    </tr>

    <tr>
        <td>Material</td>
        <td><input type="text" name="txtmaterial" required></td>
    </tr>

    <input type="hidden" name="btnaction" value="addProduct">
    <td>
        <input type="hidden" name="btnaction" value="addProduct">
        <button type="submit">add movie</button>
    </td>
</form>
</body>
</html>
