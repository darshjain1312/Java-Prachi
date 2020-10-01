<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="dao.Manager"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MySite</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="logo">
                    <img src="a.png">
                </div> <!-- logo -->
                <div id="sitename">
                    MySite
                </div> <!-- sitename -->
            </div> <!-- header-->
            <div id="menu">
    <%
    String unm  = (String)session.getAttribute("UNM");
    String role  = (String)session.getAttribute("ROLE");
    %>
                <ul>
                    <li><a href="profile.jsp">Profile</a></li>
                    <% if(role.equals("admin")){ %>
                    <li><a href="writers.jsp">Writers</a></li>
                    <li><a href="clients.jsp">Clients</a></li>
                    <li><a href="tasks.jsp">Tasks</a></li>
                    <% } %>
                    <% if(role.equals("client")){ %>
                    <li><a href="posttask.jsp">Post Task</a></li>
                    <li><a href="viewtask.jsp">View Task</a></li>
                    <% } %>
                    <% if(role.equals("writer")){ %>
                    <li><a href="assignedtask.jsp">Assigned Task</a></li>
                    <% } %>
                    <li><a href="logout.jsp">Logout</a></li>
                </ul>
            </div> <!-- menu -->
            <div id="content">
<%
    out.print("Welcome "+unm);    
    out.print(" As "+role);
%>

<%
    int taskid = Integer.parseInt(request.getParameter("tid"));
    //out.print(taskid);
    Manager m = new Manager();
    Task task = m.getTaskDetail(taskid);
%>
<h1 align="center">Assign Task!</h1>
<form action="" method="post">
<table align="center" cellpadding="10">
    <tr>
        <td>Task Id</td>
        <td><%=task.getTaskid()%></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><%=task.getTitle()%></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><%=task.getDescription()%></td>
    </tr>
    <tr>
        <td>Assign To</td>
        <td>
            <%
            List<String> writers = m.getWriters();
            %>
            <select name="assignto">
                <%
                for(String s:writers){
                %>
                <option><%=s%></option>
                <%
                }
                %>
            </select>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Assign" name="btn">
        </td>
    </tr>
</table>
</form>
<%
String btn = request.getParameter("btn");
if(btn!=null){
String assignto = request.getParameter("assignto");
String taskstatus = "assigned";
int t = m.assignTask(assignto,taskstatus,taskid);
if(t>0){
    response.sendRedirect("tasks.jsp");
}else{
    out.print("Not Assigned!!!");
}
}
%>
            </div> <!-- content -->
            <div id="footer">
                All rights reserved &copy; 2018
            </div> <!-- footer -->
        </div> <!-- main -->
    </body>
</html>
