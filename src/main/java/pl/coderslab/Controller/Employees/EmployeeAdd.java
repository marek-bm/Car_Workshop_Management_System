package pl.coderslab.Controller.Employees;

import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeAdd", urlPatterns = {"/addemployee"})
public class EmployeeAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("employeeName");
        String lastName=request.getParameter("employeeLastName");
        int phone=Integer.parseInt(request.getParameter("phone"));
        String note=request.getParameter("note");
        Float hourlyRate=Float.parseFloat(request.getParameter("cost"));

        Employee employee=new Employee(name,lastName,phone,note,hourlyRate);
        EmployeeDAO.saveToDB(employee);

        response.sendRedirect("/employees");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/employee/addEmployee.jsp").forward(request,response);
        }

    }
}
