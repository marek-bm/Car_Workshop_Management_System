<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>


<h1>Edit car # ${car.carId} ${car.carModel}</h1>

<form action="/editcar", method="post">

    <table>
        <tr>
            <td>Car ID:</td>
            <td><input type="hidden" name="id" value="${car.carId}"/><br></td>
        </tr>

        <tr>
             <td>Car Model</td>
            <td><input type="text" name="model" value="${car.carModel}"/><br></td>
        </tr>

        <tr>
            <td>Production Year</td>
            <td><input type="number" name="production" value="${car.carYear}"/><br></td>
        </tr>

        <tr>
            <td> Registry Number </td>
            <td><input type="text" name="registry" value="${car.carRegisterNumb}"/><br></td>
        </tr>


        <tr>
            <td> Car owner ID </td>
            <td><input type="number" name="owner" value="${car.carOwnerId}"/><br></td>
        </tr>

        <tr>
            <td> Next Inspection </td>
            <td><input type="date" name="inspection" value="${car.car_nextInsp}"/><br></td>
        </tr>


    </table>
    <input type="submit" name="submit" value="Submit">

</form>




<%@include file="/META-INF/views/default/footer.jsp"%>