package ru.runov;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/servl")
public class HwServlet implements Servlet {
    public transient ServletConfig sc;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.sc = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.sc;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("<h1>Hello world !</h1>");
    }

    @Override
    public String getServletInfo() {
        return "servlet @servlet-app";
    }

    @Override
    public void destroy() {
    }
}
