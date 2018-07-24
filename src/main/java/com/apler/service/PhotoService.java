package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.house.House;
import com.apler.vo.photo.Photo;
import com.apler.vo.photo.PhotoResponse;
import com.apler.vo.photo.RelativeHouseResponse;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Apler
 */
@Service
public class PhotoService extends BaseService{
    public Photo getPhoto(String photoId){
        Photo photo = getPhotoOnly(photoId);
        House house = getRelativeHouse(photoId);
        if (house != null && house.getId() != null){
            photo.setRelativeHouseId(house.getId());
        }
        return photo;
    }

    private Photo getPhotoOnly(String photoId){
        Map<String, Object> params = new HashMap<>(1);
        params.put("photo_id", photoId);
        PhotoResponse response = (PhotoResponse) post(Url.GET_PHOTO_INFO, params, PhotoResponse.class);
        return response.getPhoto();
    }

    private House getRelativeHouse(String photoId){
        Map<String, Object> params = new HashMap<>(1);
        params.put("photo_id", photoId);
        RelativeHouseResponse response = (RelativeHouseResponse) post(Url.GET_PHOTO_INFO, params,
                RelativeHouseResponse.class);
        return response.getRelativeHouse().getHouse();
    }
}
