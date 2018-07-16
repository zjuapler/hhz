package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class FavoriteHouseController {
    @Autowired
    private FavoriteHouseDao favoriteDao;

    @RequestMapping("/api/favorite/house")
    @ResponseBody
    public FavoriteMultiHouse apiFavoriteHouse(
            @RequestParam(value="startId", required = false) String startId){
        log.info("startId:" + startId);
        return favoriteDao.getFavoriteHouse(startId);
    }

    @RequestMapping("/favorite/house")
    public String favoriteHouse(
            ModelMap map,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiHouse favoriteMultiHouse = favoriteDao.getFavoriteHouse(startId);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house";
    }

    @RequestMapping("/ajax/favorite/house")
    public String ajaxFavoriteHouse(
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiHouse favoriteMultiHouse = favoriteDao.getFavoriteHouse(startId);
        map.addAttribute("houses", favoriteMultiHouse);
        return "favorite/house :: favoriteList";
    }
}
