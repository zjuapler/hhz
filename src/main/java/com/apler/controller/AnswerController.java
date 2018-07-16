package com.apler.controller;

import com.apler.dao.AnswerDao;
import com.apler.dao.CommentDao;
import com.apler.dao.PhotoDao;
import com.apler.entity.answer.Answer;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnswerController {
    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/answer/{answerId}")
    @ResponseBody
    public Answer apiAnswer(@PathVariable String answerId){
        return answerDao.getAnswer(answerId);
    }

    @RequestMapping("/answer/{answerId}")
    public String answer(ModelMap map, @PathVariable String answerId){
        Answer answer = answerDao.getAnswer(answerId);
        map.addAttribute("answer", answer);
        MultiComment comments = commentDao.getMultiComment(answerId);
        HotComment hotComment = commentDao.getHotComment(answerId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "answer";
    }
}
