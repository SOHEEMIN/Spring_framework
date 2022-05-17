package com.its.req;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";

    }
    //welcome 요청 처리
    @GetMapping("/welcome")
    public String welcome(){
        System.out.println("HomeController.welcome");
        return "welcome";
    }

    @GetMapping("/form-ex")
    public String formEx(){
        return "form-ex";
    }
    @GetMapping("/param-req1")
    public String paramReq1(@RequestParam("param1") String param1, @RequestParam("param2") String param2){
        // System.out.println("param1 = " + param1);
        // System.out.println("HoneController.paramReq1");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        System.out.println("HoneController.paramReq1");
        return null;
    }
    @PostMapping ("/param-req1")
    public String paramReq2(@RequestParam("param1") String param1, @RequestParam("param2") String param2){
        // System.out.println("param1 = " + param1);
        // System.out.println("HoneController.paramReq1");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        System.out.println("HoneController.paramReq1");
        return null;
    }
}
