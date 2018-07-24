package com.apler.controller.favorite;

import com.apler.service.FavoriteService;
import com.apler.vo.favorite.house.FavoriteMultiHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Slf4j
@Controller
public class FavoriteHouseController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/api/favorite/house")
    @ResponseBody
    public FavoriteMultiHouse apiFavoriteHouse(
            @CookieValue String uid,
            @RequestParam(value="startId", required = false) String startId){
        return favoriteService.getFavoriteHouse(startId, uid);
    }

    @RequestMapping("/favorite/house")
    public String favoriteHouse(
            @CookieValue String uid,
            ModelMap map,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiHouse favoriteMultiHouse = favoriteService.getFavoriteHouse(startId, uid);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house";
    }

    @RequestMapping("/ajax/favorite/house")
    public String ajaxFavoriteHouse(
            @CookieValue String uid,
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiHouse favoriteMultiHouse = favoriteService.getFavoriteHouse(startId, uid);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house :: favoriteList";
    }
}
