<%@ page import="xyz.lfans.bean.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Atlantis
  Date: 2019-06-25
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门信息</title>
</head>
<body bgcolor="#00bfff">
<table border="2">
    <form action="addDep.jsp" method="post"><input type="submit" value="新增部门"></form>
    <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门位置</th>
        <td>修改信息</td>
        <td>删除信息</td>
    </tr>
    <%
        List<Department> departmentList = (List<Department>) request.getAttribute("departmentList");
        for (int i = 0;i<departmentList.size();i++){
            String update = "<form  action='updateDep.jsp' method = 'post'>"+
                    "<input type ='hidden' name='departmentId' value= "+departmentList.get(i).getDepartmentId()+
                    ">"+"<input type ='submit'  value='修改' ></form>";
            String delete = "<form  action='DeleteDepartment' method = 'post'>"+
                    "<input type ='hidden' name='departmentId' value= "+departmentList.get(i).getDepartmentId()+
                    ">"+"<input type ='submit'  value='删除' ></form>";
            out.println("<tr><th>"+departmentList.get(i).getDepartmentId()+"</th>");
            out.println("<th>"+departmentList.get(i).getDepartmentName()+"</th>");
            out.println("<th>"+departmentList.get(i).getLocal()+"</th>");
            out.println("<th>"+update+"</th>");
            out.println("<th>"+delete+"</th></tr>");
        }
    %>
</table>
<A href="index.jsp" >返回首页</A>
</body>
</html>
