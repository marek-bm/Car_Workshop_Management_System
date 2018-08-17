<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Car Workshop employees</h1>

<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        <form action="/addemployee" method="get">
            <button name="action" value="add" type="submit" >Add new employee</button>
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
                    <th>Phone</th>
                    <th>Note</th>
                    <th>Hourly rate</th>
                    <th>Note</th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>


                <c:forEach items="${employees}" var="emp">
                    <tr>
                        <td>${emp.emp_id}</td>
                        <td>${emp.emp_name}</td>
                        <td>${emp.emp_lastName}</td>
                        <td>${emp.emp_phone}</td>
                        <td>${emp.emp_note}</td>
                        <td>${emp.emp_hourlyRate}</td>
                        <td>

                            <form action="/editemployee" method="get">
                                <button name="action" value="${emp.emp_id}" type="submit" >Edit</button>
                            </form>


                        </td>

                        <td>

                            <form action="/delemployee" method="post">
                                <button name="action" value="${emp.emp_id}" type="submit" >Delete</button>
                            </form>

                        </td>


                        <td>

                            <form action="/empsummary" method="get">
                                <button name="action" value="${emp.emp_id}" type="submit" >Show summary</button>
                            </form>

                        </td>


                    </tr>
                </c:forEach>
            </table>


                    <%@include file="/META-INF/views/default/footer.jsp"%>