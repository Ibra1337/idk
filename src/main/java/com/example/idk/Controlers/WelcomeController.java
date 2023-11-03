package com.example.idk.Controlers;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
 

@Component

public class WelcomeController implements ApplicationListener<ContextRefreshedEvent> {


    @GetMapping("/")
    public String greetings(){
        return "index";
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("STARTED FINALLY");
    }



}

