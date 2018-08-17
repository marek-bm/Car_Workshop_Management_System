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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrdersGetWorkingHours", urlPatterns = {"/empsworkinghours"})
public class OrdersGetWorkingHours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get time frame for search
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        //load all employees to iterate
        List<Employee> employees=EmployeeDAO.loadAll();

        //load all orders in requested time frame
        List<Orders> orders=OrdersDAO.loadByDate(startDate,endDate);

        Map<Employee, Double> map=new HashMap<>();

        for(int i=0; i<employees.size(); i++){

            Employee emp=employees.get(i);
            int empID=emp.getEmp_id();

            Double totalHours=0.0;

            for(int j=0; j<orders.size(); j++){
                int orderEmpID=orders.get(j).getEmployeeID();
                if(orderEmpID==empID){
                    double hours=orders.get(j).getHoursUsed();
                    totalHours+=hours;
                }
            }

            map.put(emp,totalHours);
        }

        //return values to jsp
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("map", map);
//        request.setAttribute("employees", employees);
//        request.setAttribute("orders", orders);


        getServletContext().getRequestDispatcher("/META-INF/views/orders/OrdersGetWorkingHours.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/orders/OrdersGetWorkingHours.jsp").forward(request,response);

    }
}
