package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.question.*;
import com.apler.entity.tag.MultiTag;
import com.apler.entity.tag.MultiTagResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class QuestionDao {
    @Autowired
    private RestTemplate restTemplate;

    public Question getQuestion(String questionId){

        String fullUrl = Constant.GET_QUESTION_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("q_id", questionId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        QuestionResponse questionResponse = restTemplate.postForObject(fullUrl, entity, QuestionResponse.class);
        return questionResponse.getQuestion();
    }

    public RelativeMultiAnswer getAnswerInQuestion(String questionId, String page){

        String fullUrl = Constant.GET_ANSWER_IN_QUESTION;

        HttpHeaders headers = new HttpHeaders();

        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("q_id", questionId);
        params.add("page", page);
        params.add("type", "1");

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        RelativeMultiAnswerResponse relativeMultiAnswerResponse =
                restTemplate.postForObject(fullUrl, entity, RelativeMultiAnswerResponse.class);
//        log.info("relativeMultiAnswerResponse:"+relativeMultiAnswerResponse);
        return relativeMultiAnswerResponse.getRelativeMultiAnswer();
    }

    public MultiQuestion getQuestions(String tag, String page){

        String fullUrl = Constant.GET_QUESTIONS;

        HttpHeaders headers = new HttpHeaders();

        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("page", page);
        if (tag != null) {
            params.add("keyword", tag);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiQuestionResponse multiQuestionResponse =
                restTemplate.postForObject(fullUrl, entity, MultiQuestionResponse.class);
        return multiQuestionResponse.getMultiQuestion();
    }

    public MultiTag getQuestionTags(){

        String fullUrl = Constant.GET_QUESTION_TAGS;

        HttpHeaders headers = new HttpHeaders();

        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiTagResponse multiTagResponse =
                restTemplate.postForObject(fullUrl, entity, MultiTagResponse.class);
        return multiTagResponse.getMultiTag();
    }
}
