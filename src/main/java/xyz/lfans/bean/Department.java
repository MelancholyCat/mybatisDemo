package xyz.lfans.bean;

/**
 * 部门
 * @author Atlantis
 * @create 2019-06-20-19:35
 */
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String local;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Department(int departmentId, String departmentName, String local) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.local = local;
    }

    public Department() {
    }
}
