package edu.mum.cs.redoquiz;

import edu.mum.cs.Quiz;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rquiz")
public class Rquiz extends HttpServlet {
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
                question = quiz.getProcess();
            }
            System.out.println(question+" "+score);
            req.setAttribute("question",question);
            req.setAttribute("score","".equals(score)?0:score);
            req.getRequestDispatcher("rquiz.jsp").forward(req,resp);
        }
    }
}
