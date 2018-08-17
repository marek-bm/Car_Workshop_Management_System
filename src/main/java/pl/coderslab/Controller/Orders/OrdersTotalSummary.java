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

@WebServlet(name = "OrdersTotalSummary", urlPatterns = {"/orderstotal"})
public class OrdersTotalSummary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");


        List<Orders> orders=OrdersDAO.loadByDate(startDate,endDate);
        Float ordersValue=OrdersDAO.getOrdersValue(orders);

        request.setAttribute("orders", orders);
        request.setAttribute("startDate",startDate);
        request.setAttribute("endDate",endDate);
        request.setAttribute("totalValue", ordersValue);

        getServletContext().getRequestDispatcher("/META-INF/views/orders/OrdersTotalSummary.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/orders/OrdersTotalSummary.jsp").forward(request,response);

    }
}
