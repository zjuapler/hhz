package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.comment.HotComment;
import com.apler.vo.comment.HotCommentResponse;
import com.apler.vo.comment.MultiComment;
import com.apler.vo.comment.MultiCommentResponse;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * @author Apler
 */
@Service
public class CommentService extends BaseService{
    public MultiComment getMultiComment(String objectId){
        return getMultiComment(objectId, "0");
    }

    public MultiComment getMultiComment(String objectId, String startId){
        String fullUrl = Url.GET_COMMENTS;

        Map<String, Object> params = new HashMap<>(2);
        params.put("obj_id", objectId);
        params.put("start_id", startId);

        MultiCommentResponse response = (MultiCommentResponse) post(fullUrl, params, MultiCommentResponse.class);
        return response.getMultiComment();
    }

    public HotComment getHotComment(String objectId){
        String fullUrl = Url.GET_HOT_COMMENTS;

        Map<String, Object> params = new HashMap<>(1);
        params.put("obj_id", objectId);

        HotCommentResponse response = (HotCommentResponse) post(fullUrl, params, HotCommentResponse.class);
        return response.getHotComment();
    }
}
