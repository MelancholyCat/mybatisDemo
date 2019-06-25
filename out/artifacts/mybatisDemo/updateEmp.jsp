<%@ page import="xyz.lfans.bean.Employee" %>
<%@ page import="xyz.lfans.service.EmployeeService" %>
<%@ page import="xyz.lfans.service.EmployeeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2019-06-25
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>更新雇员</title>
    <meta charset="UTF-8">
</head>
<body bgcolor="#00bfff">
<table border="2">
    <tr>
        <th>更新雇员信息</th>
    </tr>
    <%
        Integer employeeId = Integer.valueOf(request.getParameter("employee"));
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.searchEmployeeByEmployeeId(employeeId);
    %>
    <form action="UpdateEmp" method="post">
        <tr>
            <td>雇员编号</td>
            <td><input type="text" name="employeeId" value=<%=employee.getEmployeeId()%>></td>
        </tr>
        <tr>
            <td>雇员姓名</td>
            <td><input type="text" name="employeeName" value=<%=employee.getEmployeeName()%>></td>
        </tr>
        <tr>
            <td>雇员生日</td>
            <td><input type="text" name="birthday" value=<%=employee.getBirthday()%>></td>
        </tr>
        <tr>
            <td>雇员工资</td>
            <td><input type="text" name="wages" value=<%=employee.getWages()%>></td>
        </tr>
        <tr>
            <td>所在部门</td>
            <td><input type="text" name="departmentId" value=<%=employee.getDepartmentId()%>></td>
        </tr>
</table>
<input type="submit" name="g" value="提交">
</form>
</body>
</html>
