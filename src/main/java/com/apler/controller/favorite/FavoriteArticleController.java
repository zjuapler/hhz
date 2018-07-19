package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteArticleDao;
import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.article.FavoriteMultiArticle;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FavoriteArticleController {
    @Autowired
    private FavoriteArticleDao favoriteDao;

    @RequestMapping("/api/favorite/article")
    @ResponseBody
    public FavoriteMultiArticle apiFavoriteArticle(
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
        return favoriteDao.getFavoriteArticle(startId, hhzToken, uid);
    }

    @RequestMapping("/favorite/article")
    public String favoriteArticle(
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
        FavoriteMultiArticle favoriteMultiArticle = favoriteDao.getFavoriteArticle(startId, hhzToken, uid);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article";
    }

    @RequestMapping("/ajax/favorite/article")
    public String ajaxFavoriteArticle(
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
        FavoriteMultiArticle favoriteMultiArticle = favoriteDao.getFavoriteArticle(startId, hhzToken, uid);
        map.addAttribute("articles", favoriteMultiArticle);
        return "favorite/article :: favoriteList";
    }
}
