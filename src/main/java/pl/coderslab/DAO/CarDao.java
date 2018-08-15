package pl.coderslab.DAO;

import pl.coderslab.Connection.DbManager;
import pl.coderslab.Model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarDao {


    public static void saveToDB(Car car){

        if(car.getCarId()==0){
            addToDB(car);

        }
        else {
            updateDB(car);
        }
    }


    private static void updateDB(Car car) {
        try{
            String sql = "UPDATE car SET car_model=?, car_year=?, car_registerNumb=?, car_ownerId=?,car_nextInsp=? where car_id = ?";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, car.getCarModel());
            pstm.setInt(2, car.getCarYear());
            pstm.setString(3, car.getCarRegisterNumb());
            pstm.setInt(4, car.getCarOwnerId());
            pstm.setString(5, car.getCar_nextInsp());
            pstm.setInt(6,car.getCarId());
            pstm.executeUpdate();

        }catch (SQLException e){e.printStackTrace();}
    }

    private static void addToDB(Car car) {
        try {
            String sql="INSERT into car (car_model, car_year, car_registerNumb, car_ownerId,car_nextInsp) VALUES (?,?,?,?,?)";
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);

            pstm.setString(1, car.getCarModel());
            pstm.setInt(2, car.getCarYear());
            pstm.setString(3, car.getCarRegisterNumb());
            pstm.setInt(4, car.getCarOwnerId());
            pstm.setString(5, car.getCar_nextInsp());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                car.setCarId(rs.getInt(1));
            }
                        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Car car){
        String sql="DELETE FROM car WHERE car_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, car.getCarId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Car loadByID(int id){
        String sql="SELECT * FROM car where car_id=?";

        try {
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            if(rs.next()){
                Car newCar=getCarFromResultSet(rs);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Car> loadAll(){
        String sql="SELECT * FROM car";
        try {
            ArrayList<Car> cars=new ArrayList<>();
            PreparedStatement pstm=DbManager.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Car newCar=getCarFromResultSet(rs);
                cars.add(newCar);
            }
            return cars;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Car getCarFromResultSet(ResultSet rs) throws SQLException {
        Car newCar=new Car();
        newCar.setCarId(rs.getInt(1));
        newCar.setCarModel(rs.getString(2));
        newCar.setCarYear(rs.getInt(3));
        newCar.setCarRegisterNumb(rs.getString(4));
        newCar.setCarOwnerId(rs.getInt(5));
        newCar.setCar_nextInsp(rs.getString(6));
        return newCar;
    }


}






