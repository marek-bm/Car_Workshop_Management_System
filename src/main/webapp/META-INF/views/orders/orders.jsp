<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Orders</h1>

<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        <form action="/addorder" method="get">
            <button name="action" value="add" type="submit" >Register new Order</button>
        </form>

    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th> Id </th>
                    <th> Start Date </th>
                    <th> End Date </th>
                    <th> Status </th>
                    <th> Car ID </th>
                    <th> Employee ID </th>


                    <th></th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>

                <c:forEach items="${orders}" var="o">

                    <tr>
                        <td>${o.orderId}</td>
                        <td>${o.startDate}</td>
                        <td>${o.endDate}</td>
                        <td>${o.status}</td>
                        <td>${o.carId}</td>
                        <td>${o.employeeID}</td>




                        <td>

                            <form action="/editorder" method="get">
                                <button name="action" value="${o.orderId}" type="submit" >Edit</button>
                            </form>

                        </td>

                        <td>

                            <form action="/orderdetails" method="get">
                                <button name="action" value="${o.orderId}" type="submit" >Show details</button>
                            </form>

                        </td>


                        <td>

                            <form action="/delemployee" method="post">
                                <button name="action" value="${o.orderId}" type="submit" >Delete</button>
                            </form>

                        </td>

                    </tr>
                </c:forEach>
            </table>


<%@include file="/META-INF/views/default/footer.jsp"%>