package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String goLogin(Model model){
        return "login";
    }

    @GetMapping("/inJoin")
    public String inJoin(Model model){
        UserSaveRequsetDto userDto = new UserSaveRequsetDto();
        model.addAttribute("userDto", userDto);
        return "join";
    }

    @PostMapping("/join")
    public String userSave(@ModelAttribute("userDto") UserSaveRequsetDto userDto){
        System.out.println(userDto.getEmail());
        System.out.println("Test");
        userService.userSave(userDto);
        return "redirect:/";
    }
}
