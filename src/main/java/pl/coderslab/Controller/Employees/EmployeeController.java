package pl.coderslab.Controller.Employees;

import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = {"/employees"})
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> allEmployees=EmployeeDAO.loadAll();
        request.setAttribute("employees", allEmployees);

        getServletContext().getRequestDispatcher("/META-INF/views/employee/employee.jsp").forward(request,response);

    }
}
