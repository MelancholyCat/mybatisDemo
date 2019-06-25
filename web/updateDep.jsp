<%@ page import="xyz.lfans.service.DepartmentService" %>
<%@ page import="xyz.lfans.service.DepartmentServiceImpl" %>
<%@ page import="xyz.lfans.bean.Department" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2019-06-25
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>更新部门</title>
    <meta charset="UTF-8">
</head>
<body bgcolor="#00bfff">
<table border="2">
    <tr>
        <th>更新雇员信息</th>
    </tr>
    <%
        Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = departmentService.searchDepartmentById(departmentId);
    %>
    <form action="UpdateDepartment" method="post">
        <tr>
            <td>部门编号</td>
            <td><input type="text" name="departmentId" value=<%=department.getDepartmentId()%>></td>
        </tr>
        <tr>
            <td>部门姓名</td>
            <td><input type="text" name="departmentName" value=<%=department.getDepartmentName()%>></td>
        </tr>
        <tr>
            <td>部门位置</td>
            <td><input type="text" name="local" value=<%=department.getLocal()%>></td>
        </tr>
</table>
<input type="submit" name="g" value="提交">
</form>
</body>
</html>
