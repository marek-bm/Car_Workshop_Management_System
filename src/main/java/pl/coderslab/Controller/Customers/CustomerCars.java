package pl.coderslab.Controller.Customers;

import pl.coderslab.DAO.CustomerDAO;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerCars", urlPatterns = {"/showcar"})
public class CustomerCars extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));
        if(id>0){
            List<Car> cars=CustomerDAO.loadUserCars(id);
            request.setAttribute("cars", cars);
            request.setAttribute("id", id);
            getServletContext().getRequestDispatcher("/META-INF/views/customer/customerCars.jsp").forward(request,response);
        }

    }
}
