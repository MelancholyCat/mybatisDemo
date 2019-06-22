package xyz.lfans.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xyz.lfans.bean.Department;
import xyz.lfans.utils.SqlSessionFactoryUtil;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Atlantis
 * @create 2019-06-20-20:34
 */
public class DepartmentMapperTest {

    @Test
    public void insertDepartment() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();

        Department department = new Department();
        department.setDepartmentName("一二三");
        department.setLocal("203");

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        boolean b = departmentMapper.insertDepartment(department);
//        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteDepartmentById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        boolean b = departmentMapper.deleteDepartmentById(16);
        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateDepartmentById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = new Department();
        department.setDepartmentId(16);
        department.setDepartmentName("8san四六");
        department.setLocal("202");

        boolean b = departmentMapper.updateDepartment(department);
        System.out.println(b);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectDepartmentById() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = departmentMapper.selectDepartmentById(2);
        System.out.println(department);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectDepartmentByNameList() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departmentList = departmentMapper.selectDepartmentListByName("号");
        System.out.println(departmentList);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectDepartmentList() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departmentList = departmentMapper.selectDepartmentList();
        System.out.println(departmentList);
        sqlSession.commit();
        sqlSession.close();
    }

}