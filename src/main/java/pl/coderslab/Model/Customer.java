package pl.coderslab.Model;

import java.util.Date;

public class Customer {
    private int customerId=0;
    private String customerName;
    private String customerLastName;
    private String customerBirthday;
    private  int customerPhone;


    //getters and setters
    public int getCustomerId() {
        return customerId; }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;    }

    public String getCustomerName() {
        return customerName;   }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;    }

    public String getCustomerLastName() {
        return customerLastName;    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;    }

    public String getCustomerBirthday() {
        return  customerBirthday;    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;    }

    public int getCustomerPhone() {
        return customerPhone;    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    //constructor default
    public Customer() {
    }

    //consturctor full
    public Customer(int customerId, String customerName, String customerLastName, String customerBirthday, int customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerBirthday = customerBirthday;
        this.customerPhone = customerPhone;
    }


    //consturctor without id
    public Customer( String customerName, String customerLastName, String customerBirthday, int customerPhone) {

        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerBirthday = customerBirthday;
        this.customerPhone = customerPhone;
    }



    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName='" + customerName + '\'' + ", customerLastName='" + customerLastName + '\'' + ", customerBirthday=" + customerBirthday + ", customerPhone=" + customerPhone + '}';
    }
}
