package com.example.idk.Controlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @PostMapping("/home")
    public String postJome()
    {
        return "home";
    }

    @GetMapping("success")
    public String ez()
    {
        return "success";
    }
}
