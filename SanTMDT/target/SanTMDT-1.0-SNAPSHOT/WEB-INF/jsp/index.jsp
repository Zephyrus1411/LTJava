<%-- 
    Document   : index
    Created on : Aug 29, 2022, 3:43:28 PM
    Author     : TaiNguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(productCounter/8)}" var="i">
        <c:url value="/" var="c">
            <c:param value="${i}" name="page"  />
        </c:url>
        <li class="page-item"><a class="page-link" href="${c}">${i}</a></li>
        </c:forEach>
</ul>

<div class="row">
    <c:forEach items="${products}" var="p">
        <div class="col-md-3 col-xs-12" style="padding: 5px;">
            <div class="card">
                <img class="card-img-top" class="img-fluid" src="${p.image}" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}" /> VND
                    </p>
                    <a href="<c:url value="/products/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
                    <a href="#" class="btn btn-primary" onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Dat Hang</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(productCounter/pageSize)}" var="i">

        <c:url value="/" var="u">
            <c:param name="page" value="${i}"></c:param>
        </c:url>
        <li class="page-item"><a class="page-link" href="${u}">${i}</a></li>
        </c:forEach>
</ul>
