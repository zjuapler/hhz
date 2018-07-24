package com.apler.controller.search;

import com.apler.service.SearchService;
import com.apler.vo.search.MultiArticleWithType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class SearchArticleController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/api/search/article")
    @ResponseBody
    public MultiArticleWithType apiSearchArticle(
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        return searchService.getSearchArticle(keyword, page);
    }

    @RequestMapping("/search/article")
    public String getSearchArticle(
            ModelMap map,
            @RequestParam String keyword){
        MultiArticleWithType multiArticleWithType = searchService.getSearchArticle(keyword, "1");
        map.addAttribute("articles", multiArticleWithType);
        map.addAttribute("keyword", keyword);
        return "search/article";
    }

    @RequestMapping("/ajax/search/article")
    public String ajaxSearchArticle(
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        MultiArticleWithType multiArticleWithType = searchService.getSearchArticle(keyword, page);
        map.addAttribute("articles", multiArticleWithType);
        return "search/article :: articleList";
    }
}
