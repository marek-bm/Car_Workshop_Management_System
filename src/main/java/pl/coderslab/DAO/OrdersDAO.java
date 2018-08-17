package pl.coderslab.DAO;

import pl.coderslab.Connection.DbManager;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Customer;
import pl.coderslab.Model.Employee;
import pl.coderslab.Model.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {


    public static void saveToDB(Orders order){

        if(order.getOrderId()==0){
            addToDB(order);

        }
        else {
            updateDB(order);
        }
    }

    private static void updateDB(Orders order) {
        try{
            String sql = "UPDATE orders SET " +
                    "order_id=?, order_start=?, order_finish=?, order_employeeID=?," +
                    "order_issueScope=?, order_fixScope=?, order_status=?, " +
                    "order_carID=?, order_costEmpl=?, order_costParts=?, hours_used=? where order_id = ?";

            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, order.getOrderId());
            pstm.setString(2, order.getStartDate());
            pstm.setString(3, order.getEndDate());
            pstm.setInt(4, order.getEmployeeID());
            pstm.setString(5, order.getIssueDesription());
            pstm.setString(6,order.getFixScope());
            pstm.setString(7,order.getStatus());
            pstm.setInt(8, order.getCarId());
            pstm.setDouble(9, order.getEmployeeCost());
            pstm.setDouble(10, order.getPartsCost());
            pstm.setDouble(11, order.getHoursUsed());
            pstm.setInt(12, order.getOrderId());
            pstm.executeUpdate();


        }catch (SQLException e){e.printStackTrace();}
    }

    private static void addToDB(Orders order) {
        try {
            String sql="INSERT into orders  VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            pstm.setString(1, null);
            pstm.setString(2, order.getStartDate());
            pstm.setString(3, order.getEndDate());
            pstm.setInt(4, order.getEmployeeID());
            pstm.setString(5, order.getIssueDesription());
            pstm.setString(6,order.getFixScope());
            pstm.setString(7,order.getStatus());
            pstm.setInt(8, order.getCarId());
            pstm.setDouble(9, order.getEmployeeCost());
            pstm.setDouble(10, order.getPartsCost());
            pstm.setDouble(11, order.getHoursUsed());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderId(rs.getInt(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Orders order){
        String sql="DELETE FROM orders WHERE order_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, order.getOrderId() );
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Orders loadByID(int id){
        String sql="SELECT * FROM orders where order_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            if(rs.next()){
                Orders order=getFromResultSet(rs);
                return order;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Orders> loadAll(){
        String sql="SELECT * FROM orders";
        try {
            ArrayList<Orders> orders=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Orders o=getFromResultSet(rs);
                orders.add(o);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Orders getFromResultSet(ResultSet rs) throws SQLException {
        Orders order=new Orders();
        order.setOrderId(rs.getInt(1));
        order.setStartDate(rs.getString(2));
        order.setEndDate(rs.getString(3));
        order.setEmployeeID(rs.getInt(4));
        order.setIssueDesription(rs.getString(5));
        order.setFixScope(rs.getString(6));
        order.setStatus(rs.getString(7));
        order.setCarId(rs.getInt(8));
        order.setEmployeeCost(rs.getFloat(9));
        order.setPartsCost(rs.getFloat(10));
        order.setHoursUsed(rs.getFloat(11));

        return order;
    }


    public static Object[] getOrderSummary(Orders order){
        String sql="SELECT * FROM orders WHERE order_carID=?";


//        String sql="SELECT * FROM car \n" +
//                "JOIN orders ON orders.order_carID=car.car_id \n" +
//                "JOIN employee ON employee.emp_id=orders.order_employeeID WHERE car.car_id=?";
        try {

            //list containing [0]order, [1]customer, [2]car, [3]employee
            Object[] itmes=new Object[4];

//            List<Object> summary=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,order.getCarId());
            ResultSet rs=pstm.executeQuery();

            Employee employee=new Employee();
            Car car=new Car();
            Customer customer=new Customer();

            itmes[0]=order;


            if(rs.next()){

                car=CarDao.loadByID(rs.getInt(8));
                customer=CustomerDAO.loadById(car.getCarOwnerId());
                employee=EmployeeDAO.loadById(rs.getInt("order_employeeID"));

                itmes[1]=customer;
                itmes[2]=car;
                itmes[3]=employee;

            }
            return itmes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static ArrayList<Orders> loadByEmployee(int employeeID, String startDate, String finishDate){
        String sql="SELECT * FROM orders WHERE orders.order_employeeID=? AND order_finish>? AND order_finish<?";
        try {
            ArrayList<Orders> orders=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,employeeID);
            pstm.setString(2, startDate);
            pstm.setString(3, finishDate);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Orders o=getFromResultSet(rs);
                orders.add(o);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Orders> loadByDate(String startingDate, String finishDate){
        String sql="SELECT * FROM orders WHERE order_finish>? AND order_finish<?";
        try {
            ArrayList<Orders> orders=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, startingDate);
            pstm.setString(2, finishDate);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Orders o=getFromResultSet(rs);
                orders.add(o);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Float getOrdersValue(List<Orders> orders){
        float totalValue=0;
        for(int i=0; i<orders.size(); i++){
            Orders o=orders.get(i);
            Float value=o.getEmployeeCost()*o.getHoursUsed()+o.getPartsCost();
            totalValue+=value;
        }
        return totalValue;
    }



}








