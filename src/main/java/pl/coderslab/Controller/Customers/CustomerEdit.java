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

@WebServlet(name = "CustomerEdit", urlPatterns = {"/editcustomer"})
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("customerName");
        String lastName=request.getParameter("customerLastName");
        String birhtday=request.getParameter("birthday");
        int phone=Integer.parseInt(request.getParameter("phone"));

        Customer customer=new Customer(id,name,lastName, birhtday,phone);
        CustomerDAO.saveToDB(customer);
        response.sendRedirect("/customers");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            Customer customer=CustomerDAO.loadById(id);
            request.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/META-INF/views/customer/editCustomer.jsp").forward(request,response);
        }

    }
}
