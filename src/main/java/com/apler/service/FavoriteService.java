package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.favorite.answer.FavoriteMultiAnswer;
import com.apler.vo.favorite.answer.FavoriteMultiAnswerResponse;
import com.apler.vo.favorite.article.FavoriteMultiArticle;
import com.apler.vo.favorite.article.FavoriteMultiArticleResponse;
import com.apler.vo.favorite.house.FavoriteMultiHouse;
import com.apler.vo.favorite.house.FavoriteMultiHouseResponse;
import com.apler.vo.favorite.photo.FavoriteMultiPhoto;
import com.apler.vo.favorite.photo.FavoriteMultiPhotoResponse;
import com.apler.vo.tag.MultiTag;
import com.apler.vo.tag.MultiTagResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Apler
 */
@Service
public class FavoriteService extends BaseService{
    public FavoriteMultiAnswer getFavoriteAnswer(String startId, String uid){
        Map<String, Object> params = new HashMap<>(3);
        params.put("uid", uid);
        params.put("obj_type", "4");
        if (startId != null){
            params.put("start_id", startId);
        }
        FavoriteMultiAnswerResponse response = (FavoriteMultiAnswerResponse) post(Url.GET_FAVORITE_ANSWERS, params,
                FavoriteMultiAnswerResponse.class);
        return response.getFavoriteMultiAnswer();
    }

    public FavoriteMultiArticle getFavoriteArticle(String startId, String uid){
        Map<String, Object> params = new HashMap<>(3);
        params.put("type", "5");
        params.put("uid", uid);
        if(startId != null) {
            params.put("start_id", startId);
        }

        FavoriteMultiArticleResponse response = (FavoriteMultiArticleResponse) post(Url.GET_FAVORITE_ARTICLES, params,
                FavoriteMultiArticleResponse.class);
        return response.getFavoriteMultiArticle();
    }

    public FavoriteMultiHouse getFavoriteHouse(String startId, String uid){
        String fullUrl = Url.GET_FAVORITE_HOUSES;

        Map<String, Object> params = new HashMap<>(3);
        params.put("type", "6");
        params.put("uid", uid);
        if(startId != null) {
            params.put("start_id", startId);
        }

        FavoriteMultiHouseResponse response = (FavoriteMultiHouseResponse) post(fullUrl, params,
                FavoriteMultiHouseResponse.class);
        return response.getFavoriteMultiHouse();
    }

    public FavoriteMultiPhoto getFavoritePhoto(String tagName, String startId){
        String fullUrl = Url.GET_FAVORITE_PHOTOS;

        Map<String, Object> params = new HashMap<>(2);
        params.put("tag_name", tagName);
        params.put("start_id", startId);

        FavoriteMultiPhotoResponse response = (FavoriteMultiPhotoResponse) post(fullUrl, params,
                FavoriteMultiPhotoResponse.class);
        return response.getFavoriteMultiPhoto();
    }

    public MultiTag getFavoritePhotoTag(){
        String fullUrl = Url.GET_FAVORITE_PHOTO_TAGS;

        Map<String, Object> params = new HashMap<>(1);

        MultiTagResponse response = (MultiTagResponse) post(fullUrl, params, MultiTagResponse.class);
        return response.getMultiTag();
    }
}
