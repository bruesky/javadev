package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"phone"})
public class Main {
    @RequestMapping("/product")
    public String populateProduct(Model model, HttpSession session) {
        model.addAttribute("phone", "iPhone 8");
        session.setAttribute("tablet", "iPad");
        model.addAttribute("company", "Apple");
        return "redirect:/display";
    }

    @RequestMapping("/display")
    public String displayProduct(Model model, SessionStatus status) {
        status.setComplete();
        return "product";
    }

}
