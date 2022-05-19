package com.its.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/save-form")
    public String save() {
        return "save";
    }
    @GetMapping("/login-form")
    public String login() {
        return "login";
    }
    @GetMapping("/main")
    public String main() {
        return "main";
    }


}
