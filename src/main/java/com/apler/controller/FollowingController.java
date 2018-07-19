package com.apler.controller;

import com.apler.dao.FollowingDao;
import com.apler.entity.following.Following;
import com.apler.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class FollowingController {
    @Autowired
    private FollowingDao followingDao;

    @RequestMapping("/api/following/object")
    @ResponseBody
    public Following apiFollow(
            HttpServletRequest request,
            @RequestParam(value = "startId") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return followingDao.getFollowing(startId, hhzToken);
    }

    @RequestMapping("/following")
    public String index(
            HttpServletRequest request,
            ModelMap map){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Following following = followingDao.getFollowing(null, hhzToken);
        map.addAttribute("following", following);
        return "following";
    }

    @RequestMapping("/ajax/following")
    public String ajaxFollow(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value = "start") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Following following = followingDao.getFollowing(startId, hhzToken);
        map.addAttribute("following", following);
        return "following :: followingList";
    }
}
