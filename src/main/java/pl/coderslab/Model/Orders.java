package pl.coderslab.Model;

import pl.coderslab.DAO.EmployeeDAO;

public class Orders {
    private int orderId=0;
    private String startDate;
    private String endDate;
    private int employeeID;
    private String issueDesription;
    private String fixScope;
    private String status;
    private int carId;
    private float employeeCost;
    private float partsCost;
    private float hoursUsed;


    //getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getIssueDesription() {
        return issueDesription;
    }

    public void setIssueDesription(String issueDesription) {
        this.issueDesription = issueDesription;
    }

    public String getFixScope() {
        return fixScope;
    }

    public void setFixScope(String fixScope) {
        this.fixScope = fixScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public float getEmployeeCost() {
        int employeeId=this.employeeID;
        Employee e=EmployeeDAO.loadById(employeeId);
        return e.getEmp_hourlyRate();
    }

    public void setEmployeeCost(float employeeCost) {
        this.employeeCost = employeeCost;
    }

    public float getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(float partsCost) {
        this.partsCost = partsCost;
    }


    public float getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(float hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    //constructor 1
    public Orders() {
    }

    //cosnturctor 2
    public Orders(String startDate, String endDate, int employeeID,
                  String issueDesription, String fixScope, String status,
                  int carId, float employeeCost, float partsCost, float hoursUsed) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeID = employeeID;
        this.issueDesription = issueDesription;
        this.fixScope = fixScope;
        this.status = status;
        this.carId = carId;
        this.employeeCost = employeeCost;
        this.partsCost = partsCost;
        this.hoursUsed=hoursUsed;
    }

    //constructor3
    public Orders(int orderId, String startDate, String endDate,
                  int employeeID, String issueDesription, String fixScope,
                  String status, int carId, float employeeCost, float partsCost, float hoursUsed) {
        this.orderId = orderId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeID = employeeID;
        this.issueDesription = issueDesription;
        this.fixScope = fixScope;
        this.status = status;
        this.carId = carId;
        this.employeeCost = employeeCost;
        this.partsCost = partsCost;
        this.hoursUsed=hoursUsed;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", startDate='" + startDate + '\'' + ", endDate='" + endDate + '\'' + ", employeeID=" + employeeID + ", issueDesription='" + issueDesription + '\'' + ", fixScope='" + fixScope + '\'' + ", status='" + status + '\'' + ", carId=" + carId + ", employeeCost=" + employeeCost + ", partsCost=" + partsCost + ", hoursUsed=" + hoursUsed + '}';
    }
}
