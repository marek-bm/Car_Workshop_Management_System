<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>

<h1>Add new User</h1>

<form action="/addemployee", method="post">

    <fieldset>
        <input type="text" name="employeeName" placeholder="First Name"/><br>
        <input type="text" name="employeeLastName" placeholder="Last Name"/><br>
        <input type="tel" name="phone" placeholder="Phone number"/><br>
        <input type="text" name="note" placeholder="Note"/><br>
        <input type="number" step=".01" name="cost" placeholder="Hourly rate"/>PLN/hr<br>
        <input type="submit" value="Submit">
    </fieldset>

</form>


<%@include file="/META-INF/views/default/footer.jsp"%>