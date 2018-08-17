<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<form action="/empsworkinghours" method="post">
    Select begining date for your search querry<br>
    <input type="date" name="startDate" value="${startDate}" /><br>
    <input type="hidden" name="empId" value="${emp.emp_id}"/>

    <br>

    Select end date for your search querry<br>
    <input type="date" name="endDate" value="${endDate}" /><br>
    <input type="submit" name="submit" value="Submit"><br>
</form><br>



<table class="table table-bordered" width="100%" cellspacing="0">
    <h4> Report timeframe: ${startDate} - ${endDate} </h4>
    <thead>
    <tr>
        <th> Name, Last Name  </th>
        <th> Working hours </th>

    </tr>

    </thead>

    <c:forEach items="${map}" var="item">

    <tr>
        <td>${item.key.emp_name} ${item.key.emp_lastName}</td>
        <td>${item.value}</td>
    </tr>
    </c:forEach>
    <tr>




<%@include file="/META-INF/views/default/footer.jsp"%>