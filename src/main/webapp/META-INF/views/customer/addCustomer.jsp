<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>

<h1>Add new User</h1>

<form action="/addcustomer", method="post">


    <fieldset>
        <input type="text" name="customerName" placeholder="First Name"/><br>
        <input type="text" name="customerLastName" placeholder="Last Name"/><br>
        <input type="date" name="birthday" placeholder="Date of birth"/><br>
        <input type="tel" name="phone" placeholder="Phone number"/><br>
        <input type="submit" value="Submit">
    </fieldset>

</form>




<%@include file="/META-INF/views/default/footer.jsp"%>