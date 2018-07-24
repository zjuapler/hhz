package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author Apler
 */
@Slf4j
@Service
public class BehaviorService extends BaseService{
    private Map<String, String> objectTypeMap = new HashMap<>();

    public BehaviorService(){
        objectTypeMap.put("photo", "1");
        objectTypeMap.put("house", "2");
        objectTypeMap.put("article", "5");
        objectTypeMap.put("answer", "4");
        objectTypeMap.put("comment", "11");
    }

    public boolean doLike(String objectId, String objectType){
        return likeAction(objectId, objectType, Url.DO_LIKE);
    }

    public boolean cancelLike(String objectId, String objectType){
        return likeAction(objectId, objectType, Url.DO_CANCEL_LIKE);
    }

    private boolean likeAction(String objectId, String objectType, String fullUrl){
        String realObjectType = objectTypeMap.get(objectType);

        Map<String, Object> params = new HashMap<>(2);
        params.put("obj_id", objectId);
        params.put("obj_type", realObjectType);

        Response response = (Response) post(fullUrl, params, Response.class);
        return response.getCode() == 1;
    }

    public boolean doLikeComment(String objectId, String commentId){
        return likeCommentAction(objectId, commentId, Url.DO_LIKE);
    }

    public boolean cancelLikeComment(String objectId, String commentId){
        return likeCommentAction(objectId, commentId, Url.DO_CANCEL_LIKE);
    }

    private boolean likeCommentAction(String objectId, String commentId, String fullUrl){
        String realObjectType = objectTypeMap.get("comment");

        Map<String, Object> params = new HashMap<>(3);
        params.put("obj_id", objectId);
        params.put("obj_type", realObjectType);
        params.put("comments_id", commentId);

        Response response = (Response) post(fullUrl, params, Response.class);
        return response.getCode() == 1;
    }

    public boolean doFavorite(String objectId, String objectType){
        String photoType = "photo";
        if (photoType.equals(objectType)) {
            return favoritePhotoAction(objectId, Url.DO_FAVORITE_PHOTO);
        } else {
            return favoriteOtherAction(objectId, objectType, Url.DO_FAVORITE);
        }
    }

    public boolean cancelFavorite(String objectId, String objectType){
        String photoType = "photo";
        if (photoType.equals(objectType)) {
            return favoritePhotoAction(objectId, Url.DO_CANCEL_FAVORITE_PHOTO);
        } else {
            return favoriteOtherAction(objectId, objectType, Url.DO_CANCEL_FAVORITE);
        }
    }

    private boolean favoritePhotoAction(String objectId, String fullUrl){
        Map<String, Object> params = new HashMap<>(1);
        params.put("photo_id", objectId);

        Response response = (Response) post(fullUrl, params, Response.class);
        return response.getCode() == 1;
    }

    private boolean favoriteOtherAction(String objectId, String objectType, String fullUrl){
        return likeAction(objectId, objectType, fullUrl);
    }

    public boolean doFollow(String uid){
        return followAction(uid, Url.DO_FOLLOW);
    }

    public boolean cancelFollow(String uid){
        return followAction(uid, Url.DO_CANCEL_FOLLOW);
    }

    private boolean followAction(String uid, String fullUrl){
        Map<String, Object> params = new HashMap<>(1);
        params.put("befollowed_uid", uid);

        Response response = (Response) post(fullUrl, params, Response.class);
        return response.getCode() == 1;
    }
}
