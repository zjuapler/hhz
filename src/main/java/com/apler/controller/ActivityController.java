package com.apler.controller;

import com.apler.dao.ActivityDao;
import com.apler.entity.activity.Activity;
import com.apler.entity.activity.MultiActivity;
import com.apler.entity.activity.RelativeMultiPhoto;
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
public class ActivityController {
    @Autowired
    private ActivityDao activityDao;

    @RequestMapping("/api/activity/{activityId}")
    @ResponseBody
    public Activity apiActivity(
            HttpServletRequest request,
            @PathVariable String activityId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return activityDao.getActivity(activityId, hhzToken);
    }

    @RequestMapping("/api/activity/{activityId}/photo")
    @ResponseBody
    public RelativeMultiPhoto apiActivity(
            HttpServletRequest request,
            @PathVariable String activityId,
            @RequestParam(required = false) String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return activityDao.getPhotoInActivity(activityId, startId, hhzToken);
    }

    @RequestMapping("/activity/{activityId}")
    public String activity(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String activityId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        Activity activity = activityDao.getActivity(activityId, hhzToken);
        map.addAttribute("activity", activity);

        RelativeMultiPhoto relativeMultiPhoto = activityDao.getPhotoInActivity(activityId, null, hhzToken);
        map.addAttribute("photos", relativeMultiPhoto);
        return "activity";
    }

    @RequestMapping("/ajax/activity/{activityId}")
    public String ajaxActivity(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String activityId,
            @RequestParam(value = "start") String startId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        RelativeMultiPhoto relativeMultiPhoto = activityDao.getPhotoInActivity(activityId, startId, hhzToken);
        map.addAttribute("photos", relativeMultiPhoto);
        return "activity :: photoList";
    }

    @RequestMapping("/api/activity")
    @ResponseBody
    public MultiActivity apiActivities(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return activityDao.getActivities(page, hhzToken);
    }

    @RequestMapping("/activity")
    public String getActivities(
            HttpServletRequest request,
            ModelMap map){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiActivity multiActivity = activityDao.getActivities("1", hhzToken);
        map.addAttribute("activities", multiActivity);
        return "activities";
    }

    @RequestMapping("/ajax/activity")
    public String getActivities(
            HttpServletRequest request,
            ModelMap map,
            @RequestParam(value = "paged") String page){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        MultiActivity multiActivity = activityDao.getActivities(page, hhzToken);
        map.addAttribute("activities", multiActivity);
        return "activities :: activityList";
    }
}
