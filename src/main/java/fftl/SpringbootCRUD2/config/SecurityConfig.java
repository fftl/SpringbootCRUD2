package fftl.SpringbootCRUD2.config;

import fftl.SpringbootCRUD2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //비밀번호를 복호화/암호화 하는 로직이 담겨있습니다.
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**"); //여기에 해당하는 객체는 인증을 제외합니다.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/member/**").authenticated() //인증된 사용자만 요청가능
//                .antMatchers("/admin/**").authenticated() //인증된 사용자만 요청가능
//                .antMatchers("/**").permitAll(); //누구나 요청가능
//
//        http.formLogin()
//                .loginPage("/login")    //login 요청시 이동될 페이지입니다.
//                .defaultSuccessUrl("/") //login 요청이 성공하면 이동될 페이지입니다.
//                .permitAll();
//
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃의 경로를 지정합니다.
//                .logoutSuccessUrl("/login") //로그아웃이 성공하면 이동될 페이지입니다.
//                .invalidateHttpSession(true); //로그아웃 성공시 세션을 제거합니다.
//
//        http.exceptionHandling()
//                .accessDeniedPage("/denied"); //권한이 없는 사용자가 접근했을 경우 이동할 경로를 지정합니다.

        http
                .authorizeRequests()
                .antMatchers("/", "/home","/signup").permitAll()
                .antMatchers("/member/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { //AuthenticationManagerBuilder는 사용자 인증을 담당합니다.
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder()); //userDetailsSerivce에 service를 넘겨 인증을 해야합니다.
    }

}