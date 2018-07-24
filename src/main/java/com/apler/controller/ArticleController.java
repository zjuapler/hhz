package com.apler.controller;

import com.apler.service.ArticleService;
import com.apler.service.CommentService;
import com.apler.vo.article.Article;
import com.apler.vo.comment.HotComment;
import com.apler.vo.comment.MultiComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/api/article/{articleId}")
    @ResponseBody
    public Article apiArticle(
            @PathVariable String articleId){
        return articleService.getArticle(articleId);
    }

    @RequestMapping("article/{articleId}")
    public String article(
            ModelMap map,
            @PathVariable String articleId){
        Article article = articleService.getArticle(articleId);
        map.addAttribute("article", article);
        MultiComment comments = commentService.getMultiComment(articleId);
        HotComment hotComment = commentService.getHotComment(articleId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "article";
    }
}
