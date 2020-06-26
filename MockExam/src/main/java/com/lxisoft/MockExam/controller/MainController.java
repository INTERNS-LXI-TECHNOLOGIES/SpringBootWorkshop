package com.lxisoft.MockExam.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() 
    {
        return "home";
    }

    @GetMapping("/userLogin")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userhome() {
        return "user/home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/admin")
    public String adminView()
    {
        return "admin";
    }
}
