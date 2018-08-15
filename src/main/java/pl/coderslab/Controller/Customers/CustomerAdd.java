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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CustomerAdd", urlPatterns = {"/addcustomer"})
public class CustomerAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("customerName");
        String lastName=request.getParameter("customerLastName");
        String birhtday=request.getParameter("birthday");
        int phone=Integer.parseInt(request.getParameter("phone"));


//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date date=null;
//            java.sql.Date sqlDate=null;
//        try {
//            date = sdf.parse(birhtday);
//            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        Customer customer=new Customer(name,lastName, birhtday,phone);
        CustomerDAO.saveToDB(customer);
        response.sendRedirect("/customers");



//        String startDate="01-02-2013";
//        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
//        java.util.Date date = sdf1.parse(startDate);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/customer/addCustomer.jsp").forward(request,response);
        }

    }
}
