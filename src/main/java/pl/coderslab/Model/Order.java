package pl.coderslab.Model;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderStart;
    private Date orderFinish;
    private int employeeID;
    private String issueScope;
    private String orderFixScope;
    private  String orderStatus;
    private int carID;
    private float orderCostEmpl;
    private float orderCostParts;


    //getters and setters
    public int getOrderId() {
        return orderId; }

    public void setOrderId(int orderId) {
        this.orderId = orderId;    }

    public Date getOrderStart() {
        return orderStart;    }

    public void setOrderStart(Date orderStart) {
        this.orderStart = orderStart;    }

    public Date getOrderFinish() {
        return orderFinish;    }

    public void setOrderFinish(Date orderFinish) {
        this.orderFinish = orderFinish;    }

    public int getEmployeeID() {
        return employeeID;    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;    }

    public String getIssueScope() {
        return issueScope;    }

    public void setIssueScope(String issueScope) {
        this.issueScope = issueScope;    }

    public String getOrderFixScope() {
        return orderFixScope;    }

    public void setOrderFixScope(String orderFixScope) {
        this.orderFixScope = orderFixScope;    }

    public String getOrderStatus() {
        return orderStatus;    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;    }

    public int getCarID() {
        return carID;    }

    public void setCarID(int carID) {
        this.carID = carID;    }

    public float getOrderCostEmpl() {
        return orderCostEmpl;
    }

    public void setOrderCostEmpl(float orderCostEmpl) {
        this.orderCostEmpl = orderCostEmpl;    }

    public float getOrderCostParts() {
        return orderCostParts;    }

    public void setOrderCostParts(float orderCostParts) {
        this.orderCostParts = orderCostParts;
    }

    //constructor

    public Order() {
    }

    //full constructor

    public Order(int orderId, Date orderStart, Date orderFinish,
                 int employeeID, String issueScope, String orderFixScope,
                 String orderStatus, int carID, float orderCostEmpl, float orderCostParts) {
        this.orderId = orderId;
        this.orderStart = orderStart;
        this.orderFinish = orderFinish;
        this.employeeID = employeeID;
        this.issueScope = issueScope;
        this.orderFixScope = orderFixScope;
        this.orderStatus = orderStatus;
        this.carID = carID;
        this.orderCostEmpl = orderCostEmpl;
        this.orderCostParts = orderCostParts;
    }
}
