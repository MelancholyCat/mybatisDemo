package xyz.lfans.mapper;

import xyz.lfans.bean.Employee;

import java.util.List;

/**
 * EmployeeMapper接口
 * @author Atlantis
 * @create 2019-06-20-19:42
 */
public interface EmployeeMapper {

    /**
     * 增
     * @param Employee
     * @return
     * @throws Exception
     */
    public boolean insertEmployee(Employee Employee) throws Exception;

    /**
     * 删
     * @param EmployeeId
     * @return
     * @throws Exception
     */
    public boolean deleteEmployeeById(Integer EmployeeId) throws Exception;

    /**
     * 改
     * @param Employee
     * @return
     * @throws Exception
     */
    public boolean updateEmployee(Employee Employee) throws Exception;

    /**
     * 查
     * @param EmployeeId 雇员编号
     * @return 若无结果，值为null
     * @throws Exception
     */
    public Employee selectEmployeeById(Integer EmployeeId) throws Exception;

    /**
     * 查
     * @param Employee 若name不为空，则模糊查询，返回名字中包含指定字符的雇员信息；
     *                 若name为空，部门id不为空，则查询在指定部门工作的所有雇员
     * @return 若无结果，值为null
     * @throws Exception
     */
    public List<Employee> selectEmployeeListByEmployee(Employee Employee) throws Exception;

    /**
     * 查 所有雇员
     * @return 若无结果，值为null
     * @throws Exception
     */
    public List<Employee> selectEmployeeList() throws Exception;
}
