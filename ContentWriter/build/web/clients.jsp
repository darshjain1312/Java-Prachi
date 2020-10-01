<%@page import="dto.User"%>
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
<h1 align="center">Client List!</h1>
<table align="center" cellpadding="15">
    <tr>
        <th>Username</th>
        <th>Name</th>
        <th>Password</th>
        <th>Contact</th>
        <th>Email</th>
        <th>Status</th>
    </tr>
<%
Manager m = new Manager();
List<User> userlist = m.getUserList("client");
for(User u : userlist){
    %>
    <tr>
    <td><%=u.getUsername()%></td>
    <td><%=u.getName()%></td>
    <td><%=u.getPassword()%></td>
    <td><%=u.getContact()%></td>
    <td><%=u.getEmail()%></td>
    <td><%=u.getUserstatus()%></td>
    </tr>
    <%
        }
    %>
</table>
            </div> <!-- content -->
            <div id="footer">
                All rights reserved &copy; 2018
            </div> <!-- footer -->
        </div> <!-- main -->
    </body>
</html>
