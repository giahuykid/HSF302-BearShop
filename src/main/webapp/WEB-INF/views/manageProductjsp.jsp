<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Manage Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        button {
            padding: 5px 10px;
            margin: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2>Product Management</h2>

<!-- Nút thêm sản phẩm -->
<form action="manageProductaction" method="POST">
    <input type="hidden" name="btnManageProduct" value="add">
    <button type="submit">Add Product</button>
</form>

<!-- Hiển thị danh sách sản phẩm -->
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Brand</th>
        <th>Created Date</th>
        <th>Material</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productBrand}</td>
            <td>${product.createdDate}</td>
            <td>${product.material}</td>
            <td>
                <form action="manageProductaction" method="POST" style="display:inline;">
                    <input type="hidden" name="btnManageProduct" value="update">
                    <input type="hidden" name="txtproductName" value="${product.productName}">
                    <input type="hidden" name="txtproductPrice" value="${product.productPrice}">
                    <input type="hidden" name="txtproductBrand" value="${product.productBrand}">
                    <input type="hidden" name="txtcreatedDate" value="${product.createdDate}">
                    <input type="hidden" name="txtmaterial" value="${product.material}">
                    <button type="submit">Update</button>
                </form>

                <form action="manageProductaction" method="POST" style="display:inline;">
                    <input type="hidden" name="btnManageProduct" value="delete">
                    <input type="hidden" name="txtproductName" value="${product.productName}">
                    <button type="submit" onclick="return confirm('Are you sure you want to delete this product?');">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
