package xyz.lfans.bean;

/**
 * 雇员
 * @author Atlantis
 * @create 2019-06-20-19:35
 */
public class Employee {
    private Integer employeeId;
    private String birthday;
    private Double wages;
    private Integer departmentId;
    private String employeeName;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", birthday=" + birthday +
                ", wages=" + wages +
                ", departmentId=" + departmentId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getWages() {
        return wages;
    }

    public void setWages(Double wages) {
        this.wages = wages;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(Integer employeeId, String birthday, Double wages, Integer departmentId, String employeeName) {
        this.employeeId = employeeId;
        this.birthday = birthday;
        this.wages = wages;
        this.departmentId = departmentId;
        this.employeeName = employeeName;
    }

    public Employee() {
    }
}
