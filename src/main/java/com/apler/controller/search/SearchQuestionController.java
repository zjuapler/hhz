package com.apler.controller.search;

import com.apler.service.SearchService;
import com.apler.vo.search.MultiQuestionWithType;
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
public class SearchQuestionController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/api/search/question")
    @ResponseBody
    public MultiQuestionWithType apiSearchArticle(
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        return searchService.getSearchQuestion(keyword, page);
    }

    @RequestMapping("/search/question")
    public String getSearchArticle(
            ModelMap map,
            @RequestParam String keyword){
        MultiQuestionWithType multiQuestionWithType = searchService.getSearchQuestion(keyword, "1");
        map.addAttribute("questions", multiQuestionWithType);
        map.addAttribute("keyword", keyword);
        return "search/question";
    }

    @RequestMapping("/ajax/search/question")
    public String ajaxSearchArticle(
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        MultiQuestionWithType multiQuestionWithType = searchService.getSearchQuestion(keyword, page);
        map.addAttribute("questions", multiQuestionWithType);
        return "search/question :: questionList";
    }
}
