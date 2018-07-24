package com.apler.service;

import com.apler.config.Url;
import com.apler.vo.article.Article;
import com.apler.vo.article.ArticleResponse;
import java.util.*;

import org.springframework.stereotype.Service;


/**
 * @author Apler
 */
@Service
public class ArticleService extends BaseService{
    public Article getArticle(String articleId){
        String fullUrl = Url.GET_ARTICLE_INFO;

        Map<String, Object> params = new HashMap<>(1);
        params.put("blank_id", articleId);

        ArticleResponse response = (ArticleResponse) post(fullUrl, params, ArticleResponse.class);
        return response.getArticle();
    }
}
