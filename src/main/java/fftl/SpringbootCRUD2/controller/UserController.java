package fftl.SpringbootCRUD2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping("/join")
    public String inJoin(Model model){
        return "join";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }


}
