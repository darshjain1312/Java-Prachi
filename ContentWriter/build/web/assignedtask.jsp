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
                    <li><a href="viewpostedtask.jsp">View Task</a></li>
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
Manager m = new Manager();
List<Task> tlist = m.getAssignedTaskList(unm);
if(tlist.size()==0){
    out.print("<h1 align=center>No Task</h1>");
}else{
%>

<h1 align="center">Assigned Task List!</h1>
<table align="center" cellpadding="15">
    <tr>
        <th>Task Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>                
                
<%
for(Task t : tlist){
    %>
    <tr>
    <td><%=t.getTaskid()%></td>
    <td><%=t.getTitle()%></td>
    <td><%=t.getDescription()%></td>
    <td><%=t.getTaskstatus()%></td>
    <td>
        <% if(t.getTaskstatus().equals("assigned")){ %>
        <a href="writetask.jsp?tid=<%=t.getTaskid()%>">WRITE</a>
        <% } 
        if(t.getTaskstatus().equals("completed")){
        %>
        <a href="viewtask.jsp?tid=<%=t.getTaskid()%>">View</a>
        <% } %>
    </td>
    </tr>
    <%
    //out.print(t.getTaskid()+" "+t.getTitle());
}
}//else
%>
</table>
            </div> <!-- content -->
            <div id="footer">
                All rights reserved &copy; 2018
            </div> <!-- footer -->
        </div> <!-- main -->
    </body>
</html>
