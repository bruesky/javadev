package edu.mum.controller;

import edu.mum.data.DataFacade;
import edu.mum.data.DataFacadeFactory;
import edu.mum.model.Calculator;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    @Autowired
    private DataFacade dataFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(Calculator calculator){
        calculator.calcSum();
        calculator.calcProduct();
        return "result";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calc(){
        return "calculator";
    }

    @RequestMapping(value = "/star", method = RequestMethod.GET)
    public String star(){
        return "starbucks";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name,@RequestParam("password") String password){

        String expectedPassword = dataFacade.findPassword(name);

        if(expectedPassword == null || !expectedPassword.equals(password)) {
            return "starbucks";
        } else {
            return "sucess";
        }
    }

    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public String advice(@RequestParam("roast") String roast,ModelMap model){
        List<String> advice = dataFacade.getAdvice(roast);
        model.addAttribute("advice",advice);
        return "advice";
    }


}
