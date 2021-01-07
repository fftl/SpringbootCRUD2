package fftl.SpringbootCRUD2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String goIndex(){
        return "home";
    }

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

}
