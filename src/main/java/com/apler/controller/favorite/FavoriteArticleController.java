package com.apler.controller.favorite;

import com.apler.service.FavoriteService;
import com.apler.vo.favorite.article.FavoriteMultiArticle;
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
@Controller
public class FavoriteArticleController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/api/favorite/article")
    @ResponseBody
    public FavoriteMultiArticle apiFavoriteArticle(
            @CookieValue String uid,
            @RequestParam(value="startId", required = false) String startId){
        return favoriteService.getFavoriteArticle(startId, uid);
    }

    @RequestMapping("/favorite/article")
    public String favoriteArticle(
            @CookieValue String uid,
            ModelMap map,
            @RequestParam(value="startId", required = false) String startId){
        FavoriteMultiArticle favoriteMultiArticle = favoriteService.getFavoriteArticle(startId, uid);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article";
    }

    @RequestMapping("/ajax/favorite/article")
    public String ajaxFavoriteArticle(
            @CookieValue String uid,
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiArticle favoriteMultiArticle = favoriteService.getFavoriteArticle(startId, uid);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article :: favoriteList";
    }
}
