package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.question.*;
import com.apler.vo.tag.MultiTag;
import com.apler.vo.tag.MultiTagResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Apler
 */
@Slf4j
@Service
public class QuestionService extends BaseService{
    public Question getQuestion(String questionId){
        String fullUrl = Url.GET_QUESTION_INFO;

        Map<String, Object> params = new HashMap<>(1);
        params.put("q_id", questionId);

        QuestionResponse response = (QuestionResponse) post(fullUrl, params, QuestionResponse.class);
        return response.getQuestion();
    }

    public RelativeMultiAnswer getAnswerInQuestion(String questionId, String page){
        String fullUrl = Url.GET_ANSWER_IN_QUESTION;

        Map<String, Object> params = new HashMap<>(3);
        params.put("q_id", questionId);
        params.put("page", page);
        params.put("type", "1");

        RelativeMultiAnswerResponse response = (RelativeMultiAnswerResponse) post(fullUrl, params,
                RelativeMultiAnswerResponse.class);
        return response.getRelativeMultiAnswer();
    }

    public MultiQuestion getQuestions(String tag, String page){
        String fullUrl = Url.GET_QUESTIONS;

        Map<String, Object> params = new HashMap<>(2);
        params.put("page", page);
        if (tag != null) {
            params.put("keyword", tag);
        }

        MultiQuestionResponse response = (MultiQuestionResponse) post(fullUrl, params, MultiQuestionResponse.class);
        return response.getMultiQuestion();
    }

    public MultiTag getQuestionTags(){
        String fullUrl = Url.GET_QUESTION_TAGS;

        Map<String, Object> params = new HashMap<>(1);

        MultiTagResponse response = (MultiTagResponse) post(fullUrl, params, MultiTagResponse.class);
        return response.getMultiTag();
    }
}
