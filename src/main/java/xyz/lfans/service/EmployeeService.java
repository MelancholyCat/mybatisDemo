package xyz.lfans.service;

import xyz.lfans.bean.Employee;

import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-21-12:39
 */
public interface EmployeeService {

    public boolean addEmployee(Employee employee) throws Exception;

    public boolean deleteEmployeeById(Integer employeeId) throws Exception;

    public boolean updateEmployee(Employee employee) throws Exception;

    public Employee searchEmployeeByEmployeeId(Integer employeeId) throws Exception;

    public List<Employee> searchEmployeeListByName(String employeeName) throws Exception;

    public List<Employee> searchEmployeeList() throws Exception;

    public List<Employee> searchEmployeeByDepartmentId(Integer departmentId) throws Exception;

}
