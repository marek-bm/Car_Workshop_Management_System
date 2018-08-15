package pl.coderslab.Controller.Cars;

import pl.coderslab.DAO.CarDao;
import pl.coderslab.DAO.CustomerDAO;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarEdit", urlPatterns = {"/editcar"})
public class CarEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String model=request.getParameter("model");
        int prodYear=Integer.parseInt(request.getParameter("production"));
        String regsitry=request.getParameter("registry");
        int ownerID=Integer.parseInt(request.getParameter("owner"));
        String nextInsp=request.getParameter("inspection");


        Car car=new Car(id, model ,prodYear,regsitry,ownerID,nextInsp);
        CarDao.saveToDB(car);
        response.sendRedirect("/cars");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("action"));

        if(id>0){
            Car car=CarDao.loadByID(id);
            request.setAttribute("car", car);
            getServletContext().getRequestDispatcher("/META-INF/views/car/editCar.jsp").forward(request,response);
        }

    }
}
