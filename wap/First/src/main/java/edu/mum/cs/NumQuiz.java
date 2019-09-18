package edu.mum.cs;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/numquiz")
public class NumQuiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("quiz",null);
        doQuiz(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doQuiz(req,resp);
    }

    private void doQuiz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession httpSession = req.getSession();
        String question = "";
        String score = "";
        Quiz quiz = null;
        String answer = req.getParameter("answer");

        if (httpSession.getAttribute("quiz")!=null){
            quiz = (Quiz) httpSession.getAttribute("quiz");
        }else {
            quiz = new Quiz();
            httpSession.setAttribute("quiz",quiz);
        }

        if (!quiz.isOver()){
            if (quiz.isBegin()&&!"".equals(answer)){
                score += quiz.checkAnswerAndScore(Integer.valueOf(answer));
            }

            if (!quiz.isLastQuestion()) {
                question = quiz.shuffle();
            }
            else {
                question = "Over";
            }
            System.out.println(question+" "+score);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <H1>The Number Quiz</H1>");

            printWriter.printf("<div>Your current score is <span name=\"score\">%s</span> </div>\n" +
                    "    <div>Guess the next number in the sequence!</div>\n" +
                    "    <div>%s</div>",score,question);

            printWriter.println("<form action=\"numquiz\" method=\"post\">\n" +
                    "        <div>Your answer: <input type=\"number\" name=\"answer\"></div>\n" +
                    "        <input type=\"submit\" value=\"Submit\">\n" +
                    "    </form>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
