package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.dto.ResponseDto;
import fftl.SpringbootCRUD2.dto.UserLoginRequestDto;
import fftl.SpringbootCRUD2.dto.UserSaveRequsetDto;
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
    public String inJoin(Model model) {
        UserSaveRequsetDto userDto = new UserSaveRequsetDto();
        model.addAttribute("userDto", userDto);
        return "join";
    }

    @PostMapping("/join")
    public String userSave(@ModelAttribute("userDto") UserSaveRequsetDto userDto) {
        userService.userSave(userDto);
        return "redirect:/";
    }

    @GetMapping("/inLogin")
    public String goLogin(Model model) {

        UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
        model.addAttribute("LoginDto", userLoginRequestDto);

        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@ModelAttribute("LoginDto") UserLoginRequestDto loginDto, HttpServletRequest request) {
        User user = userService.userLogin(loginDto.getUserName(), loginDto.getPassword());
        if (user.getEmail() != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            return "redirect:/";
        }

        return "error";
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/idCheck/{idCheck}")
    public ResponseDto userLogout(@PathVariable String idCheck) {
        if (userService.idCheck(idCheck)){
            return ResponseDto.builder()
                    .data("y")
                    .content("사용할 수 있는 아이디!")
                    .build();
        }

        return ResponseDto.builder()
                    .data("n")
                    .content("중복된 아이디 입니다!")
                    .build();
    }
}
