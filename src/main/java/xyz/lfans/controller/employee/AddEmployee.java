package xyz.lfans.controller.employee;

import xyz.lfans.bean.Employee;
import xyz.lfans.service.EmployeeService;
import xyz.lfans.service.EmployeeServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Atlantis
 * @create 2019-06-22-15:11
 */
public class AddEmployee extends HttpServlet {
    EmployeeService employeeService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        String type = req.getParameter("type");
        /*
            Integer employeeId;
            String birthday;
            Double wages;
            Integer departmentId;
            String employeeName;
        */

        String birthday = req.getParameter("birthday");
        Double wages = Double.valueOf(req.getParameter("Double wages"));
        Integer departmentId = Integer.valueOf(req.getParameter("departmentId"));
        String employeeName = req.getParameter("employeeName");
        Employee employee =new Employee();
        employee.setBirthday(birthday);
        employee.setWages(wages);
        employee.setDepartmentId(departmentId);
        employee.setEmployeeName(employeeName);

        try {
            employeeService.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String handleString(String s){
        try {
            byte bb[] = s.getBytes("UTF-8");
            s = new String(bb);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
