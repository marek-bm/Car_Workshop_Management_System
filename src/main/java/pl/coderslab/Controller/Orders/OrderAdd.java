package pl.coderslab.Controller.Orders;

import pl.coderslab.DAO.CarDao;
import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.DAO.OrdersDAO;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Employee;
import pl.coderslab.Model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderAdd", urlPatterns = {"/addorder"})
public class OrderAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateStart=request.getParameter("dateStart");
        int employeeId=Integer.parseInt(request.getParameter("employeeID"));
        String status=request.getParameter("status");
        int carId=Integer.parseInt(request.getParameter("carId"));

        //create object in data base
        Orders newOrder=new Orders();
        newOrder.setStartDate(dateStart);
        newOrder.setEmployeeID(employeeId);
        newOrder.setStatus(status);
        newOrder.setCarId(carId);
        OrdersDAO.saveToDB(newOrder);
//
//        //load car and employee
//        Employee employee=EmployeeDAO.loadById(employeeId);
//        Car car=CarDao.loadByID(carId);
//
//        //pass object to JSP
//        request.setAttribute("order", newOrder);
//        request.setAttribute("employee", employee);
//        request.setAttribute("car", car);
//
//        getServletContext().getRequestDispatcher("/META-INF/views/employee/addEmployee.jsp").forward(request,response);
//
        response.sendRedirect("/orders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/orders/OrderAdd.jsp").forward(request,response);
        }

    }
}
