package com.apler.controller;

import com.apler.dao.AnswerDao;
import com.apler.dao.QuestionDao;
import com.apler.entity.answer.Answer;
import com.apler.entity.question.MultiQuestion;
import com.apler.entity.question.Question;
import com.apler.entity.question.RelativeMultiAnswer;
import com.apler.entity.tag.MultiTag;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;

    @RequestMapping("/api/question/{questionId}")
    @ResponseBody
    public Question apiQuestion(
            HttpServletRequest request,
            @PathVariable String questionId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return questionDao.getQuestion(questionId, hhzToken);
    }

    @RequestMapping("/api/question/{questionId}/answer")
    @ResponseBody
    public RelativeMultiAnswer apiRelativeMultiAnswer(
            HttpServletRequest request,
            @PathVariable String questionId,
            @RequestParam(defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return questionDao.getAnswerInQuestion(questionId, page, hhzToken);
    }

    @RequestMapping("/api/question")
    @ResponseBody
    public MultiQuestion apiQuestions(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(required = false) String tag){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return questionDao.getQuestions(tag, page, hhzToken);
    }

    @RequestMapping("/api/question_tag")
    @ResponseBody
    public MultiTag apiQuestionTags(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return questionDao.getQuestionTags(hhzToken);
    }

    @RequestMapping("/question")
    public String getQuestions(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(required = false) String tag){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiQuestion multiQuestion = questionDao.getQuestions(tag, "1", hhzToken);
        MultiTag multiTag = questionDao.getQuestionTags(hhzToken);
        map.addAttribute("questions", multiQuestion);
        map.addAttribute("tags", multiTag);
        map.addAttribute("tag", tag);
        return "questions";
    }

    @RequestMapping("/ajax/question")
    public String ajaxGetQuestions(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value = "paged") String page,
            @RequestParam(value = "tag", required = false) String tag){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiQuestion multiQuestion = questionDao.getQuestions(tag, page, hhzToken);
        map.addAttribute("questions", multiQuestion);
        return "questions :: questionList";
    }

    @RequestMapping("/question/{qid}")
    public String getQuestion(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String qid){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Question question = questionDao.getQuestion(qid, hhzToken);
        RelativeMultiAnswer relativeMultiAnswer = questionDao.getAnswerInQuestion(qid, "1", hhzToken);
        map.addAttribute("question", question);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question";
    }

    @RequestMapping("/ajax/question/{qid}/answer")
    public String getQuestion(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String qid,
            @RequestParam(value = "paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        RelativeMultiAnswer relativeMultiAnswer = questionDao.getAnswerInQuestion(qid, page, hhzToken);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question :: answerList";
    }
}
