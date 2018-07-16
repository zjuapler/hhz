package com.apler.controller;

import com.apler.dao.BehaviorDao;
import com.apler.entity.Response;
import com.apler.entity.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BehaviorController {
    @Autowired
    private BehaviorDao behaviorDao;

    @RequestMapping("/ajax/like")
    @ResponseBody
    public Response like(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        Boolean result = behaviorDao.doLike(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/likeComment")
    @ResponseBody
    public Response likeComment(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "commitId") String commentId){
        Boolean result =  behaviorDao.doLikeComment(objectId, commentId);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLike")
    @ResponseBody
    public Response cancelLike(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        boolean result =  behaviorDao.cancelLike(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLikeComment")
    @ResponseBody
    public Response cancelLikeComment(
             @RequestParam(value = "objectId") String objectId,
             @RequestParam(value = "commitId") String commentId){
        Boolean result =  behaviorDao.cancelLikeComment(objectId, commentId);
        return new Response(result);
    }

    @RequestMapping("/ajax/favorite")
    @ResponseBody
    public Response favorite(@RequestParam String objectId, @RequestParam String objectType){
        Boolean result = behaviorDao.doFavorite(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFavorite")
    @ResponseBody
    public Response cancelFavorite(@RequestParam String objectId, @RequestParam String objectType){
        Boolean result = behaviorDao.cancelFavorite(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/follow")
    @ResponseBody
    public Response follow(@RequestParam String uid){
        Boolean result = behaviorDao.doFollow(uid);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFollow")
    @ResponseBody
    public Response cancelFollow(@RequestParam String uid){
        Boolean result = behaviorDao.cancelFollow(uid);
        return new Response(result);
    }
}
