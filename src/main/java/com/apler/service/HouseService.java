package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.house.House;
import com.apler.vo.house.HouseResponse;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * @author Apler
 */
@Service
public class HouseService extends BaseService{
    public House getHouse(String houseId){
        String fullUrl = Url.GET_HOUSE_INFO;

        Map<String, Object> params = new HashMap<>(1);
        params.put("article_id", houseId);

        HouseResponse response = (HouseResponse) post(fullUrl, params, HouseResponse.class);
        return response.getHouse();
    }
}
