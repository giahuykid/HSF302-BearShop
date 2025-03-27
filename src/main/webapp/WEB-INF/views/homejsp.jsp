<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bear Shop</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        .header {
            background-color: #fff;
            padding: 1rem;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .product-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 2rem;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1rem;
        }
        .product-card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }
        .product-card:hover {
            transform: translateY(-5px);
        }
        .product-image {
            width: 100%;
            height: 400px;
            object-fit: cover;
        }
        .product-info {
            padding: 1.5rem;
            text-align: center;
        }
        .product-info h2 {
            color: #333;
            font-size: 20px;
            margin-bottom: 10px;
        }
        .product-info p {
            color: #666;
            margin: 5px 0;
        }
        .product-info h3 {
            color: #e44d26;
            font-size: 24px;
            margin-top: 10px;
        }
        .product-info span {
            margin-right: 5px;
        }
        .login-button {
            background-color: #4CAF50;
            color: white;
            padding: 0.5rem 1rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .user-menu {
            display: flex;
            gap: 1rem;
            align-items: center;
        }
        .search-form {
            display: flex;
            gap: 0.5rem;
        }
        .search-input {
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .search-button {
            padding: 0.5rem 1rem;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="header">
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="login"><button class="login-button">Login</button></a>
        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <div class="user-menu">
                <a href="profile"><button class="login-button">Profile (${sessionScope.user})</button></a>
                <form action="logout" method="post" style="display: inline;">
                    <button type="submit" class="login-button">Logout</button>
                </form>
            </div>
        </c:if>
    </div>
    <form class="search-form" action="/" method="get">
        <input type="text" name="search" class="search-input" placeholder="Search products...">
        <button type="submit" class="search-button">Search</button>
    </form>
</div>

<div class="product-grid">

    <c:forEach items="${products}" var="product">
        <div class="product-card">
            <a href="product/${product.productId}" style="text-decoration: none; color: inherit;">
                <c:choose>
                    <c:when test="${product.productId == 1}">
                        <img class="product-image" src="images/panda.jpg" alt="Panda Bear">
                    </c:when>
                    <c:when test="${product.productId == 2}">
                        <img class="product-image" src="images/freddy.jpg" alt="Freddy Bear">
                    </c:when>
                </c:choose>
                <div class="product-info">
                    <h2>${product.productName}</h2>
                    <p><span>🏷️</span> ${product.productBrand}</p>
                    <p><span>🧸</span> ${product.material}</p>
                    <h3>${String.format("%,d", product.productPrice)}đ</h3>
                </div>
            </a>
        </div>
    </c:forEach>
    ```
</div>
</body>
</html>