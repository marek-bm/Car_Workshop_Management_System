<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/META-INF/views/default/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Cars belonging to Customer ${id} </h1>

<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        <form action="/addcar" method="get">
            <button name="action" value="add" type="submit" >Add new car</button>
        </form>

    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>

                <tr>
                    <th>Car Id </th>
                    <th>Model </th>
                    <th>Production Year</th>
                    <th>Register Number</th>

                    <th>Next Inspection</th>

                    <th></th>
                    <th></th>


                </tr>

                </thead>


                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.carId}</td>
                        <td>${car.carModel}</td>
                        <td>${car.carYear}</td>
                        <td>${car.carRegisterNumb}</td>

                        <td>${car.car_nextInsp}</td>

                        <td>

                            <form action="/editcar" method="get">
                                <button name="action" value="${car.carId}" type="submit" >Edit</button>
                            </form>

                        </td>

                        <td>

                            <form action="/delcar" method="post">
                                <button name="action" value="${car.carId}" type="submit" >Delete</button>
                            </form>

                        </td>


                    </tr>
                </c:forEach>
            </table>


<%@include file="/META-INF/views/default/footer.jsp"%>