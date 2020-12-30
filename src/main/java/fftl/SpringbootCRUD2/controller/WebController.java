package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserService userService;

    @GetMapping("/")
    public String goIndex(){
        return "home";
    }

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

    @GetMapping("/hello")
    public String goHello(){
        return "hello";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/join")
    public String goJoin(){
        return "join";
    }

    @PostMapping("/join")
    public String userJoin(User user){

        userService.userJoin(user);

        return "join";
    }

}
