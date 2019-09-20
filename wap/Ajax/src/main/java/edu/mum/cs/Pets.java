package edu.mum.cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pets")
public class Pets extends HttpServlet {
    private String[] dogs = {
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/puppy1.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/puppy2.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/puppy3.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/puppy4.jpeg"
    };

    private String[]cats = {
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/kitty1.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/kitty2.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/kitty4.jpeg",
            "http://mumstudents.org/cs472/2016-03-AS-KL/Sections/8/ajaxpets/images/kitty3.jpeg"
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String animal = req.getParameter("animal");

        if ("kitty".equals(animal)){
            String ret = "";
            for (int i = 0; i < cats.length; i++) {
                ret+= String.format("<img src=\"%s\">",cats[i]);
            }
            resp.getWriter().print(ret);
        }

        if ("puppy".equals(animal)){
            String ret = "";
            for (int i = 0; i < dogs.length; i++) {
                ret+= String.format("<img src=\"%s\">",dogs[i]);
            }
            resp.getWriter().print(ret);
        }

    }
}
