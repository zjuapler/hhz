package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.following.Following;
import com.apler.vo.following.FollowingResponse;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * @author Apler
 */
@Service
public class FollowingService extends BaseService{
    public Following getFollowing(String startId){
        String fullUrl = Url.GET_FOLLOW_OBJECTS;

        Map<String, Object> params = new HashMap<>(2);
        params.put("type", "1");
        if (startId != null) {
            params.put("start_id", startId);
        }

        FollowingResponse response = (FollowingResponse) post(fullUrl, params, FollowingResponse.class);
        return response.getFollowing();
    }
}
