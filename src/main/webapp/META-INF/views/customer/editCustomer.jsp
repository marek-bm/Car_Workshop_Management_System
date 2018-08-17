<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>


<h1>Edit Customer # ${customer.customerId} ${customer.customerName} ${customer.customerLastName}</h1>

<form action="/editcustomer", method="post">

    <table>
        <tr>
            <td>Consumer ID:</td>
            <td><input type="hidden" name="id" value="${customer.customerId}"/><br></td>
        </tr>

        <tr>
            <td>Name</td>
            <td><input type="text" name="customerName" value="${customer.customerName}"/><br></td>
        </tr>

        <tr>
            <td>Last Name</td>
            <td><input type="text" name="customerLastName" value="${customer.customerLastName}"/><br></td>
        </tr>

        <tr>
            <td> Phone </td>
            <td><input type="tel" name="phone" value="${customer.customerPhone}"/><br></td>
        </tr>


        <tr>
            <td> Date of birth </td>
            <td><input type="date" name="birthday" value="${customer.customerBirthday}"/><br></td>
        </tr>



    </table>
    <input type="submit" name="submit" value="Submit">

</form>




<%@include file="/META-INF/views/default/footer.jsp"%>