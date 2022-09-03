<%-- 
    Document   : products
    Created on : Aug 30, 2022, 3:36:04 PM
    Author     : TaiNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">QUAN LY SAN PHAM</h1>

<div class="container">
    <c:url value="/admin/products" var="action"/>
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">${errMsg}</div>
    </c:if>
    <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="name" id="name" placeholder="name" name="name" />
            <label for="name">Ten san pham</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" path="price" id="price" placeholder="price" name="price" />
            <label for="price">Gia san pham</label>
        </div>
        <div class="form-floating">
            <form:select path="category" class="form-select" id="sel1" name="sellist">
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </form:select>
            <label for="sel1" class="form-label">Danh muc</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="file" class="form-control" path="file" id="file" placeholder="file" name="file" />
            <label for="file">Anh san pham</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <input type="submit" value="Them san pham" class="btn btn-danger" />
        </div>
    </form:form>
    <div class="spinner-border text-warning" id="myLoading"></div>
    <table class="table">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th></th>
        </tr>
        <tbody id="mainId">

        </tbody>
    </table>
</div>


<script src="<c:url value="/js/product.js" />"></script>
<script>
    <c:url value="/api/products" var="u" />
    window.onload = function () {
        loadAdminProduct("${u}")
    }
</script>