package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.answer.Answer;
import com.apler.entity.answer.AnswerResponse;
import com.apler.entity.photo.Photo;
import com.apler.entity.photo.PhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class AnswerDao {
    @Autowired
    private RestTemplate restTemplate;

    public Answer getAnswer(String answerId){

        String fullUrl = Constant.GET_ANSWER_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("answer_id", answerId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        AnswerResponse answerResponse = restTemplate.postForObject(fullUrl, entity, AnswerResponse.class);
        return answerResponse.getAnswer();
    }
}
