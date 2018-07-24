package com.apler.controller;

import com.apler.service.QuestionService;
import com.apler.vo.question.MultiQuestion;
import com.apler.vo.question.Question;
import com.apler.vo.question.RelativeMultiAnswer;
import com.apler.vo.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/api/question/{questionId}")
    @ResponseBody
    public Question apiQuestion(
            @PathVariable String questionId){
        return questionService.getQuestion(questionId);
    }

    @RequestMapping("/api/question/{questionId}/answer")
    @ResponseBody
    public RelativeMultiAnswer apiRelativeMultiAnswer(
            @PathVariable String questionId,
            @RequestParam(defaultValue = "1") String page){
        return questionService.getAnswerInQuestion(questionId, page);
    }

    @RequestMapping("/api/question")
    @ResponseBody
    public MultiQuestion apiQuestions(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(required = false) String tag){
        return questionService.getQuestions(tag, page);
    }

    @RequestMapping("/api/question_tag")
    @ResponseBody
    public MultiTag apiQuestionTags(){
        return questionService.getQuestionTags();
    }

    @RequestMapping("/question")
    public String getQuestions(
            ModelMap map,
            @RequestParam(required = false) String tag){
        MultiQuestion multiQuestion = questionService.getQuestions(tag, "1");
        MultiTag multiTag = questionService.getQuestionTags();
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
        MultiQuestion multiQuestion = questionService.getQuestions(tag, page);
        map.addAttribute("questions", multiQuestion);
        return "questions :: questionList";
    }

    @RequestMapping("/question/{qid}")
    public String getQuestion(
            ModelMap map,
            @PathVariable String qid){
        Question question = questionService.getQuestion(qid);
        RelativeMultiAnswer relativeMultiAnswer = questionService.getAnswerInQuestion(qid, "1");
        map.addAttribute("question", question);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question";
    }

    @RequestMapping("/ajax/question/{qid}/answer")
    public String getQuestion(
            ModelMap map,
            @PathVariable String qid,
            @RequestParam(value = "paged") String page){
        RelativeMultiAnswer relativeMultiAnswer = questionService.getAnswerInQuestion(qid, page);
        map.addAttribute("answers", relativeMultiAnswer);
        return "question :: answerList";
    }
}
