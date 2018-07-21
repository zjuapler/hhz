package com.apler.controller;

import com.apler.entity.user.User;
import com.apler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    public void addCookie(HttpServletResponse response, String hhzToken, String uid){
        Cookie cookie = new Cookie("hhz_token", hhzToken);
        Cookie cookie1 = new Cookie("uid", uid);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    @RequestMapping("/addlogin")
    public String login(
            @RequestParam String phone,
            @RequestParam String password, HttpServletResponse httpServletResponse){
        User user = userService.getUser(phone, password);
        if (user != null){
            String cookie = user.getCookie();
            String uid = user.getUid();
            addCookie(httpServletResponse, cookie, uid);
            return "redirect:/";
        } else {
            return "login";
        }
    }
}
