package com.apler.controller;

import com.apler.dao.ArticleDao;
import com.apler.dao.CommentDao;
import com.apler.entity.article.Article;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/article/{articleId}")
    @ResponseBody
    public Article apiArticle(@PathVariable String articleId){
        return articleDao.getArticle(articleId);
    }

    @RequestMapping("article/{articleId}")
    public String article(ModelMap map, @PathVariable String articleId){
        Article article = articleDao.getArticle(articleId);
        map.addAttribute("article", article);
        MultiComment comments = commentDao.getMultiComment(articleId);
        HotComment hotComment = commentDao.getHotComment(articleId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "article";
    }
}
