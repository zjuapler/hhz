package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.activity.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Apler
 */
@Service
public class ActivityService extends BaseService{
    public Activity getActivity(String activityId){
        String fullUrl = Url.GET_ACTIVITY_INFO;

        Map<String, Object> params = new HashMap<>(1);
        params.put("activity_id", activityId);

        ActivityResponse response = (ActivityResponse) post(fullUrl, params, ActivityResponse.class);
        return response.getActivity();
    }

    public RelativeMultiPhoto getPhotoInActivity(String activityId, String startId){
        String fullUrl = Url.GET_PHOTO_IN_ACTIVITY;

        Map<String, Object> params = new HashMap<>(2);
        params.put("activity_id", activityId);
        if (startId != null){
            params.put("start_id", startId);
        }

        RelativeMultiPhotoResponse response = (RelativeMultiPhotoResponse) post(fullUrl, params,
                RelativeMultiPhotoResponse.class);
        return response.getRelativeMultiPhoto();
    }

    public MultiActivity getActivities(String page){
        String fullUrl = Url.GET_ACTIVITIES;

        Map<String, Object> params = new HashMap<>(1);
        params.put("page", page);

        MultiActivityResponse response = (MultiActivityResponse) post(fullUrl, params, MultiActivityResponse.class);
        return response.getMultiActivity();
    }
}
