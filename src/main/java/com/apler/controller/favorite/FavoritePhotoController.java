package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoritePhotoDao;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FavoritePhotoController {
    @Autowired
    private FavoritePhotoDao favoriteDao;

    @RequestMapping("/api/favorite/photo")
    @ResponseBody
    public FavoriteMultiPhoto apiFavoritePhoto(
            @RequestParam(value="tag", defaultValue = "全部") String tagName,
            @RequestParam(value="startId", required = false) String startId){
        return favoriteDao.getFavoritePhoto(tagName, startId);
    }

    @RequestMapping("/api/favorite/photo-tag")
    @ResponseBody
    public MultiTag apiFavoritePhotoTag(){
        return favoriteDao.getFavoritePhotoTag();
    }

    @RequestMapping("/favorite/photo")
    public String favoritePhoto(
            ModelMap map,
            @RequestParam String tag,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteDao.getFavoritePhoto(tag, startId);
        MultiTag multiTag = favoriteDao.getFavoritePhotoTag();
        map.addAttribute("photos", favoriteMultiPhoto);
        map.addAttribute("tags", multiTag);
        map.addAttribute("tag", tag);
        return "favorite/photo";
    }

    @RequestMapping("ajax/favorite/photo")
    public String ajaxFavoritePhoto(
            ModelMap map,
            @RequestParam String tag,
            @RequestParam(value = "start") String startId){
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteDao.getFavoritePhoto(tag, startId);
        map.addAttribute("photos", favoriteMultiPhoto);
        return "favorite/photo :: favoriteList";
    }
}
