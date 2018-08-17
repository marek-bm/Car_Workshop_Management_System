package pl.coderslab.Controller.Orders;

import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.DAO.OrdersDAO;
import pl.coderslab.Model.Employee;
import pl.coderslab.Model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeSummary", urlPatterns = {"/empsummary"})
public class EmployeeSummary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");
        int empID=Integer.parseInt(request.getParameter("empId"));


        List<Orders> orders=OrdersDAO.loadByEmployee(empID,startDate, endDate);
        Employee employee=EmployeeDAO.loadById(empID);
        Float ordersValue=OrdersDAO.getOrdersValue(orders);

        request.setAttribute("emp", employee);
        request.setAttribute("orders", orders);
        request.setAttribute("startDate",startDate);
        request.setAttribute("endDate",endDate);
        request.setAttribute("totalValue", ordersValue);

        getServletContext().getRequestDispatcher("/META-INF/views/orders/generateReport.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            Employee employee=EmployeeDAO.loadById(id);
            request.setAttribute("emp", employee);

            getServletContext().getRequestDispatcher("/META-INF/views/orders/generateReport.jsp").forward(request,response);
        }

    }
}
