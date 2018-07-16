package com.apler.dao;

import com.apler.config.Constant;
import com.apler.entity.house.House;
import com.apler.entity.house.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Repository
public class HouseDao {
    @Autowired
    private RestTemplate restTemplate;

    public House getHouse(String houseId){

        String fullUrl = Constant.GET_HOUSE_INFO;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + Constant.TOKEN);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("article_id", houseId);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
        HouseResponse houseResponse = restTemplate.postForObject(fullUrl, entity, HouseResponse.class);
        return houseResponse.getHouse();
    }
}
