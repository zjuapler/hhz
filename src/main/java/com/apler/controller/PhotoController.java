package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.dao.PhotoDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.house.House;
import com.apler.entity.photo.Photo;
import com.apler.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/photo/{photoId}")
    @ResponseBody
    public Photo apiPhoto(@PathVariable String photoId){
        return photoService.getPhoto(photoId);
    }

    @RequestMapping("/photo/{photoId}")
    public String photo(ModelMap map, @PathVariable String photoId){
        Photo photo = photoService.getPhoto(photoId);
        MultiComment comments = commentDao.getMultiComment(photoId);
        HotComment hotComment = commentDao.getHotComment(photoId);
        map.addAttribute("photo", photo);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "photo";
    }
}
