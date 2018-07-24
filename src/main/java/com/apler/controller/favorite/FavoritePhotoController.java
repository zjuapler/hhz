package com.apler.controller.favorite;

import com.apler.service.FavoriteService;
import com.apler.vo.favorite.photo.FavoriteMultiPhoto;
import com.apler.vo.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class FavoritePhotoController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/api/favorite/photo")
    @ResponseBody
    public FavoriteMultiPhoto apiFavoritePhoto(
            @RequestParam(value="tag", defaultValue = "全部") String tagName,
            @RequestParam(value="startId", required = false) String startId){
        return favoriteService.getFavoritePhoto(tagName, startId);
    }

    @RequestMapping("/api/favorite/photo-tag")
    @ResponseBody
    public MultiTag apiFavoritePhotoTag(){
        return favoriteService.getFavoritePhotoTag();
    }

    @RequestMapping("/favorite/photo")
    public String favoritePhoto(
            ModelMap map,
            @RequestParam String tag,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteService.getFavoritePhoto(tag, startId);
        MultiTag multiTag = favoriteService.getFavoritePhotoTag();
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
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteService.getFavoritePhoto(tag, startId);
        map.addAttribute("photos", favoriteMultiPhoto);
        return "favorite/photo :: favoriteList";
    }
}
