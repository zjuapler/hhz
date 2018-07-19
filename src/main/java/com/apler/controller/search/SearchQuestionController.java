package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.entity.question.MultiQuestion;
import com.apler.entity.search.MultiArticleWithType;
import com.apler.entity.search.MultiQuestionWithType;
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
public class SearchQuestionController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/question")
    @ResponseBody
    public MultiQuestionWithType apiSearchArticle(
            HttpServletRequest request,
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return searchDao.getSearchQuestion(keyword, page, hhzToken);
    }

    @RequestMapping("/search/question")
    public String getSearchArticle(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiQuestionWithType multiQuestionWithType = searchDao.getSearchQuestion(keyword, "1", hhzToken);
        map.addAttribute("questions", multiQuestionWithType);
        map.addAttribute("keyword", keyword);
        return "search/question";
    }

    @RequestMapping("/ajax/search/question")
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
        MultiQuestionWithType multiQuestionWithType = searchDao.getSearchQuestion(keyword, page, hhzToken);
        map.addAttribute("questions", multiQuestionWithType);
        return "search/question :: questionList";
    }
}
