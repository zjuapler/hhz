package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.article.Article;
import com.apler.entity.article.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class ArticleDao {
    @Autowired
    private RestTemplate restTemplate;

    public Article getArticle(String articleId){

        String fullUrl = Constant.GET_ARTICLE_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("blank_id", articleId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        ArticleResponse articleResponse = restTemplate.postForObject(fullUrl, entity, ArticleResponse.class);
        return articleResponse.getArticle();
    }
}
