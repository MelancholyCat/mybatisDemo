<%@ page import="java.util.List" %>
<%@ page import="xyz.lfans.bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2019-06-25
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>雇员信息</title>
</head>
<body bgcolor="#00bfff">
<table border="2">
    <form action="addEmp.jsp" method="post"><input type="submit" value="新增雇员"></form>
    <tr>
        <th>雇员编号</th>
        <th>雇员姓名</th>
        <th>雇员生日</th>
        <th>雇员工资</th>
        <th>所在部门</th>
        <td>修改信息</td>
        <td>删除信息</td>
    </tr>
    <%
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
        for (int i = 0;i<employeeList.size();i++){
            String update = "<form  action='updateEmp.jsp' method = 'post'>"+
                    "<input type ='hidden' name='employee' value= "+employeeList.get(i).getEmployeeId()+
                    ">"+"<input type ='submit'  value='修改' ></form>";
            String delete = "<form  action='DeleteEmp' method = 'post'>"+
                    "<input type ='hidden' name='employeeId' value= "+employeeList.get(i).getEmployeeId()+
                    ">"+"<input type ='submit'  value='删除' ></form>";
            out.println("<tr><th>"+employeeList.get(i).getEmployeeId()+"</th>");
            out.println("<th>"+employeeList.get(i).getEmployeeName()+"</th>");
            out.println("<th>"+employeeList.get(i).getBirthday()+"</th>");
            out.println("<th>"+employeeList.get(i).getWages()+"</th>");
            out.println("<th>"+employeeList.get(i).getDepartmentId()+"</th>");
            out.println("<th>"+update+"</th>");
            out.println("<th>"+delete+"</th></tr>");
        }
    %>
</table>
<A href="index.jsp" >返回首页</A>
</body>
</html>
