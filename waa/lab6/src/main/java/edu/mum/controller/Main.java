package edu.mum.controller;

import edu.mum.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Main {
    @GetMapping("/demo1")
    public String demo1(){
        return "demo1";
    }

    @RequestMapping("/hello")
    public String display(Model m)
    {
        m.addAttribute("emp", new Employee());
        return "viewpage";
    }
    @RequestMapping("/helloagain")
    public String submitForm(@Valid @ModelAttribute("emp") Employee e, BindingResult br)
    {
        if(br.hasErrors())
        {
            return "viewpage";
        }
        else
        {
            return "final";
        }
    }
}
