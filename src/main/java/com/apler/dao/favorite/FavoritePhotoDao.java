package com.apler.dao.favorite;

import com.apler.config.URL;
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
public class FavoritePhotoDao {
    @Autowired
    private RestTemplate restTemplate;

    public FavoriteMultiPhoto getFavoritePhoto(String tagName, String startId, String hhzToken){

        String fullUrl = URL.GET_FAVORITE_PHOTOS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("tag_name", tagName);
        params.add("start_id", startId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FavoriteMultiPhotoResponse favoriteMultiPhotoResponse =
                restTemplate.postForObject(fullUrl, entity, FavoriteMultiPhotoResponse.class);
        return favoriteMultiPhotoResponse.getFavoriteMultiPhoto();
    }

    public MultiTag getFavoritePhotoTag(String hhzToken){

        String fullUrl = URL.GET_FAVORITE_PHOTO_TAGS;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        MultiTagResponse multiTagResponse =
                restTemplate.postForObject(fullUrl, entity, MultiTagResponse.class);
        return multiTagResponse.getMultiTag();
    }
}
