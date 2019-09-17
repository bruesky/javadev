package edu.mum.cs;

import javax.servlet.*;
import java.io.IOException;

public class Hello implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello in Maven!!!");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
