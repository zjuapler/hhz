package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/comment/{objectId}")
    public MultiComment multiComment(
            @PathVariable String objectId,
            @RequestParam(value="startId", defaultValue = "0") String startId){
        return commentDao.getMultiComment(objectId, startId);
    }

    @RequestMapping("/api/hotcomment/{objectId}")
    public HotComment hotComment(@PathVariable String objectId){
        return commentDao.getHotComment(objectId);
    }

}
