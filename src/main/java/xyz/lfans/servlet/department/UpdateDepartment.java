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

/**
 * @author Atlantis
 * @create 2019-06-24-20:15
 */
public class UpdateDepartment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        Integer departmentId = Integer.valueOf(req.getParameter("departmentId"));
        String departmentName = req.getParameter("departmentName");
        String local = req.getParameter("local");
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setLocal(local);
        if (departmentId != null ||departmentName != null || !departmentName.equals("") || local != null
                || !local.equals("")) {
            try {
                if (departmentService.updateDepartment(department)) {
                    req.setAttribute("msg", "更新成功");
                    req.getRequestDispatcher("SearchDepartmentList").forward(req, resp);
                }
            } catch (Exception e) {
//                提示添加失败
                req.setAttribute("msg", "更新失败");
                e.printStackTrace();
                req.getRequestDispatcher("SearchDepartmentList").forward(req, resp);
            }
        } else {
//            提示输入信息不完整
            req.setAttribute("msg", "更新失败，原因为输入信息不完整");
            req.getRequestDispatcher("SearchDepartmentList").forward(req, resp);
        }
    }
}
