package xyz.lfans.servlet.department;

import xyz.lfans.bean.Department;
import xyz.lfans.service.DepartmentService;
import xyz.lfans.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-24-20:20
 */
public class SearchDepartmentList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departmentList =null;
        try {
            departmentList = departmentService.searchDepartmentList();
            req.setAttribute("departmentList",departmentList);
            req.setAttribute("msg","查找成功");
            req.getRequestDispatcher("findDep.jsp").forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("departmentList",departmentList);
            req.setAttribute("msg","查找失败");
            e.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}
