package com.apler.dao.favorite;

import com.apler.config.Constant;
import com.apler.entity.favorite.article.FavoriteMultiArticle;
import com.apler.entity.favorite.article.FavoriteMultiArticleResponse;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import com.apler.entity.favorite.house.FavoriteMultiHouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class FavoriteArticleDao {
    @Autowired
    private RestTemplate restTemplate;

    public FavoriteMultiArticle getFavoriteArticle(String startId){

        String fullUrl = Constant.GET_FAVORITE_ARTICLES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("type", "5");
        params.add("uid", Constant.UID);
        if(startId != null) {
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FavoriteMultiArticleResponse favoriteMultiArticleResponse =
                restTemplate.postForObject(fullUrl, entity, FavoriteMultiArticleResponse.class);
        return favoriteMultiArticleResponse.getFavoriteMultiArticle();
    }

}
