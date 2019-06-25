package xyz.lfans.servlet.employee;

import xyz.lfans.bean.Employee;
import xyz.lfans.service.EmployeeService;
import xyz.lfans.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Atlantis
 * @create 2019-06-25-16:15
 */
public class DeleteEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("employeeId"));
        try {
            if (employeeService.deleteEmployeeById(id)){
                req.setAttribute("msg","删除成功");
                req.getRequestDispatcher("SearchEmpList").forward(req,resp);
            }else {
//                提示删除失败
                req.setAttribute("msg","删除失败");
                req.getRequestDispatcher("SearchEmpList").forward(req,resp);
            }
        } catch (Exception e) {
//            提示删除失败
            req.setAttribute("msg","删除失败");
            e.printStackTrace();
            req.getRequestDispatcher("SearchEmpList").forward(req,resp);
        }
    }
}
