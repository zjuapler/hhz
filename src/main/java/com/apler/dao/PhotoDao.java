package com.apler.dao;

import com.apler.config.URL;
import com.apler.entity.house.House;
import com.apler.entity.photo.Photo;
import com.apler.entity.photo.PhotoResponse;
import com.apler.entity.photo.RelativeHouseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class PhotoDao {
    @Autowired
    private RestTemplate restTemplate;

    public Photo getPhoto(String photoId, String hhzToken){

        String fullUrl = URL.GET_PHOTO_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("photo_id", photoId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        PhotoResponse photoResponse = restTemplate.postForObject(fullUrl, entity, PhotoResponse.class);
        return photoResponse.getPhoto();
    }

    public House getRelativeHouse(String photoId, String hhzToken){
        String fullUrl = URL.GET_HOUSE_IN_PHOTO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("photo_id", photoId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        RelativeHouseResponse relativeHouseResponse =
                restTemplate.postForObject(fullUrl, entity, RelativeHouseResponse.class);
        return relativeHouseResponse.getRelativeHouse().getHouse();
    }
}
