package com.apler.controller;

import com.apler.dao.AnswerDao;
import com.apler.dao.QuestionDao;
import com.apler.entity.answer.Answer;
import com.apler.entity.question.MultiQuestion;
import com.apler.entity.question.Question;
import com.apler.entity.question.RelativeMultiAnswer;
import com.apler.entity.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;

    @RequestMapping("/api/question/{questionId}")
    @ResponseBody
    public Question apiQuestion(@PathVariable String questionId){
        return questionDao.getQuestion(questionId);
    }

    @RequestMapping("/api/question/{questionId}/answer")
    @ResponseBody
    public RelativeMultiAnswer apiRelativeMultiAnswer(
            @PathVariable String questionId,
            @RequestParam(defaultValue = "1") String page){
        return questionDao.getAnswerInQuestion(questionId, page);
    }

    @RequestMapping("/api/question")
    @ResponseBody
    public MultiQuestion apiQuestions(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(required = false) String tag){
        return questionDao.getQuestions(tag, page);
    }

    @RequestMapping("/api/question_tag")
    @ResponseBody
    public MultiTag apiQuestionTags(){
        return questionDao.getQuestionTags();
    }

    @RequestMapping("/question")
    public String getQuestions(
            ModelMap map,
            @RequestParam(required = false) String tag){
        MultiQuestion multiQuestion = questionDao.getQuestions(tag, "1");
        MultiTag multiTag = questionDao.getQuestionTags();
        map.addAttribute("questions", multiQuestion);
        map.addAttribute("tags", multiTag);
        map.addAttribute("tag", tag);
        return "questions";
    }

    @RequestMapping("/ajax/question")
    public String ajaxGetQuestions(
            ModelMap map,
            @RequestParam(value = "paged") String page,
            @RequestParam(value = "tag", required = false) String tag){
        MultiQuestion multiQuestion = questionDao.getQuestions(tag, page);
        map.addAttribute("questions", multiQuestion);
        return "questions :: questionList";
    }

    @RequestMapping("/question/{qid}")
    public String getQuestion(
            ModelMap map,
            @PathVariable String qid){
        Question question = questionDao.getQuestion(qid);
        RelativeMultiAnswer relativeMultiAnswer = questionDao.getAnswerInQuestion(qid, "1");
        map.addAttribute("question", question);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question";
    }

    @RequestMapping("/ajax/question/{qid}/answer")
    public String getQuestion(
            ModelMap map,
            @PathVariable String qid,
            @RequestParam(value = "paged") String page){
        RelativeMultiAnswer relativeMultiAnswer = questionDao.getAnswerInQuestion(qid, page);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question :: answerList";
    }
}
