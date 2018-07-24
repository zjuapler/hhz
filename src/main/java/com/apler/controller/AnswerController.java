package com.apler.controller;

import com.apler.service.AnswerService;
import com.apler.service.CommentService;
import com.apler.vo.answer.Answer;
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
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/api/answer/{answerId}")
    @ResponseBody
    public Answer apiAnswer(
            @PathVariable String answerId){
        return answerService.getAnswer(answerId);
    }

    @RequestMapping("/answer/{answerId}")
    public String answer(
            ModelMap map,
            @PathVariable String answerId){
        Answer answer = answerService.getAnswer(answerId);
        map.addAttribute("answer", answer);
        MultiComment comments = commentService.getMultiComment(answerId);
        HotComment hotComment = commentService.getHotComment(answerId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "answer";
    }
}
