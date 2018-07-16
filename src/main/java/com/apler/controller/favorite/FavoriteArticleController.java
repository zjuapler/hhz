package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteArticleDao;
import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.article.FavoriteMultiArticle;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FavoriteArticleController {
    @Autowired
    private FavoriteArticleDao favoriteDao;

    @RequestMapping("/api/favorite/article")
    @ResponseBody
    public FavoriteMultiArticle apiFavoriteArticle(
            @RequestParam(value="startId", required = false) String startId){
        return favoriteDao.getFavoriteArticle(startId);
    }

    @RequestMapping("/favorite/article")
    public String favoriteArticle(
            ModelMap map,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiArticle favoriteMultiArticle = favoriteDao.getFavoriteArticle(startId);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article";
    }

    @RequestMapping("/ajax/favorite/article")
    public String ajaxFavoriteArticle(
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiArticle favoriteMultiArticle = favoriteDao.getFavoriteArticle(startId);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article :: favoriteList";
    }
}
