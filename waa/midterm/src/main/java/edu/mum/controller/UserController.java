package edu.mum.controller;

import edu.mum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String showForm(@ModelAttribute("user")User user, Model model){
        return "userForm";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("user") User user,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        if (bindingResult.hasErrors()){
            return "userForm";
        }else {
            redirectAttributes.addFlashAttribute("user",user);
            return "redirect:/user/userDetails";
        }
    }

    @RequestMapping(value = "/userDetails",method = RequestMethod.GET)
    public String detail(){
        return "success";
    }
}
