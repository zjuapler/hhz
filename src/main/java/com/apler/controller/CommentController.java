package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CommentController {
    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/comment/{objectId}")
    public MultiComment multiComment(
            HttpServletRequest request,
            @PathVariable String objectId,
            @RequestParam(value="startId", defaultValue = "0") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return commentDao.getMultiComment(objectId, startId, hhzToken);
    }

    @RequestMapping("/api/hotcomment/{objectId}")
    public HotComment hotComment(
            HttpServletRequest request,
            @PathVariable String objectId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return commentDao.getHotComment(objectId, hhzToken);
    }

}
