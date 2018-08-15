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
import java.util.List;

@WebServlet(name = "CarController", urlPatterns = {"/cars"})
public class CarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars=CarDao.loadAll();
        request.setAttribute("cars", cars);

        getServletContext().getRequestDispatcher("/META-INF/views/car/car.jsp").forward(request,response);


    }
}
