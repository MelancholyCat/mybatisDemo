package xyz.lfans.service;

import org.junit.Test;
import xyz.lfans.bean.Department;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Atlantis
 * @create 2019-06-25-16:01
 */
public class DepartmentServiceImplTest {

    DepartmentService departmentService = new DepartmentServiceImpl();

    @Test
    public void addDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentName("呜呜");
        department.setLocal("555");
        departmentService.addDepartment(department);
        List<Department> departmentList = departmentService.searchDepartmentListByName("呜呜");
        System.out.println(departmentList);
    }

    @Test
    public void deleteDepartment() throws Exception {
        boolean b = departmentService.deleteDepartment(6);
        System.out.println(b);
    }

    @Test
    public void updateDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentId(5);
        department.setDepartmentName("呜0呜");
        department.setLocal("505");
        departmentService.updateDepartment(department);
        List<Department> departmentList = departmentService.searchDepartmentListByName("呜0呜");
        System.out.println(departmentList);
    }

    @Test
    public void searchDepartmentById() throws Exception {
        Department department = departmentService.searchDepartmentById(4);
        System.out.println(department);
    }

    @Test
    public void searchDepartmentListByName() throws Exception {
        List<Department> departmentList = departmentService.searchDepartmentListByName("号");
        System.out.println(departmentList);
    }

    @Test
    public void searchDepartmentList() throws Exception {
        List<Department> departmentList = departmentService.searchDepartmentList();
        System.out.println(departmentList);
    }
}