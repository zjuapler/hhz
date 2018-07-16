package com.apler.controller;

import com.apler.dao.RecommendDao;
import com.apler.entity.recommend.Recommend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RecommendController {
    @Autowired
    private RecommendDao recommendDao;

    @RequestMapping("/api/recommend/object")
    @ResponseBody
    public Recommend apiRecommend(
            @RequestParam(value = "paged") String page){
        return recommendDao.getRecommend(page);
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        Recommend recommend = recommendDao.getRecommend("1");
        map.addAttribute("recommend", recommend);
        return "recommend";
    }

    @RequestMapping("/ajax/recommend")
    public String recommend(
            ModelMap map,
            @RequestParam(value = "paged") String page){
        Recommend recommend = recommendDao.getRecommend(page);
        map.addAttribute("recommend", recommend);
        return "recommend :: recommendList";
    }
}
