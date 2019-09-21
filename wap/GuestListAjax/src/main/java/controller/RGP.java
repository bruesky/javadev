package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rpg")
public class RGP extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        List<String> names = (List<String>) httpSession.getAttribute("names");
        if (names==null){
            names = new ArrayList<String>();
            httpSession.setAttribute("names",names);
        }
        String name = req.getParameter("name");
        names.add(name);
        System.out.println(names);
    }
}
