<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%@include file="bootstrap/header.jsp" %>
    <title>CarsStore Application</title>
</head>
<body>
    <center>
        <h3>
            <a href="/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Cars</a>
             
        </h3>
    </center>
    <div align="center">
        <c:if test="${car != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${car == null}">
            <form action="insert" method="post">
        </c:if>
        <table class="table table-striped table-bordered w-50 p-3" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${car != null}">
                        Edit Car
                    </c:if>
                    <c:if test="${car == null}">
                        Add New Car
                    </c:if>
                </h2>
            </caption>
                <c:if test="${car != null}">
                    <input type="hidden" name="id" value="<c:out value='${car.id}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${car.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Model: </th>
                <td>
                    <input type="text" name="model" size="45"
                            value="<c:out value='${car.model}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Year: </th>
                <td>
                    <input type="text" name="year" size="5"
                            value="<c:out value='${car.year}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>  
<%@include file="bootstrap/footer.jsp" %> 
</body>
</html>