<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>


<h1>Add new car to the workshop</h1>

<form action="/addcar", method="post">


    <table>

        <tr>
            <td>Model</td>
            <td><input type="text" name="carModel"/><br></td>
        </tr>

        <tr>
            <td>Production year</td>
            <td><input type="number" name="carYear"/><br></td>
        </tr>

        <tr>
            <td> Register number </td>
            <td><input type="text" name="carRegisterNumb"/><br></td>
        </tr>


        <tr>
            <td> Owner ID</td>
            <td><input type="number" name="carOwnerId" /><br></td>
        </tr>

        <tr>
            <td> Next inspection</td>
            <td><input type="date" name="car_nextInsp" /><br></td>
        </tr>



    </table>
    <input type="submit" name="submit" value="Submit">

</form>




<%@include file="/META-INF/views/default/footer.jsp"%>