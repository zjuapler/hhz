package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.dao.PhotoDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.house.House;
import com.apler.entity.photo.Photo;
import com.apler.service.PhotoService;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/photo/{photoId}")
    @ResponseBody
    public Photo apiPhoto(
            HttpServletRequest request,
            @PathVariable String photoId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return photoService.getPhoto(photoId, hhzToken);
    }

    @RequestMapping("/photo/{photoId}")
    public String photo(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String photoId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Photo photo = photoService.getPhoto(photoId, hhzToken);
        MultiComment comments = commentDao.getMultiComment(photoId, hhzToken);
        HotComment hotComment = commentDao.getHotComment(photoId, hhzToken);
        map.addAttribute("photo", photo);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "photo";
    }
}
