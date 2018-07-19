package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteAnswerDao;
import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.answer.FavoriteMultiAnswer;
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
public class FavoriteAnswerController {
    @Autowired
    private FavoriteAnswerDao favoriteDao;

    @RequestMapping("/api/favorite/answer")
    @ResponseBody
    public FavoriteMultiAnswer apiFavoriteAnswer(
            HttpServletRequest request,
            @RequestParam(value="start", required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        String uid = CookieUtil.getUid(cookies);
        if (uid == null){
            return null;
        }
        return favoriteDao.getFavoriteAnswer(startId, hhzToken, uid);
    }

    @RequestMapping("/favorite/answer")
    public String favoriteHouse(
            HttpServletRequest request,
            ModelMap map){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        String uid = CookieUtil.getUid(cookies);
        if (uid == null){
            return null;
        }
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteDao.getFavoriteAnswer(null, hhzToken, uid);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer";
    }

    @RequestMapping("/ajax/favorite/answer")
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
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteDao.getFavoriteAnswer(startId, hhzToken, uid);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer :: answerList";
    }
}
