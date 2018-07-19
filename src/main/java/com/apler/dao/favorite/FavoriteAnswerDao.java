package com.apler.dao.favorite;

import com.apler.config.URL;
import com.apler.entity.favorite.answer.FavoriteMultiAnswer;
import com.apler.entity.favorite.answer.FavoriteMultiAnswerResponse;
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

    public FavoriteMultiAnswer getFavoriteAnswer(String startId, String hhzToken, String uid){

        String fullUrl = URL.GET_FAVORITE_ANSWERS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("uid", uid);
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
