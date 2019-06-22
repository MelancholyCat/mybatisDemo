package xyz.lfans.service;

import xyz.lfans.bean.Department;

import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-21-12:39
 */
public interface DepartmentService {

    public boolean addDepartment(Department department) throws Exception;

    public boolean deleteDepartment(Integer id) throws Exception;

    public boolean updateDepartment(Department department) throws Exception;

    public Department searchDepartmentById(Integer id) throws Exception;

    public List<Department> searchDepartmentListByName(String departmentName) throws Exception;

    public List<Department> searchDepartmentList() throws Exception;
}
