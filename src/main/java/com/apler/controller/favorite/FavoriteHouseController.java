package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import com.apler.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class FavoriteHouseController {
    @Autowired
    private FavoriteHouseDao favoriteDao;

    @RequestMapping("/api/favorite/house")
    @ResponseBody
    public FavoriteMultiHouse apiFavoriteHouse(
            HttpServletRequest request,
            @RequestParam(value="startId", required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        String uid = CookieUtil.getUid(cookies);
        if (uid == null){
            return null;
        }
        log.info("startId:" + startId);
        return favoriteDao.getFavoriteHouse(startId, hhzToken, uid);
    }

    @RequestMapping("/favorite/house")
    public String favoriteHouse(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value="startId", required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        String uid = CookieUtil.getUid(cookies);
        if (uid == null){
            return null;
        }
        log.info("favorite/house: " + hhzToken + ", " + uid);
        FavoriteMultiHouse favoriteMultiHouse = favoriteDao.getFavoriteHouse(startId, hhzToken, uid);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house";
    }

    @RequestMapping("/ajax/favorite/house")
    public String ajaxFavoriteHouse(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value = "start") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        String uid = CookieUtil.getUid(cookies);
        if (uid == null){
            return null;
        }
        FavoriteMultiHouse favoriteMultiHouse = favoriteDao.getFavoriteHouse(startId, hhzToken, uid);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house :: favoriteList";
    }
}
