package pl.coderslab.DAO;

import pl.coderslab.Connection.DbManager;
import pl.coderslab.Model.Customer;
import pl.coderslab.Model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CustomerDAO {

    private int customerId;
    private String customerName;
    private String customerLastName;
    private Date customerBirthday;
    private  int customerPhone;


    public static void saveToDB(Customer customer){

        if(customer.getCustomerId()==0){
            addToDB(customer);

        }
        else {
            updateDB(customer);
        }
    }



    private static void updateDB(Customer customer) {
        try{
            String sql = "UPDATE customer SET cust_name=?, cust_lastName=?, cust_birthday=?, cust_phone=? where  cust_id = ?";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, customer.getCustomerName());
            pstm.setString(2, customer.getCustomerLastName());
            pstm.setString(3,customer.getCustomerBirthday() );
            pstm.setInt(4, customer.getCustomerPhone());
            pstm.setInt(5,customer.getCustomerId());
            pstm.executeUpdate();

        }catch (SQLException e){e.printStackTrace();}
    }


    private static void addToDB(Customer customer) {
        try {
            String sql="INSERT into customer (cust_name, cust_lastName, cust_birthday, cust_phone) VALUES (?,?,?,?)";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);

            pstm.setString(1, customer.getCustomerName());
            pstm.setString(2, customer.getCustomerLastName());
            pstm.setString(3,customer.getCustomerBirthday() );
            pstm.setInt(4, customer.getCustomerPhone());
            pstm.executeUpdate();


            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                customer.setCustomerId(rs.getInt(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        String sql="DELETE FROM customer WHERE cust_id=?";
        deleteById(id, sql);
    }

    static void deleteById(int id, String sql) {
        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Customer loadById(int id){
        String sql="SELECT * FROM customer where cust_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            if(rs.next()){
                Customer customer=getCustomerFromResultSet(rs);
                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static ArrayList<Customer> loadAll(){
        String sql="SELECT * FROM customer";
        try {
            ArrayList<Customer> customers=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Customer customer=getCustomerFromResultSet(rs);
                customers.add(customer);
            }
            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer customer=new Customer();
        customer.setCustomerId(rs.getInt(1));
        customer.setCustomerName(rs.getString(2));
        customer.setCustomerLastName(rs.getString(3));
        customer.setCustomerBirthday(rs.getString(4));
        customer.setCustomerPhone(rs.getInt(5));

        return customer;
    }

}





