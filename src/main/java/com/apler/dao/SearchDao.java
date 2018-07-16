package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.favorite.photo.FavoriteMultiPhotoResponse;
import com.apler.entity.photo.MultiPhotoWithType;
import com.apler.entity.photo.MultiPhotoWithTypeResponse;
import com.apler.entity.search.*;
import com.apler.entity.tag.MultiTag;
import com.apler.entity.tag.MultiTagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class SearchDao {
    @Autowired
    private RestTemplate restTemplate;

    public MultiPhotoWithType getSearchPhoto(String keyword, String page){

        String fullUrl = Constant.GET_SEARCH_PHOTOS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("tab", "12");
        params.add("search_type", "1");
        params.add("keyword", keyword);
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiPhotoWithTypeResponse multiPhotoWithTypeResponse =
                restTemplate.postForObject(fullUrl, entity, MultiPhotoWithTypeResponse.class);
        return multiPhotoWithTypeResponse.getMultiPhotoWithType();
    }

    public MultiHouseWithType getSearchHouse(String keyword, String page){

        String fullUrl = Constant.GET_SEARCH_HOUSES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("tab", "12");
        params.add("search_type", "1");
        params.add("type", "1");
        params.add("keyword", keyword);
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiHouseWithTypeResponse multiHouseWithTypeResponse =
                restTemplate.postForObject(fullUrl, entity, MultiHouseWithTypeResponse.class);
        return multiHouseWithTypeResponse.getMultiHouseWithType();
    }

    public MultiArticleWithType getSearchArticle(String keyword, String page){

        String fullUrl = Constant.GET_SEARCH_ARTICLES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("tab", "12");
        params.add("search_type", "1");
        params.add("type", "2,5");
        params.add("keyword", keyword);
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiArticleWithTypeResponse multiArticleWithTypeResponse =
                restTemplate.postForObject(fullUrl, entity, MultiArticleWithTypeResponse.class);
        return multiArticleWithTypeResponse.getMultiArticleWithType();
    }

    public MultiQuestionWithType getSearchQuestion(String keyword, String page){

        String fullUrl = Constant.GET_SEARCH_QUESTIONS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("tab", "12");
        params.add("keyword", keyword);
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiQuestionWithTypeResponse multiArticleWithTypeResponse =
                restTemplate.postForObject(fullUrl, entity, MultiQuestionWithTypeResponse.class);
        return multiArticleWithTypeResponse.getMultiQuestionWithType();
    }
}
