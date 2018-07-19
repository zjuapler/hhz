package com.apler.dao;

import com.apler.config.URL;
import com.apler.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Repository
public class BehaviorDao {
    @Autowired
    private RestTemplate restTemplate;

    private Map<String, String> objectTypeMap = new HashMap<>();

    public BehaviorDao(){
        objectTypeMap.put("photo", "1");
        objectTypeMap.put("house", "2");
        objectTypeMap.put("article", "5");
        objectTypeMap.put("answer", "4");
        objectTypeMap.put("comment", "11");
    }

    public boolean doLike(String objectId, String objectType, String hhzToken){
        return likeAction(objectId, objectType, URL.DO_LIKE, hhzToken);
    }

    public boolean cancelLike(String objectId, String objectType, String hhzToken){
        return likeAction(objectId, objectType, URL.DO_CANCEL_LIKE, hhzToken);
    }

    private boolean likeAction(String objectId, String objectType, String fullUrl, String hhzToken){
        String realObjectType = objectTypeMap.get(objectType);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("obj_id", objectId);
        params.add("obj_type", realObjectType);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        Response response = restTemplate.postForObject(fullUrl, entity, Response.class);
        return response.getCode() == 1;
    }

    public boolean doLikeComment(String objectId, String commentId, String hhzToken){
        return likeCommentAction(objectId, commentId, URL.DO_LIKE, hhzToken);
    }

    public boolean cancelLikeComment(String objectId, String commentId, String hhzToken){
        return likeCommentAction(objectId, commentId, URL.DO_CANCEL_LIKE, hhzToken);
    }

    private boolean likeCommentAction(String objectId, String commentId, String fullUrl, String hhzToken){
        String realObjectType = objectTypeMap.get("comment");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("obj_id", objectId);
        params.add("obj_type", realObjectType);
        params.add("comments_id", commentId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        Response response = restTemplate.postForObject(fullUrl, entity, Response.class);
        return response.getCode() == 1;
    }

    public boolean doFavorite(String objectId, String objectType, String hhzToken){
        if (objectType.equals("photo")) {
            return favoritePhotoAction(objectId, URL.DO_FAVORITE_PHOTO, hhzToken);
        } else {
            return favoriteOtherAction(objectId, objectType, URL.DO_FAVORITE, hhzToken);
        }
    }

    public boolean cancelFavorite(String objectId, String objectType, String hhzToken){
        if (objectType.equals("photo")) {
            return favoritePhotoAction(objectId, URL.DO_CANCEL_FAVORITE_PHOTO, hhzToken);
        } else {
            return favoriteOtherAction(objectId, objectType, URL.DO_CANCEL_FAVORITE, hhzToken);
        }
    }

    private boolean favoritePhotoAction(String objectId, String fullUrl, String hhzToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("photo_id", objectId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        Response response = restTemplate.postForObject(fullUrl, entity, Response.class);
        return response.getCode() == 1;
    }

    private boolean favoriteOtherAction(String objectId, String objectType, String fullUrl, String hhzToken){
        return likeAction(objectId, objectType, fullUrl, hhzToken);
    }

    public boolean doFollow(String uid, String hhzToken){
        return followAction(uid, URL.DO_FOLLOW, hhzToken);
    }

    public boolean cancelFollow(String uid, String hhzToken){
        return followAction(uid, URL.DO_CANCEL_FOLLOW, hhzToken);
    }

    private boolean followAction(String uid, String fullUrl, String hhzToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("befollowed_uid", uid);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        Response response = restTemplate.postForObject(fullUrl, entity, Response.class);
        return response.getCode() == 1;
    }
}
