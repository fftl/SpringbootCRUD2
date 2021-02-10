package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @GetMapping("/")
    public String goIndex(HttpServletRequest req){
        return "home";
    }

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

}
