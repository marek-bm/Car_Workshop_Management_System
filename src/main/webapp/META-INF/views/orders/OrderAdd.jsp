<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>


<h1>Add new car to the workshop</h1>

<form action="/addorder", method="post">



    <table>

        <tr>
            <td>Start date</td>
            <td><input type="date" name="dateStart"/><br></td>
        </tr>

        <tr>
            <td>Employee ID</td>
            <td><input type="number" name="employeeID"/><br></td>
        </tr>

        <tr>
            <td> Status </td>
            <td><input type="text" name="status"/><br></td>
        </tr>


        <tr>
            <td> Car ID</td>
            <td><input type="number" name="carId" /><br></td>
        </tr>



    </table>
    <input type="submit" name="submit" value="Submit">

</form>




<%@include file="/META-INF/views/default/footer.jsp"%>