package com.apler.controller;

import com.apler.service.BehaviorService;
import com.apler.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class BehaviorController {
    @Autowired
    private BehaviorService behaviorService;

    @RequestMapping("/ajax/like")
    @ResponseBody
    public Response like(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        Boolean result = behaviorService.doLike(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/likeComment")
    @ResponseBody
    public Response likeComment(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "commitId") String commentId){
        Boolean result =  behaviorService.doLikeComment(objectId, commentId);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLike")
    @ResponseBody
    public Response cancelLike(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "objectType") String objectType){
        boolean result =  behaviorService.cancelLike(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelLikeComment")
    @ResponseBody
    public Response cancelLikeComment(
            @RequestParam(value = "objectId") String objectId,
            @RequestParam(value = "commitId") String commentId){
        Boolean result =  behaviorService.cancelLikeComment(objectId, commentId);
        return new Response(result);
    }

    @RequestMapping("/ajax/favorite")
    @ResponseBody
    public Response favorite(
            @RequestParam String objectId,
            @RequestParam String objectType){
        Boolean result = behaviorService.doFavorite(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFavorite")
    @ResponseBody
    public Response cancelFavorite(
            @RequestParam String objectId,
            @RequestParam String objectType){
        Boolean result = behaviorService.cancelFavorite(objectId, objectType);
        return new Response(result);
    }

    @RequestMapping("/ajax/follow")
    @ResponseBody
    public Response follow(
            @RequestParam String uid){
        Boolean result = behaviorService.doFollow(uid);
        return new Response(result);
    }

    @RequestMapping("/ajax/cancelFollow")
    @ResponseBody
    public Response cancelFollow(
            @RequestParam(value = "uid", required = false, defaultValue = "12345") String uid){
        Boolean result = behaviorService.cancelFollow(uid);
        return new Response(result);
    }
}
