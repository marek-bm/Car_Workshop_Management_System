package pl.coderslab.DAO;

import pl.coderslab.Connection.DbManager;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                    "order_carID=?, order_costEmpl=?, order_costParts=? where order_id = ?";

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
            pstm.executeUpdate();


        }catch (SQLException e){e.printStackTrace();}
    }

    private static void addToDB(Orders order) {
        try {
            String sql="INSERT into orders  VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);

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
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                order.setCarId(rs.getInt(1));
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

    public static Car loadByID(int id){
        String sql="SELECT * FROM orders where order_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            if(rs.next()){
                Orders order=getFromResultSet(rs);

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
        order.setEmployeeID(rs.getInt(8));
        order.setEmployeeCost(rs.getFloat(9));
        order.setPartsCost(rs.getFloat(10));

        return order;
    }

}








