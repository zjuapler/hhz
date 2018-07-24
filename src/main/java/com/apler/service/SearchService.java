package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.photo.MultiPhotoWithType;
import com.apler.vo.photo.MultiPhotoWithTypeResponse;
import com.apler.vo.search.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Apler
 */
@Service
public class SearchService extends BaseService{
    public MultiPhotoWithType getSearchPhoto(String keyword, String page){
        String fullUrl = Url.GET_SEARCH_PHOTOS;

        Map<String, Object> params = new HashMap<>(4);
        params.put("tab", "12");
        params.put("search_type", "1");
        params.put("keyword", keyword);
        params.put("page", page);

        MultiPhotoWithTypeResponse response = (MultiPhotoWithTypeResponse) post(fullUrl, params,
                MultiPhotoWithTypeResponse.class);
        return response.getMultiPhotoWithType();
    }

    public MultiHouseWithType getSearchHouse(String keyword, String page){
        String fullUrl = Url.GET_SEARCH_HOUSES;

        Map<String, Object> params = new HashMap<>(5);
        params.put("tab", "12");
        params.put("search_type", "1");
        params.put("type", "1");
        params.put("keyword", keyword);
        params.put("page", page);

        MultiHouseWithTypeResponse response = (MultiHouseWithTypeResponse) post(fullUrl, params,
                MultiHouseWithTypeResponse.class);
        return response.getMultiHouseWithType();
    }

    public MultiArticleWithType getSearchArticle(String keyword, String page){
        String fullUrl = Url.GET_SEARCH_ARTICLES;

        Map<String, Object> params = new HashMap<>(5);
        params.put("tab", "12");
        params.put("search_type", "1");
        params.put("type", "2,5");
        params.put("keyword", keyword);
        params.put("page", page);

        MultiArticleWithTypeResponse response = (MultiArticleWithTypeResponse)
                post(fullUrl, params, MultiArticleWithTypeResponse.class);
        return response.getMultiArticleWithType();
    }

    public MultiQuestionWithType getSearchQuestion(String keyword, String page){
        String fullUrl = Url.GET_SEARCH_QUESTIONS;

        Map<String, Object> params = new HashMap<>(3);
        params.put("tab", "12");
        params.put("keyword", keyword);
        params.put("page", page);

        MultiQuestionWithTypeResponse response = (MultiQuestionWithTypeResponse) post(fullUrl, params,
                MultiQuestionWithTypeResponse.class);
        return response.getMultiQuestionWithType();
    }
}
