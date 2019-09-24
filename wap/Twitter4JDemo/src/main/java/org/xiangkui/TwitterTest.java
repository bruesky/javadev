package org.xiangkui;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet("/twitter2oauth")
public class TwitterTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            toOAuth(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testInit(){
        System.out.println("Twitter");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("083ewItBudVguqRlf3Z2WJpgT")
                .setOAuthConsumerSecret("sZHkl3jghwtShZtdHvkc80xwvyxcCcFIxCDJxpSt8PVZg9IUnp")
                .setOAuthAccessToken("1176308928851914752-6Ap28NTEdhBglJDq8wS6g7RhhTUblS")
                .setOAuthAccessTokenSecret("BjRMKOaIc10m6jwgiVmI7IQ8dOzsMxcNiQy2TjG3t9HWA");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            twitter.getHomeTimeline().stream()
                    .map(item -> item.getText())
                    .forEach(System.out::println);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    public static void toOAuth(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("***", "***");
        StringBuffer callbackURL = req.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/twitter2oauth_callback");

        RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
        req.getSession().setAttribute("requestToken", requestToken);
        resp.sendRedirect(requestToken.getAuthenticationURL());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
