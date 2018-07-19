package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.entity.search.MultiArticleWithType;
import com.apler.entity.search.MultiHouseWithType;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SearchArticleController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/article")
    @ResponseBody
    public MultiArticleWithType apiSearchArticle(
            HttpServletRequest request,
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return searchDao.getSearchArticle(keyword, page, hhzToken);
    }

    @RequestMapping("/search/article")
    public String getSearchArticle(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiArticleWithType multiArticleWithType = searchDao.getSearchArticle(keyword, "1", hhzToken);
        map.addAttribute("articles", multiArticleWithType);
        map.addAttribute("keyword", keyword);
        return "search/article";
    }

    @RequestMapping("/ajax/search/article")
    public String ajaxSearchArticle(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiArticleWithType multiArticleWithType = searchDao.getSearchArticle(keyword, page, hhzToken);
        map.addAttribute("articles", multiArticleWithType);
        return "search/article :: articleList";
    }
}
