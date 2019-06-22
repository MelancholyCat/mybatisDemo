package xyz.lfans.mapper;

import xyz.lfans.bean.Department;

import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-20-19:43
 */
public interface DepartmentMapper {

    /**
     * 增
     * @param department
     * @return
     * @throws Exception
     */
    public boolean insertDepartment(Department department) throws Exception;

    /**
     * 删
     * @param departmentId
     * @return
     * @throws Exception
     */
    public boolean deleteDepartmentById(Integer departmentId) throws Exception;

    /**
     * 改
     * @param department
     * @return
     * @throws Exception
     */
    public boolean updateDepartment(Department department) throws Exception;

    /**
     * 查
     * @param departmentId 部门编号
     * @return 若无结果，值为null
     * @throws Exception
     */
    public Department selectDepartmentById(Integer departmentId) throws Exception;

    /**
     * 查 模糊查询
     * @param departmentName 部门名
     * @return 包含指定字符的所有部门 若无结果，值为null
     * @throws Exception
     */
    public List<Department> selectDepartmentListByName(String departmentName) throws Exception;

    /**
     * 查 所有部门
     * @return
     * @throws Exception
     */
    public List<Department> selectDepartmentList() throws Exception;

}
