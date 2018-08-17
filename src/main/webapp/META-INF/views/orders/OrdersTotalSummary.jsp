<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Financial summary</h1>


<form action="/orderstotal" method="post">
    Select begining date for your search querry<br>
    <input type="date" name="startDate" value="${startDate}" /><br>
    <input type="hidden" name="empId" value="${emp.emp_id}"/>

<br>

    Select end date for your search querry<br>
    <input type="date" name="endDate" value="${endDate}" /><br>
    <input type="submit" name="submit" value="Submit"><br>
</form><br>



<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

            <h4> PLN ${totalValue} generated in ${startDate} - ${endDate} period</h4><br>

            List of transactions:

            <thead>
            <tr>
                <th> Order Id </th>
                <th> Start Date </th>
                <th> End Date </th>
                <th> Employee Id </th>
                <th> Status </th>
                <th> Car ID </th>
                <th> Value </th>

            </tr>

            </thead>

            <c:forEach items="${orders}" var="o">

                <tr>
                    <td>${o.orderId}</td>
                    <td>${o.startDate}</td>
                    <td>${o.endDate}</td>
                    <td> ${o.employeeID}</td>
                    <td>${o.status}</td>
                    <td>${o.carId}</td>
                    <td>PLN ${emp.emp_hourlyRate*o.hoursUsed+o.partsCost}</td>
                </tr>
            </c:forEach>
            <tr>

                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>TOTAL: </td>
                <td>PLN ${totalValue}</td>

            </tr>

        </table>






<%@include file="/META-INF/views/default/footer.jsp"%>