package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.dao.favorite.FavoritePhotoDao;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.photo.MultiPhotoWithType;
import com.apler.entity.tag.MultiTag;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SearchPhotoController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/photo")
    @ResponseBody
    public MultiPhotoWithType apiSearchPhoto(
            HttpServletRequest request,
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return searchDao.getSearchPhoto(keyword, page, hhzToken);
    }

    @RequestMapping("/search/photo")
    public String getSearchPhoto(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiPhotoWithType multiPhotoWithType = searchDao.getSearchPhoto(keyword, "1", hhzToken);
        map.addAttribute("photos", multiPhotoWithType);
        map.addAttribute("keyword", keyword);
        return "search/photo";
    }

    @RequestMapping("/ajax/search/photo")
    public String ajaxSearchPhoto(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiPhotoWithType multiPhotoWithType = searchDao.getSearchPhoto(keyword, page, hhzToken);
        map.addAttribute("photos", multiPhotoWithType);
        return "search/photo :: photoList";
    }
}
