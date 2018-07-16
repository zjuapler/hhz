package com.apler.controller;

import com.apler.dao.FollowingDao;
import com.apler.entity.following.Following;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class FollowingController {
    @Autowired
    private FollowingDao followingDao;

    @RequestMapping("/api/following/object")
    @ResponseBody
    public Following apiFollow(
//            @RequestParam(value = "page") String page,
            @RequestParam(value = "startId") String startId){
        return followingDao.getFollowing(startId);
    }

    @RequestMapping("/following")
    public String index(ModelMap map){
        Following following = followingDao.getFollowing(null);
        map.addAttribute("following", following);
        return "following";
    }

    @RequestMapping("/ajax/following")
    public String ajaxFollow(
            ModelMap map,
//            @RequestParam(value = "paged") String page,
            @RequestParam(value = "start") String startId){
        Following following = followingDao.getFollowing(startId);
        map.addAttribute("following", following);
        return "following :: followingList";
    }
}
