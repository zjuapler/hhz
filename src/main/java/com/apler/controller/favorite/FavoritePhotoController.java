package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoritePhotoDao;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.tag.MultiTag;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class FavoritePhotoController {
    @Autowired
    private FavoritePhotoDao favoriteDao;

    @RequestMapping("/api/favorite/photo")
    @ResponseBody
    public FavoriteMultiPhoto apiFavoritePhoto(
            HttpServletRequest request,
            @RequestParam(value="tag", defaultValue = "全部") String tagName,
            @RequestParam(value="startId", required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return favoriteDao.getFavoritePhoto(tagName, startId, hhzToken);
    }

    @RequestMapping("/api/favorite/photo-tag")
    @ResponseBody
    public MultiTag apiFavoritePhotoTag(
            HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return favoriteDao.getFavoritePhotoTag(hhzToken);
    }

    @RequestMapping("/favorite/photo")
    public String favoritePhoto(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String tag,
            @RequestParam(value="startId", required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteDao.getFavoritePhoto(tag, startId, hhzToken);
        MultiTag multiTag = favoriteDao.getFavoritePhotoTag(hhzToken);
        map.addAttribute("photos", favoriteMultiPhoto);
        map.addAttribute("tags", multiTag);
        map.addAttribute("tag", tag);
        return "favorite/photo";
    }

    @RequestMapping("ajax/favorite/photo")
    public String ajaxFavoritePhoto(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String tag,
            @RequestParam(value = "start") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        FavoriteMultiPhoto favoriteMultiPhoto = favoriteDao.getFavoritePhoto(tag, startId, hhzToken);
        map.addAttribute("photos", favoriteMultiPhoto);
        return "favorite/photo :: favoriteList";
    }
}
