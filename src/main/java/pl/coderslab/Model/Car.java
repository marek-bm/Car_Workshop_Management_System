package pl.coderslab.Model;

public class Car {
    private int carId;
    private String carModel;
    private  int carYear;
    private String carRegisterNumb;
    private String carOwnerId;
    private String car_nextInsp;


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

    public String getCarOwnerId() {
        return carOwnerId;    }

    public void setCarOwnerId(String carOwnerId) {
        this.carOwnerId = carOwnerId;    }

    public String getCar_nextInsp() {
        return car_nextInsp;    }

    public void setCar_nextInsp(String car_nextInsp) {
        this.car_nextInsp = car_nextInsp;    }

    //default constructor
    public Car() {}

    //full constructor
    public Car(int carId, String carModel, int carYear, String carRegisterNumb, String carOwnerId, String car_nextInsp) {
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
