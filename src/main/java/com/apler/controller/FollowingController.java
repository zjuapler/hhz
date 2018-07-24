package com.apler.controller;

import com.apler.service.FollowingService;
import com.apler.vo.following.Following;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Slf4j
@Controller
public class FollowingController {
    @Autowired
    private FollowingService followingService;

    @RequestMapping("/api/following/object")
    @ResponseBody
    public Following apiFollow(
            @RequestParam(value = "startId") String startId){
        return followingService.getFollowing(startId);
    }

    @RequestMapping("/following")
    public String index(
            ModelMap map){
        Following following = followingService.getFollowing(null);
        map.addAttribute("following", following);
        return "following";
    }

    @RequestMapping("/ajax/following")
    public String ajaxFollow(
            ModelMap map,
            @RequestParam(value = "start") String startId){
        Following following = followingService.getFollowing(startId);
        map.addAttribute("following", following);
        return "following :: followingList";
    }
}
