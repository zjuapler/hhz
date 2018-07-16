package com.apler.dao.favorite;

import com.apler.config.Constant;
import com.apler.entity.favorite.answer.FavoriteMultiAnswer;
import com.apler.entity.favorite.answer.FavoriteMultiAnswerResponse;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.favorite.photo.FavoriteMultiPhotoResponse;
import com.apler.entity.tag.MultiTag;
import com.apler.entity.tag.MultiTagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class FavoriteAnswerDao {
    @Autowired
    private RestTemplate restTemplate;

    public FavoriteMultiAnswer getFavoriteAnswer(String startId){

        String fullUrl = Constant.GET_FAVORITE_ANSWERS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("uid", Constant.UID);
        params.add("obj_type", "4");
        if (startId != null){
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FavoriteMultiAnswerResponse favoriteMultiAnswerResponse =
                restTemplate.postForObject(fullUrl, entity, FavoriteMultiAnswerResponse.class);
        return favoriteMultiAnswerResponse.getFavoriteMultiAnswer();
    }
}
