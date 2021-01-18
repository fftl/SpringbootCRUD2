package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.controller.dto.UserLoginRequestDto;
import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import fftl.SpringbootCRUD2.domain.User;
import fftl.SpringbootCRUD2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

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

    @GetMapping("/inLogin")
    public String goLogin(Model model){

        UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
        model.addAttribute("LoginDto", userLoginRequestDto);

        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@ModelAttribute("LoginDto") UserLoginRequestDto loginDto, HttpSession session, HttpServletRequest request){
        User user = userService.userLogin(loginDto.getUsername(), loginDto.getPassword());

        if(user.getEmail() != ""){
            session.setAttribute("userInfo", user);

            return "redirect:/";
        }

        return "error";
    }
}
