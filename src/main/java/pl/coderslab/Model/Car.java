package pl.coderslab.Model;

import java.util.Date;

public class Car {
    private int carId;
    private String carModel;
    private  int carYear;
    private String carRegisterNumb;
    private int carOwnerId;
    private Date car_nextInsp;


    //getters and setters
    public int getCarId() {
        return carId; }

    public void setCarId(int carId) {
        this.carId = carId; }

    public String getCarModel() {
        return carModel;    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;    }

    public int getCarYear() {
        return carYear;    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;    }

    public String getCarRegisterNumb() {
        return carRegisterNumb;    }

    public void setCarRegisterNumb(String carRegisterNumb) {
        this.carRegisterNumb = carRegisterNumb;    }

    public int getCarOwnerId() {
        return carOwnerId;    }

    public void setCarOwnerId(int carOwnerId) {
        this.carOwnerId = carOwnerId;    }

    public java.sql.Date getCar_nextInsp() {
        return car_nextInsp;    }

    public void setCar_nextInsp(Date car_nextInsp) {
        this.car_nextInsp = car_nextInsp;    }

    //default constructor
    public Car() {}

    //full constructor
    public Car(int carId, String carModel, int carYear, String carRegisterNumb, int carOwnerId, Date car_nextInsp) {
        this.carId = carId;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carRegisterNumb = carRegisterNumb;
        this.carOwnerId = carOwnerId;
        this.car_nextInsp = car_nextInsp;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carModel='" + carModel + '\'' + ", carYear=" + carYear + ", carRegisterNumb='" + carRegisterNumb + '\'' + ", carOwnerId='" + carOwnerId + '\'' + ", car_nextInsp='" + car_nextInsp + '\'' + '}';
    }
}
