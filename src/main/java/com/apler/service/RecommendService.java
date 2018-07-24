package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.recommend.Recommend;
import com.apler.vo.recommend.RecommendResponse;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author Apler
 */
@Service
public class RecommendService extends BaseService{
    public Recommend getRecommend(String page){
        String fullUrl = Url.GET_RECOMMEND_OBJECTS;

        Map<String, Object> params = new HashMap<>(1);
        params.put("page", page);

        RecommendResponse response = (RecommendResponse) post(fullUrl, params, RecommendResponse.class);
        return response.getRecommend();
    }
}
