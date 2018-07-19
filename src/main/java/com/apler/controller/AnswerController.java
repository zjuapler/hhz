package com.apler.controller;

import com.apler.dao.AnswerDao;
import com.apler.dao.CommentDao;
import com.apler.dao.PhotoDao;
import com.apler.entity.answer.Answer;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.photo.Photo;
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
public class AnswerController {
    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/answer/{answerId}")
    @ResponseBody
    public Answer apiAnswer(
            HttpServletRequest request,
            @PathVariable String answerId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return answerDao.getAnswer(answerId, hhzToken);
    }

    @RequestMapping("/answer/{answerId}")
    public String answer(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String answerId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Answer answer = answerDao.getAnswer(answerId, hhzToken);
        map.addAttribute("answer", answer);
        MultiComment comments = commentDao.getMultiComment(answerId, hhzToken);
        HotComment hotComment = commentDao.getHotComment(answerId, hhzToken);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "answer";
    }
}
