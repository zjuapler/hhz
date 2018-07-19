package com.apler.dao;

import com.apler.config.URL;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.HotCommentResponse;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.comment.MultiCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class CommentDao {
    @Autowired
    private RestTemplate restTemplate;

    public MultiComment getMultiComment(String objectId, String hhzToken){
        return getMultiComment(objectId, "0", hhzToken);
    }

    public MultiComment getMultiComment(String objectId, String startId, String hhzToken){

        String fullUrl = URL.GET_COMMENTS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("obj_id", objectId);
        params.add("start_id", startId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiCommentResponse multiCommentResponse =
                restTemplate.postForObject(fullUrl, entity, MultiCommentResponse.class);
        return multiCommentResponse.getMultiComment();
    }

    public HotComment getHotComment(String objectId, String hhzToken){

        String fullUrl = URL.GET_HOT_COMMENTS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("obj_id", objectId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        HotCommentResponse hotCommentResponse =
                restTemplate.postForObject(fullUrl, entity, HotCommentResponse.class);
        return hotCommentResponse.getHotComment();
    }

}
