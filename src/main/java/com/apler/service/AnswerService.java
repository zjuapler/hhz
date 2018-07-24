package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.answer.Answer;
import com.apler.vo.answer.AnswerResponse;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author Apler
 */
@Service
public class AnswerService extends BaseService{
    public Answer getAnswer(String answerId){
        String fullUrl = Url.GET_ANSWER_INFO;

        Map<String, Object> params = new HashMap<>(1);
        params.put("answer_id", answerId);

        AnswerResponse response = (AnswerResponse) post(fullUrl, params, AnswerResponse.class);
        return response.getAnswer();
    }
}
