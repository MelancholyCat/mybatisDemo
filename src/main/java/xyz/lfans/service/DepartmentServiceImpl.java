package xyz.lfans.service;

import org.apache.ibatis.session.SqlSession;
import xyz.lfans.bean.Department;
import xyz.lfans.mapper.DepartmentMapper;
import xyz.lfans.utils.SqlSessionFactoryUtil;

import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-21-15:39
 */
public class DepartmentServiceImpl implements DepartmentService {
    public boolean addDepartment(Department department) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            b = departmentMapper.insertDepartment(department);
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

    public boolean deleteDepartment(Integer id) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            b = departmentMapper.deleteDepartmentById(id);
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

    public boolean updateDepartment(Department department) throws Exception {
        boolean b = false;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            b = departmentMapper.updateDepartment(department);
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

    public Department searchDepartmentById(Integer id) throws Exception {
        Department department = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            department = departmentMapper.selectDepartmentById(id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return department;
        }
    }

    public List<Department> searchDepartmentListByName(String departmentName) throws Exception {
        List<Department> departmentList = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            departmentList = departmentMapper.selectDepartmentListByName(departmentName);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return departmentList;
        }
    }

    public List<Department> searchDepartmentList() throws Exception {
        List<Department> departmentList = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        try {
            departmentList = departmentMapper.selectDepartmentList();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return null;
        } finally {
            if (sqlSession != null)
                sqlSession.close();
            return departmentList;
        }
    }
}
