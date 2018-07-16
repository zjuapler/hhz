package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.following.Following;
import com.apler.entity.following.FollowingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class FollowingDao {
    @Autowired
    private RestTemplate restTemplate;

    public Following getFollowing(String startId){

        String fullUrl = Constant.GET_FOLLOW_OBJECTS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//        params.add("page", page);
        params.add("type", "1");
        if (startId != null) {
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FollowingResponse response = restTemplate.postForObject(fullUrl, entity, FollowingResponse.class);
        return response.getFollowing();
    }
}
