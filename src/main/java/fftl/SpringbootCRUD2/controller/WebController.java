package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.model.UserEntity;
import fftl.SpringbootCRUD2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String goJoin(Model model){
        model.addAttribute("userForm", new UserForm());

        return "join";
    }

    @PostMapping("/join")
    public String userJoin(@Validated UserForm user, Model model){
        UserEntity userEntity = new UserEntity();

        userEntity.setUid(user.getUid());
        userEntity.setUpw(user.getUpw());
        userEntity.setEmail(user.getEmail());
        userEntity.setUname(user.getUname());

        userService.userJoin(userEntity);

        return "login";
    }

}
