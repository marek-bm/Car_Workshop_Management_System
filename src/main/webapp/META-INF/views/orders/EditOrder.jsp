<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>

<h1>Edit Order # ${order.orderId}</h1>

<form action="/editorder", method="post">


    <table>
        <tr>
            <td><input type="hidden" name="id" value="${order.orderId}"/></td>
        </tr>

        <tr>
            <td>Repair start date</td>
            <td><input type="date" name="dateStart" value="${order.startDate}"/></td>
        </tr>


        <tr>
            <td>Repair end date</td>
            <td><input type="date" name="endDate" value="${order.endDate}"/></td>
        </tr>

        <tr>
            <td> Employee ID </td>
            <td><input type="number" name="empID" value="${order.employeeID}"/></td>
        </tr>

        <tr>
            <td> Repair status </td>
            <td><input type="text" name="status" value="${order.status}"/></td>
        </tr>

        <tr>
            <td> Car ID </td>
            <td><input type="number" name="carID" value="${order.carId}"/></td>
        </tr>

        <%--Employee cost will be taken from Employee class object loaded by ID--%>

        <tr>
            <td> Parts cost </td>
            <td><input type="number" step="0.01" name="parts" value="${order.partsCost}"/></td>
        </tr>

        <tr>
            <td> Billed hours </td>
            <td><input type="number" step="0.25" name="hours" value="${order.hoursUsed}"/></td>

        </tr>

    </table></table>

-------<br>

    Issue description<br>
    <textarea name="issue" cols="50" rows="2">${order.issueDesription}</textarea><br>



    Scope of repair:<br>
    <textarea name="repairScope" cols="50" rows="2">${order.fixScope}</textarea><br>




    <input type="submit" name="submit" value="Submit">


</form>


