<%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2019-06-25
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加雇员</title>
    <meta charset="UTF-8">
</head>
<body bgcolor="#00bfff">
<table border="2">
    <tr>
        <th>添加雇员信息</th>
    </tr>
    <form action="AddEmp" method="post">
        <tr>
            <td>雇员姓名</td>
            <td><input type="text" name="employeeName"></td>
        </tr>
        <tr>
            <td>雇员生日</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>雇员工资</td>
            <td><input type="text" name="wages"></td>
        </tr>
        <tr>
            <td>所在部门</td>
            <td><input type="text" name="departmentId"></td>
        </tr>
</table>
<input type="submit" name="g" value="提交">
    </form>
</body>
</html>
