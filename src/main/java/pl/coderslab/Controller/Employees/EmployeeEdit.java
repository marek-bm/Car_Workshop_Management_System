package pl.coderslab.Controller.Employees;

import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeEdit", urlPatterns = {"/editemployee"})
public class EmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("employeeName");
        String lastName=request.getParameter("employeeLastName");
        int phone=Integer.parseInt(request.getParameter("phone"));
        String note=request.getParameter("note");
        Float hourlyRate=Float.parseFloat(request.getParameter("cost"));

        Employee employee=new Employee(id,name,lastName,phone,note,hourlyRate);
        EmployeeDAO.saveToDB(employee);

        response.sendRedirect("/employees");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            Employee emp=EmployeeDAO.loadById(id);
            request.setAttribute("emp", emp);
            getServletContext().getRequestDispatcher("/META-INF/views/employee/editEmployee.jsp").forward(request,response);
        }


    }
}
