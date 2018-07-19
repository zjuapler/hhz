package com.apler.dao.favorite;

import com.apler.config.URL;
import com.apler.entity.favorite.article.FavoriteMultiArticle;
import com.apler.entity.favorite.article.FavoriteMultiArticleResponse;
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

    public FavoriteMultiArticle getFavoriteArticle(String startId, String hhzToken, String uid){

        String fullUrl = URL.GET_FAVORITE_ARTICLES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("type", "5");
        params.add("uid", uid);
        if(startId != null) {
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FavoriteMultiArticleResponse favoriteMultiArticleResponse =
                restTemplate.postForObject(fullUrl, entity, FavoriteMultiArticleResponse.class);
        return favoriteMultiArticleResponse.getFavoriteMultiArticle();
    }

}
