package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    // The @RequestMapping is used to map the request which is in particular format.
    // Here we provided the format like (the request should end with /greeting.html
    // the .html is used in dispatcher
    // /greeting is used here
    // So when ever a request comes the dispatcher checks the methods of @Controller class
    // If it finds any @RequestMapping method correctly then it invokes the correct method present.
    // i.e for example : the below method is invoked if the request contains "/greeting" tag

    @RequestMapping(value = "/greeting")
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Hello World");
        return "hello"; // View Name
    }
}
