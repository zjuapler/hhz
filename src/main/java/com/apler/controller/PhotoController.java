package com.apler.controller;

import com.apler.service.CommentService;
import com.apler.vo.comment.HotComment;
import com.apler.vo.comment.MultiComment;
import com.apler.vo.photo.Photo;
import com.apler.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author Apler
 */
@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/api/photo/{photoId}")
    @ResponseBody
    public Photo apiPhoto(
            @PathVariable String photoId){
        return photoService.getPhoto(photoId);
    }

    @RequestMapping("/photo/{photoId}")
    public String photo(
            ModelMap map,
            @PathVariable String photoId){
        Photo photo = photoService.getPhoto(photoId);
        MultiComment comments = commentService.getMultiComment(photoId);
        HotComment hotComment = commentService.getHotComment(photoId);
        map.addAttribute("photo", photo);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "photo";
    }
}
