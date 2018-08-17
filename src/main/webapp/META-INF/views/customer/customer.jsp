<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Car Workshop customers</h1>

<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        <form action="/addcustomer" method="get">
            <button name="action" value="add" type="submit" >Create new customer</button>
        </form>

    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id </th>
                    <th>Name </th>
                    <th>Last Name</th>
                    <th>Birthday</th>
                    <th>Phone</th>

                    <th></th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>

                <c:forEach items="${customers}" var="cust">
                    <tr>
                        <td>${cust.customerId}</td>
                        <td>${cust.customerName}</td>
                        <td>${cust.customerLastName}</td>
                        <td>${cust.customerBirthday}</td>
                        <td>${cust.customerPhone}</td>

                        <td>

                            <form action="/editcustomer" method="get">
                                <button name="action" value="${cust.customerId}" type="submit" >Edit</button>
                            </form>


                        </td>

                        <td>

                            <form action="/delcustomer" method="post">
                                <button name="action" value="${cust.customerId}" type="submit" >Delete</button>
                            </form>

                        </td>

                        <td>

                            <form action="/showcar" method="get">
                                <button name="action" value="${cust.customerId}" type="submit" >Car Details</button>
                            </form>

                        </td>


                    </tr>
                </c:forEach>
            </table>


<%@include file="/META-INF/views/default/footer.jsp"%>