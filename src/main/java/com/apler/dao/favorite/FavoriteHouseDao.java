package com.apler.dao.favorite;

import com.apler.config.Constant;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import com.apler.entity.favorite.house.FavoriteMultiHouseResponse;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.favorite.photo.FavoriteMultiPhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class FavoriteHouseDao {
    @Autowired
    private RestTemplate restTemplate;

    public FavoriteMultiHouse getFavoriteHouse(String startId){

        String fullUrl = Constant.GET_FAVORITE_HOUSES;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("type", "6");
        params.add("uid", Constant.UID);
        if(startId != null) {
            params.add("start_id", startId);
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        FavoriteMultiHouseResponse favoriteMultiHouseResponse =
                restTemplate.postForObject(fullUrl, entity, FavoriteMultiHouseResponse.class);
        return favoriteMultiHouseResponse.getFavoriteMultiHouse();
    }

}
