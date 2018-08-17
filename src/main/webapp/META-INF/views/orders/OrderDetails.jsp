<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Repair report Order #${order.orderId} ${car.carModel}</h1>

<div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

        <thead>
        <tr>
            <th> CUSTOMER DETAILS </th>
            <th> CAR DATA </th>
            <th></th>

        </tr>

        </thead>


<%-----------------------Customer data--------------------------------%>
        <tr>
            <td>
                <ul>
                    <li>Customer ID: ${customer.customerId}</li>
                    <li>Name: ${customer.customerName}  ${customer.customerLastName} </li>
                    <li>Phone: ${customer.customerPhone}</li>
                </ul>

            </td>

<%------------------------Car data-------------------------------------%>

            <td>
                <ul>
                    <li>Car ID ${car.carId}</li>
                    <li>${car.carModel}</li>
                    <li>${car.carRegisterNumb}</li>
                </ul>

            </td>

            <%--Empty cell--%>
            <td></td>
        </tr>

        <tr>
            <td>
                <form action="/editcustomer" method="get">
                <button name="action" value="${customer.customerId}" type="submit" >Edit Customer data</button>
                </form>
            </td>

            <td>
                <form action="/editcar" method="get">
                <button name="action" value="${car.carId}" type="submit" >Edit car data</button></form>
            </td>

            <td></td>
        </tr>
    </table>




<%-----------------------------------Submitted issue---------------------------------%>

<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

    <thead>
    <tr>
        <th> SUBMITTED ISSUE </th>
        <th></th>

    </tr>
    <tr>
        <td>
            ${order.issueDesription}
        </td>
        <td></td>
    </tr>


</table>

<br>
<%-----------------------------------Submitted issue---------------------------------%>

<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th> SCOPE OF REPAIR: </th>
        <th></th>
    </tr>
    </thead>


    <tr>
        <td>${order.fixScope}</td>

        <td></td>
    </tr>

    <tr>
        <td>
            <form action="/editorder" method="get">
                <button name="action" value="${order.orderId}" type="submit" >Edit order</button>
            </form>

        </td>
    </tr>

</table>

<br>




        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

            <thead>
            <tr>
                <th> FINANCIAL SUMMARY: </th>
                <th></th>

            </tr>

            </thead>

            <tr>
                <td>
                    Manpower
                    <ul>
                        <li>Hourly Rate: ${employee.emp_hourlyRate} PLN/hr </li>
                        <li>Repair time: ${order.hoursUsed} hr</li>
                        <li>Labour cost: ${employee.emp_hourlyRate * order.hoursUsed} PLN </li>

                    </ul>

                </td>

            </tr>
            <tr>
                <td>
                    Spare parts:
                    <ul>
                        <li>${order.partsCost} PLN</li>
                    </ul>
                </td>

            </tr>

            <tr>
                <td>
                    <h4>TOTAL REPAIR COST: ${employee.emp_hourlyRate* order.hoursUsed+ order.partsCost} PLN </h4>

                </td>
            </tr>

        </table>




    <form action="/editorder" method="get">
        <button name="action" value="${order.orderId}" type="submit" >Edit order</button>
    </form>


</div>


<%@include file="/META-INF/views/default/footer.jsp"%>