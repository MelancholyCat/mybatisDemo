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
    <title>添加部门</title>
    <meta charset="UTF-8">
</head>
<body bgcolor="#00bfff">
<table border="2">
    <tr>
        <th>添加部门信息</th>
    </tr>
    <form action="AddDepartment" method="post">
        <tr>
            <td>部门名字</td>
            <td><input type="text" name="departmentName"></td>
        </tr>
        <tr>
            <td>部门位置</td>
            <td><input type="text" name="local"></td>
        </tr>
</table>
<input type="submit" name="g" value="提交">
    </form>
</body>
</html>
