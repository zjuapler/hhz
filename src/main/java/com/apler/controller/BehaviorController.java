package com.apler.controller;

import com.apler.dao.BehaviorDao;
import com.apler.entity.Response;
import com.apler.entity.article.Article;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BehaviorController {
    @Autowired
    private BehaviorDao behaviorDao;

    @RequestMapping("/ajax/like")
    @ResponseBody
    public Response like(
            HttpServletRequest request,
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result = behaviorDao.doLike(objectId, objectType, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/likeComment")
    @ResponseBody
    public Response likeComment(
            HttpServletRequest request,
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "commitId") String commentId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result =  behaviorDao.doLikeComment(objectId, commentId, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLike")
    @ResponseBody
    public Response cancelLike(
            HttpServletRequest request,
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        boolean result =  behaviorDao.cancelLike(objectId, objectType, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLikeComment")
    @ResponseBody
    public Response cancelLikeComment(
            HttpServletRequest request,
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "commitId") String commentId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result =  behaviorDao.cancelLikeComment(objectId, commentId, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/favorite")
    @ResponseBody
    public Response favorite(
            HttpServletRequest request,
            @RequestParam String objectId,
            @RequestParam String objectType){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result = behaviorDao.doFavorite(objectId, objectType, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFavorite")
    @ResponseBody
    public Response cancelFavorite(
            HttpServletRequest request,
            @RequestParam String objectId,
            @RequestParam String objectType){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result = behaviorDao.cancelFavorite(objectId, objectType, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/follow")
    @ResponseBody
    public Response follow(
            HttpServletRequest request,
            @RequestParam String uid){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result = behaviorDao.doFollow(uid, hhzToken);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFollow")
    @ResponseBody
    public Response cancelFollow(
            HttpServletRequest request,
            @RequestParam String uid){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Boolean result = behaviorDao.cancelFollow(uid, hhzToken);
        return new Response(result);
    }
}
