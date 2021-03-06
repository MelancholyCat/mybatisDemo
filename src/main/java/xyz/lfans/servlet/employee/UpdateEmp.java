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
 * @create 2019-06-25-16:18
 */
public class UpdateEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer employeeId = Integer.valueOf(req.getParameter("employeeId"));
        String employeeName = req.getParameter("employeeName");
        String birthday = req.getParameter("birthday");
        Double wages = Double.valueOf(req.getParameter("wages"));
        Integer departmentId = Integer.valueOf(req.getParameter("departmentId"));
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setWages(wages);
        employee.setBirthday(birthday);
        employee.setDepartmentId(departmentId);
        EmployeeService employeeService = new EmployeeServiceImpl();
        if (employee.getEmployeeId() != null && employee.getEmployeeName() != null && !employee.getEmployeeName().equals("")
                && employee.getWages() != null && employee.getDepartmentId() != null
                && employee.getBirthday() != null && !employee.getBirthday().equals("")) {
            try {
                if (employeeService.updateEmployee(employee)) {
                    req.setAttribute("msg", "更新成功");
                    req.getRequestDispatcher("SearchEmpList").forward(req, resp);
                }
            } catch (Exception e) {
//                提示添加失败
                req.setAttribute("msg", "更新失败");
                e.printStackTrace();
                req.getRequestDispatcher("SearchEmpList").forward(req, resp);
            }
        } else {
//            提示输入信息不完整
            req.setAttribute("msg", "更新失败，原因为输入信息不完整");
            req.getRequestDispatcher("SearchEmpList").forward(req, resp);
        }
    }
}
