package edu.mum.controller;

import edu.mum.domain.Checkin;
import edu.mum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"users"})//consider our users as session scope object
public class Main {

    @ModelAttribute("users")//controller is accessed for the first time, Spring instantiate an instance and place it in the Model
    public List<User> addUserList(){
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String checkin(@ModelAttribute("newCheckin")Checkin checkin){
        return "checkin";
    }

    @PostMapping("/checkin")
    public String doCheckin(@ModelAttribute("newCheckin")Checkin checkin,
                            final RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("checkin_result",checkin);
        return "redirect:sucess";
    }

    @GetMapping("/sucess")
    public String suc(){
        return "sucess";
    }

    @GetMapping("add")//@SessionAttribute annotation retrieve the existing attribute from the session
    public String testSessionAttributes(@ModelAttribute("user") User user,@SessionAttribute("users") List<User> users){
        users.add(user);
        return "testsession";
    }

    @GetMapping("clearss")
    public String clearSessionAttributes(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "testsession";
    }

}
