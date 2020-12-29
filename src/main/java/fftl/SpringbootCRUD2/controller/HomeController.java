package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.domain.MemberTO;
import fftl.SpringbootCRUD2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Configuration
@RequestMapping(value="/")
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String homeView() {
        return "/pages/home";
    }

    @GetMapping("/login")
    public String loginView() {
        return "/pages/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "/pages/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberTO memberTO) {
        memberService.save(memberTO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "/pages/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "/pages/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "/pages/denied";
    }
}
