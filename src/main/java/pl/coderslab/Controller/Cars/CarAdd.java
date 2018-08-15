package pl.coderslab.Controller.Cars;

import pl.coderslab.DAO.CarDao;
import pl.coderslab.DAO.EmployeeDAO;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarAdd", urlPatterns = {"/addcar"})
public class CarAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model=request.getParameter("carModel");
        int prodYear=Integer.parseInt(request.getParameter("carYear"));
        String regisrty=request.getParameter("carRegisterNumb");
        int ownerID=Integer.parseInt(request.getParameter("carOwnerId"));
        String nextInsp=request.getParameter("car_nextInsp");



        Car car=new Car(model,prodYear,regisrty,ownerID,nextInsp);
        CarDao.saveToDB(car);

        response.sendRedirect("/cars");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/car/addCar.jsp").forward(request,response);
        }

    }
}
