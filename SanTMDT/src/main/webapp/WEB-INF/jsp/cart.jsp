<%-- 
    Document   : cart
    Created on : Sep 2, 2022, 7:49:25 PM
    Author     : TaiNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">Gio Hang</h1>

<c:if test="${carts == null}">
    <h4 class="text-danger">khong co san pham nao trong gio</h4>
</c:if>

<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Ma San Pham</th>
            <th>Ten San Pham</th>
            <th>Don Gia</th>
            <th>So Luong</th>
            <th></th>
        </tr>
        <c:forEach items="${carts}" var="c" >
        <tr id="product${c.productId}">
            <td>${c.productId}</td>
            <td>${c.productName}</td>
            <td>${c.price} VND </td>
            <td>
                <div class="form-group">
                    <input type="numder" onblur="updateCart(this, ${c.productId})" value="${c.quantity}" class="form-control"/>
                </div>
            </td>
            <td>
                <input type="button" value="Xoa" onclick="deleteCart(${c.productId})" class="btn btn-danger"/>
            </td>
        </tr>
        </c:forEach>
    </table>
    <div>
        <h4>Tong tien hoa don: <span id="amountCart"> ${cartStats.amount} </span>VND</h4>
    </div>
        <input type="button" onclick="pay()" value="Thanh Toan" class="btn btn-danger"/>
</c:if>