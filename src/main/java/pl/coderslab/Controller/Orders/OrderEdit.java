package pl.coderslab.Controller.Orders;

import pl.coderslab.DAO.CustomerDAO;
import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.DAO.OrdersDAO;
import pl.coderslab.Model.Customer;
import pl.coderslab.Model.Employee;
import pl.coderslab.Model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderEdit", urlPatterns = {"/editorder"})
public class OrderEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=Integer.parseInt(request.getParameter("id"));
        String startDate=request.getParameter("dateStart");
        String endDate=request.getParameter("endDate");

        if(endDate.equals("")|| endDate.equals(" "))
            endDate=null;

        int empID=Integer.parseInt(request.getParameter("empID"));

        Employee emp=EmployeeDAO.loadById(empID);

        float hourlyRate=emp.getEmp_hourlyRate();
        String description=request.getParameter("issue");
        String repair=request.getParameter("repairScope");
        String status=request.getParameter("status");
        int carId= Integer.parseInt(request.getParameter("carID"));
        float partsCost=Float.parseFloat(request.getParameter("parts"));
        float billedHours=Float.parseFloat(request.getParameter("hours"));




        Orders order=new Orders(orderId,startDate,endDate,empID,description,repair,status,carId,hourlyRate,partsCost,billedHours);
        OrdersDAO.saveToDB(order);
        response.sendRedirect("/orderdetails?action="+orderId);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            Orders order=OrdersDAO.loadByID(id);
            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher("/META-INF/views/orders/EditOrder.jsp").forward(request,response);
        }

    }
}
