package com.apler.controller;

import com.apler.dao.RecommendDao;
import com.apler.entity.recommend.Recommend;
import com.apler.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class RecommendController {
    @Autowired
    private RecommendDao recommendDao;

    @RequestMapping("/api/recommend/object")
    @ResponseBody
    public Recommend apiRecommend(
            HttpServletRequest request,
            @RequestParam(value = "paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return recommendDao.getRecommend(page, hhzToken);
    }

    @RequestMapping("/")
    public String index(
            HttpServletRequest request,
            ModelMap map){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Recommend recommend = recommendDao.getRecommend("1", hhzToken);
        map.addAttribute("recommend", recommend);
        return "recommend";
    }

    @RequestMapping("/ajax/recommend")
    public String recommend(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value = "paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Recommend recommend = recommendDao.getRecommend(page, hhzToken);
        map.addAttribute("recommend", recommend);
        return "recommend :: recommendList";
    }
}
