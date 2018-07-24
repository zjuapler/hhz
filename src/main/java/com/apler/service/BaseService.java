package com.apler.service;

import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Apler
 */
public class BaseService {
    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected HttpServletRequest request;

    String getHhzToken(){
        Cookie[] cookies = request.getCookies();
        return CookieUtil.getHhzToken(cookies);
    }

    String getUid(){
        Cookie[] cookies = request.getCookies();
        return CookieUtil.getUid(cookies);
    }

    protected Object post(String url, Map<String, Object> params, Class<?> responseClass){
        String hhzToken = getHhzToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "hhz_token=" + hhzToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()){
            data.add(entry.getKey(), entry.getValue());
        }

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(data, headers);
        return restTemplate.postForObject(url, entity, responseClass);
    }
}
