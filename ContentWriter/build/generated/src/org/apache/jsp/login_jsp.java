package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import dao.Manager;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>MySite</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"logo\">\n");
      out.write("                    <img src=\"a.png\">\n");
      out.write("                </div> <!-- logo -->\n");
      out.write("                <div id=\"sitename\">\n");
      out.write("                    MySite\n");
      out.write("                </div> <!-- sitename -->\n");
      out.write("            </div> <!-- header-->\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"aboutus.jsp\">About Us</a></li>\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("                    <li><a href=\"register.jsp\">Register</a></li>\n");
      out.write("                    <li><a href=\"contactus.jsp\">Help</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div> <!-- menu -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <div style=\"color:red;text-align: center;\">");

                    String msg = request.getParameter("msg");
                    if(msg!=null){
                    out.print(msg);
                    }
                    
      out.write("</div>\n");
      out.write("                <h1 align=\"center\">login Here!</h1>\n");
      out.write("                <form action=\"\" method=\"post\">\n");
      out.write("                <table align=\"center\" cellpadding=\"10\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Enter Username</td>\n");
      out.write("                        <td>\n");
      out.write("<input type=\"text\" name=\"username\" \n");
      out.write("   value=\"");

/*Cookie cook[] = request.getCookies();
if(cook.length!=0){
for(Cookie ck : cook){
    if(ck.getName().equals("NM")){
    out.print(ck.getValue());
    }
}
}*/
 
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Enter Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"password\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                       <td colspan=\"2\" align=\"center\">\n");
      out.write("        <input type=\"checkbox\" name=\"c1\">Remember Me\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\" align=\"center\">\n");
      out.write("               <input type=\"submit\" name=\"log\" value=\"Login\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                </form>\n");

String btn = request.getParameter("log");
if(btn!=null){
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 
 if(request.getParameter("c1")!=null){
    Cookie c = new Cookie("NM", username);
    c.setMaxAge(60*60*24);
    response.addCookie(c);
 }
 
            Manager m = new Manager();
            boolean t = m.loginCheck(username, password);
            if(t){
                String role = m.getRole(username, password);
                //HttpSession session = request.getSession();
                session.setAttribute("ROLE", role);
                session.setAttribute("UNM", username);
                response.sendRedirect("profile.jsp?msg=u r reg succsfully, plz login to continue");
            }
            else{
                    response.sendRedirect("login.jsp?msg=invalid username/password");
            }
}

      out.write("\n");
      out.write("            </div> <!-- content -->\n");
      out.write("            <div id=\"footer\">\n");
      out.write("                All rights reserved &copy; 2018\n");
      out.write("            </div> <!-- footer -->\n");
      out.write("        </div> <!-- main -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
