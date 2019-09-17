package edu.mum.cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calc"})
public class Calculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        int num3 = Integer.valueOf(num1)+Integer.valueOf(num2);
        String num4 = req.getParameter("num4");
        String num5 = req.getParameter("num5");
        int num6 = Integer.valueOf(num4)*Integer.valueOf(num5);
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");
        printWriter.println("<form id=\"calc\" action=\"calc\" method=\"post\">");
        printWriter.printf("<input type=\"text\" name=\"num1\" value=\"%s\">+<input type=\"text\" name=\"num2\" value=\"%s\">=<input type=\"text\" name=\"num3\" value=\"%d\">",num1,num2,num3);
        printWriter.println("<br />");
        printWriter.printf("<input type=\"text\" name=\"num4\" value=\"%s\">*<input type=\"text\" name=\"num5\" value=\"%s\">=<input type=\"text\" name=\"num6\" value=\"%d\">",num4,num5,num6);
        printWriter.println("<br />");
        printWriter.println("<input type=\"submit\">");
        printWriter.println("</form>");
    }
}
