package xyz.lfans.servlet.employee;

import xyz.lfans.bean.Employee;
import xyz.lfans.service.EmployeeService;
import xyz.lfans.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Atlantis
 * @create 2019-06-25-16:17
 */
public class SearchEmpList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList =null;
        try {
            employeeList = employeeService.searchEmployeeList();
            req.setAttribute("employeeList",employeeList);
            req.setAttribute("msg","查找成功");
            req.getRequestDispatcher("findEmp.jsp").forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("employeeList",employeeList);
            req.setAttribute("msg","查找失败");
            e.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}
