package pl.coderslab.Model;

public class Employee {
    private int emp_id;
    private String emp_name;
    private String emp_lastName;
    private  int emp_phone;
    private String emp_note;
    private Float emp_costPlnHr;

    //getters and setters
    public int getEmp_id() { return emp_id; }

    public void setEmp_id(int emp_id) { this.emp_id = emp_id; }

    public String getEmp_name() { return emp_name; }

    public void setEmp_name(String emp_name) { this.emp_name = emp_name; }

    public String getEmp_lastName() { return emp_lastName; }

    public void setEmp_lastName(String emp_lastName) {
        this.emp_lastName = emp_lastName; }

    public int getEmp_phone() {
        return emp_phone; }

    public void setEmp_phone(int emp_phone) {
        this.emp_phone = emp_phone; }

    public String getEmp_note() {
        return emp_note; }

    public void setEmp_note(String emp_note) {
        this.emp_note = emp_note; }

    public Float getEmp_costPlnHr() {
        return emp_costPlnHr; }

    public void setEmp_costPlnHr(Float emp_costPlnHr) {
        this.emp_costPlnHr = emp_costPlnHr; }


    //constructor default
    public Employee() {
    }

    //constructor full
    public Employee(int emp_id, String emp_name, String emp_lastName, int emp_phone, String emp_note, Float emp_costPlnHr) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_lastName = emp_lastName;
        this.emp_phone = emp_phone;
        this.emp_note = emp_note;
        this.emp_costPlnHr = emp_costPlnHr;
    }

    @Override
    public String toString() {
        return "Employee{" + "emp_id=" + emp_id + ", emp_name='" + emp_name + '\'' + ", emp_lastName='" + emp_lastName + '\'' + ", emp_phone=" + emp_phone + ", emp_note='" + emp_note + '\'' + ", emp_costPlnHr=" + emp_costPlnHr + '}';
    }
}
