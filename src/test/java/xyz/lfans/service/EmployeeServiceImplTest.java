package xyz.lfans.service;

import org.junit.Test;
import xyz.lfans.bean.Employee;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Atlantis
 * @create 2019-06-21-15:10
 */
public class EmployeeServiceImplTest {

    EmployeeService employeeService = new EmployeeServiceImpl();
    @Test
    public void addEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setBirthday("2000-06-01");
        employee.setWages(5555.0);
        employee.setDepartmentId(5);
        employee.setEmployeeName("新雇员");

        boolean b = employeeService.addEmployee(employee);
        System.out.println(b);

    }

    @Test
    public void deleteEmployeeById() throws Exception {
        boolean b = employeeService.deleteEmployeeById(7);
        System.out.println(b);
    }

    @Test
    public void updateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(7);
        employee.setBirthday("2002-10-11");
        employee.setWages(4955.0);
        employee.setDepartmentId(4);
        employee.setEmployeeName("员外");
        boolean b = employeeService.updateEmployee(employee);
        System.out.println(b);
    }

    @Test
    public void searchEmployeeByEmployeeId() throws Exception {
        Employee employee = employeeService.searchEmployeeByEmployeeId(7);
        System.out.println(employee);
    }

    @Test
    public void searchEmployeeListByName() throws Exception {
        List<Employee> employeeList = employeeService.searchEmployeeListByName("4");
        System.out.println(employeeList);
    }

    @Test
    public void searchEmployeeList() throws Exception {
        List<Employee> employeeList = employeeService.searchEmployeeList();
        System.out.println(employeeList);
    }

    @Test
    public void searchEmployeeByDepartmentId() throws Exception {
        List<Employee> employeeList = employeeService.searchEmployeeByDepartmentId(4);
        System.out.println(employeeList);
    }
}