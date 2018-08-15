package pl.coderslab.Controller.Customers;

import pl.coderslab.DAO.CustomerDAO;
import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Customer;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = {"/customers"})
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers=CustomerDAO.loadAll();
        request.setAttribute("customers", customers);

        getServletContext().getRequestDispatcher("/META-INF/views/customer/customer.jsp").forward(request,response);


    }
}
