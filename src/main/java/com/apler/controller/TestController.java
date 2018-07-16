package com.apler.controller;

import com.apler.entity.recommend.Recommend;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Data
class Demo{
    private int code;
    private String msg;
}

@Controller
public class TestController {

    @RequestMapping("/ping")
    @ResponseBody
    public Demo ping(
            HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("name", "lcl");
        cookie.setMaxAge(120);
        httpServletResponse.addCookie(cookie);
        Demo demo = new Demo();
        demo.setCode(1);
        demo.setMsg("succ");
        return demo;
    }
}
