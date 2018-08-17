<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>

    <h1>Edit Employee # ${emp.emp_id} ${emp.emp_name} ${emp.emp_lastName}</h1>

    <form action="/editemployee", method="post">

        <table>
            <tr>
                <td>User ID:</td>
                <td><input type="hidden" name="id" value="${emp.emp_id}"/><br></td>
            </tr>

            <tr>
                <td>Name</td>
                <td><input type="text" name="employeeName" value="${emp.emp_name}"/><br></td>
            </tr>

            <tr>
                <td>Last Name</td>
                <td><input type="text" name="employeeLastName" value="${emp.emp_lastName}"/><br></td>
            </tr>

            <tr>
                <td> Phone </td>
                <td><input type="tel" name="phone" value="${emp.emp_phone}"/><br></td>
            </tr>

            <tr>
                <td> Employee note </td>
                <td><input type="text" name="note" value="${emp.emp_note}"/><br></td>
            </tr>

            <tr>
                <td> Hourly rate </td>
                <td><input type="number" step=".01" name="cost" value="${emp.emp_hourlyRate}"/><br></td>
            </tr>



        </table>
        <input type="submit" name="submit" value="Submit">


    </form>




<%@include file="/META-INF/views/default/footer.jsp"%>