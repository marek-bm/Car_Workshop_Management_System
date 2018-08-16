package pl.coderslab.Controller.Orders;

import pl.coderslab.DAO.CarDao;
import pl.coderslab.DAO.CustomerDAO;
import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.DAO.OrdersDAO;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Customer;
import pl.coderslab.Model.Employee;
import pl.coderslab.Model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Currency;

@WebServlet(name = "OrderShowDetails", urlPatterns = {"/orderdetails"})
public class OrderShowDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=Integer.parseInt(request.getParameter("action"));


        if(orderId>0){
            Orders order=OrdersDAO.loadByID(orderId);
            Car car=CarDao.loadByID(order.getCarId());
            Customer customer=CustomerDAO.loadById(car.getCarOwnerId());
            Employee employee=EmployeeDAO.loadById(order.getEmployeeID());

//            Object[] items=OrdersDAO.getOrderSummary(order);
//            items[0]=order;
//            items[1]=customer;
//            items[2]=car;
//            items[3]=employee;

            request.setAttribute("order", order);
            request.setAttribute("customer", customer);
            request.setAttribute("car", car);
            request.setAttribute("employee", employee);
        }

        getServletContext().getRequestDispatcher("/META-INF/views/orders/OrderDetails.jsp").forward(request,response);


    }
}
