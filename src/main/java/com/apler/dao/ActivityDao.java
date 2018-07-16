package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.activity.*;
import com.apler.entity.house.House;
import com.apler.entity.house.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class ActivityDao {
    @Autowired
    private RestTemplate restTemplate;

    public Activity getActivity(String activityId){

        String fullUrl = Constant.GET_ACTIVITY_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("activity_id", activityId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        ActivityResponse response = restTemplate.postForObject(fullUrl, entity, ActivityResponse.class);
        return response.getActivity();
    }

    public RelativeMultiPhoto getPhotoInActivity(String activityId, String startId){
        String fullUrl = Constant.GET_PHOTO_IN_ACTIVITY;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("activity_id", activityId);
        if (startId != null){
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        RelativeMultiPhotoResponse response = restTemplate.postForObject(fullUrl, entity, RelativeMultiPhotoResponse.class);
        return response.getRelativeMultiPhoto();
    }

    public MultiActivity getActivities(String page){
        String fullUrl = Constant.GET_ACTIVITIES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("page", page);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiActivityResponse response = restTemplate.postForObject(fullUrl, entity, MultiActivityResponse.class);
        return response.getMultiActivity();
    }
}
