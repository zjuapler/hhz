package com.apler.service;

import com.apler.dao.favorite.FavoritePhotoDao;
import com.apler.entity.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    private FavoritePhotoDao favoriteDao;

    public MultiTag getFavoritePhotoTag(String hhzToken){
        return favoriteDao.getFavoritePhotoTag(hhzToken);
    }

}
