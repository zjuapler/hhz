package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.entity.photo.MultiPhotoWithType;
import com.apler.entity.search.MultiHouseWithType;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SearchHouseController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/house")
    @ResponseBody
    public MultiHouseWithType apiSearchHouse(
            HttpServletRequest request,
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return searchDao.getSearchHouse(keyword, page, hhzToken);
    }

    @RequestMapping("/search/house")
    public String getSearchPhoto(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiHouseWithType multiHouseWithType = searchDao.getSearchHouse(keyword, "1", hhzToken);
        map.addAttribute("houses", multiHouseWithType);
        map.addAttribute("keyword", keyword);
        return "search/house";
    }

    @RequestMapping("/ajax/search/house")
    public String ajaxSearchHouse(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiHouseWithType multiHouseWithType = searchDao.getSearchHouse(keyword, page, hhzToken);
        map.addAttribute("houses", multiHouseWithType);
        return "search/house :: houseList";
    }
}
