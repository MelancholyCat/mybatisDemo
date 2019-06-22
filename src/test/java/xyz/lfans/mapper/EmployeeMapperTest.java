package xyz.lfans.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.lfans.bean.Employee;
import xyz.lfans.utils.SqlSessionFactoryUtil;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Atlantis
 * @create 2019-06-21-11:04
 */
public class EmployeeMapperTest {

    @Test
    public void insertEmployee() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();

        Employee employee = new Employee();
//        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat1.parse("2000-06-01");
        employee.setBirthday("2000-06-01");
        employee.setWages(5555.0);
        employee.setDepartmentId(4);
        employee.setEmployeeName("四号雇员");


        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        boolean b = employeeMapper.insertEmployee(employee);
//        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteEmployeeById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        boolean b = employeeMapper.deleteEmployeeById(5);
        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEmployeeById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmployeeId(6);
//        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat1.parse("1999-06-01");
        employee.setBirthday("1999-06-01");
        employee.setWages(5055.5);
        employee.setDepartmentId(4);
        employee.setEmployeeName("404客服");

        boolean b = employeeMapper.updateEmployee(employee);
        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectEmployeeById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.selectEmployeeById(1);
        System.out.println(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectEmployeeByNameList() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmployeeName("7");
        employee.setDepartmentId(2);
        List<Employee> employeeList = employeeMapper.selectEmployeeListByEmployee(employee);
        System.out.println(employeeList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectEmployeeList() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = employeeMapper.selectEmployeeList();
        System.out.println(employeeList);
        sqlSession.commit();
        sqlSession.close();
    }

}