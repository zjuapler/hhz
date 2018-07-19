package com.apler.controller;

import com.apler.dao.ArticleDao;
import com.apler.dao.CommentDao;
import com.apler.entity.article.Article;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/article/{articleId}")
    @ResponseBody
    public Article apiArticle(
            HttpServletRequest request,
            @PathVariable String articleId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return articleDao.getArticle(articleId, hhzToken);
    }

    @RequestMapping("article/{articleId}")
    public String article(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String articleId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Article article = articleDao.getArticle(articleId, hhzToken);
        map.addAttribute("article", article);
        MultiComment comments = commentDao.getMultiComment(articleId, hhzToken);
        HotComment hotComment = commentDao.getHotComment(articleId, hhzToken);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "article";
    }
}
