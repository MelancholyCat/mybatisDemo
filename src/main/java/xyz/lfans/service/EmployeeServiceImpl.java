package xyz.lfans.service;

import org.apache.ibatis.session.SqlSession;
import xyz.lfans.bean.Department;
import xyz.lfans.bean.Employee;
import xyz.lfans.mapper.DepartmentMapper;
import xyz.lfans.mapper.EmployeeMapper;
import xyz.lfans.utils.SqlSessionFactoryUtil;

import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-21-13:49
 */
public class EmployeeServiceImpl implements EmployeeService {

    public boolean addEmployee(Employee employee) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            b = employeeMapper.insertEmployee(employee);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return false;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return b;
        }
    }

    public boolean deleteEmployeeById(Integer employeeId) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            b = employeeMapper.deleteEmployeeById(employeeId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return false;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return b;
        }
    }

    public boolean updateEmployee(Employee employee) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            b = employeeMapper.updateEmployee(employee);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return false;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return b;
        }
    }

    public Employee searchEmployeeByEmployeeId(Integer employeeId) {
        Employee employee = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            employee = employeeMapper.selectEmployeeById(employeeId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return employee;
        }
    }

    public List<Employee> searchEmployeeListByName(String employeeName) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        List<Employee> employeeList = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            employeeList = employeeMapper.selectEmployeeListByEmployee(employee);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return employeeList;
        }
    }

    public List<Employee> searchEmployeeList() {
        List<Employee> employeeList = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            employeeList = employeeMapper.selectEmployeeList();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return employeeList;
        }
    }

    public List<Employee> searchEmployeeByDepartmentId(Integer departmentId) {
        Employee employee = new Employee();
        employee.setEmployeeId(departmentId);
        List<Employee> employeeList = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        try {
            employeeList = employeeMapper.selectEmployeeListByEmployee(employee);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return employeeList;
        }
    }
}
