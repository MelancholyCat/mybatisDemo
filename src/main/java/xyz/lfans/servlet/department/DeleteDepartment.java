package xyz.lfans.servlet.department;

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
 * @create 2019-06-24-18:27
 */
public class DeleteDepartment extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("departmentId"));
        try {
            if (departmentService.deleteDepartment(id)){
                req.setAttribute("msg","删除成功");
                req.getRequestDispatcher("SearchDepartmentList").forward(req,resp);
            }else {
//                提示删除失败
                req.setAttribute("msg","删除失败");
                req.getRequestDispatcher("SearchDepartmentList").forward(req,resp);
            }
        } catch (Exception e) {
//            提示删除失败
            req.setAttribute("msg","删除失败");
            e.printStackTrace();
            req.getRequestDispatcher("SearchDepartmentList").forward(req,resp);
        }
    }
}
