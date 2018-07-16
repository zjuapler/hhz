package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.answer.Answer;
import com.apler.entity.answer.AnswerResponse;
import com.apler.entity.recommend.Recommend;
import com.apler.entity.recommend.RecommendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class RecommendDao {
    @Autowired
    private RestTemplate restTemplate;

    public Recommend getRecommend(String page){

        String fullUrl = Constant.GET_RECOMMEND_OBJECTS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        RecommendResponse recommendResponse = restTemplate.postForObject(fullUrl, entity, RecommendResponse.class);
        return recommendResponse.getRecommend();
    }
}
