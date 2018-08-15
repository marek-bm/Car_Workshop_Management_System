package pl.coderslab.DAO;

import pl.coderslab.Connection.DbManager;
import pl.coderslab.Model.Car;
import pl.coderslab.Model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO{

    public static void saveToDB(Employee employee){

        if(employee.getEmp_id()==0){
            addToDB(employee);

        }
        else {
            updateDB(employee);
        }
    }



    private static void updateDB(Employee employee) {
        try{
            String sql = "UPDATE employee SET emp_name=?, emp_lastName=?, emp_phone=?, emp_note=?, emp_costPlnHr=? where emp_id = ?";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, employee.getEmp_name());
            pstm.setString(2, employee.getEmp_lastName());
            pstm.setInt(3, employee.getEmp_phone());
            pstm.setString(4, employee.getEmp_note());
            pstm.setDouble(5, employee.getEmp_costPlnHr());
            pstm.setInt(6,employee.getEmp_id());
            pstm.executeUpdate();

        }catch (SQLException e){e.printStackTrace();}
    }

    private static void addToDB(Employee employee) {
        try {
            String sql="INSERT into employee (emp_name, emp_lastName, emp_phone, emp_note,emp_costPlnHr) VALUES (?,?,?,?,?)";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);

            pstm.setString(1, employee.getEmp_name());
            pstm.setString(2, employee.getEmp_lastName());
            pstm.setInt(3, employee.getEmp_phone());
            pstm.setString(4, employee.getEmp_note());
            pstm.setDouble(5, employee.getEmp_costPlnHr());

            pstm.executeUpdate();


            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                employee.setEmp_id(rs.getInt(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        String sql="DELETE FROM employee WHERE emp_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee loadById(int id){
        String sql="SELECT * FROM employee where emp_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            if(rs.next()){
                Employee employee=getEmployeeFromResultSet(rs);
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static ArrayList<Employee> loadAll(){
        String sql="SELECT * FROM employee";
        try {
            ArrayList<Employee> employees=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Employee employee=getEmployeeFromResultSet(rs);
                employees.add(employee);
            }
            return employees;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee employee=new Employee();
        employee.setEmp_id(rs.getInt(1));
        employee.setEmp_name(rs.getString(2));
        employee.setEmp_lastName(rs.getString(3));
        employee.setEmp_phone(rs.getInt(4));
        employee.setEmp_note(rs.getString(5));
        employee.setEmp_costPlnHr(rs.getFloat(6));
        return employee;
    }

}


