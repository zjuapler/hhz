package com.apler.service;

import com.apler.dao.PhotoDao;
import com.apler.entity.house.House;
import com.apler.entity.photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    private PhotoDao photoDao;

    public Photo getPhoto(String photoId, String hhzToken){
        Photo photo = photoDao.getPhoto(photoId, hhzToken);
        House house = photoDao.getRelativeHouse(photoId, hhzToken);
        if (house != null && house.getId() != null){
            photo.setRelativeHouseId(house.getId());
        }
        return photo;
    }
}
