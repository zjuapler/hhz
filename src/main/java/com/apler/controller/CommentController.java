package com.apler.controller;

import com.apler.service.CommentService;
import com.apler.vo.comment.HotComment;
import com.apler.vo.comment.MultiComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Apler
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/api/comment/{objectId}")
    public MultiComment multiComment(
            @PathVariable String objectId,
            @RequestParam(value="startId", defaultValue = "0") String startId){
        return commentService.getMultiComment(objectId, startId);
    }

    @RequestMapping("/api/hotcomment/{objectId}")
    public HotComment hotComment(
            @PathVariable String objectId){
        return commentService.getHotComment(objectId);
    }

}
