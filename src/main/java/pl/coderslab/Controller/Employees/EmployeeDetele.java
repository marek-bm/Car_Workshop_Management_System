package pl.coderslab.Controller.Employees;

import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeDetele", urlPatterns = {"/delemployee"})
public class EmployeeDetele extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            EmployeeDAO.delete(id);
            response.sendRedirect("/employees");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
