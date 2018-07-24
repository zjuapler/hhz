package com.apler.controller;

import com.apler.service.ActivityService;
import com.apler.vo.activity.Activity;
import com.apler.vo.activity.MultiActivity;
import com.apler.vo.activity.RelativeMultiPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/api/activity/{activityId}")
    @ResponseBody
    public Activity apiActivity(
            @PathVariable String activityId){
        return activityService.getActivity(activityId);
    }

    @RequestMapping("/api/activity/{activityId}/photo")
    @ResponseBody
    public RelativeMultiPhoto apiActivity(
            @PathVariable String activityId,
            @RequestParam(required = false) String startId){
        return activityService.getPhotoInActivity(activityId, startId);
    }

    @RequestMapping("/activity/{activityId}")
    public String activity(
            ModelMap map,
            @PathVariable String activityId){
        Activity activity = activityService.getActivity(activityId);
        map.addAttribute("activity", activity);

        RelativeMultiPhoto relativeMultiPhoto = activityService.getPhotoInActivity(activityId, null);
        map.addAttribute("photos", relativeMultiPhoto);
        return "activity";
    }

    @RequestMapping("/ajax/activity/{activityId}")
    public String ajaxActivity(
            ModelMap map,
            @PathVariable String activityId,
            @RequestParam(value = "start") String startId){
        RelativeMultiPhoto relativeMultiPhoto = activityService.getPhotoInActivity(activityId, startId);
        map.addAttribute("photos", relativeMultiPhoto);
        return "activity :: photoList";
    }

    @RequestMapping("/api/activity")
    @ResponseBody
    public MultiActivity apiActivities(
            @RequestParam(defaultValue = "1") String page){
        return activityService.getActivities(page);
    }

    @RequestMapping("/activity")
    public String getActivities(ModelMap map){
        MultiActivity multiActivity = activityService.getActivities("1");
        map.addAttribute("activities", multiActivity);
        return "activities";
    }

    @RequestMapping("/ajax/activity")
    public String getActivities(
            ModelMap map,
            @RequestParam(value = "paged") String page){
        MultiActivity multiActivity = activityService.getActivities(page);
        map.addAttribute("activities", multiActivity);
        return "activities :: activityList";
    }
}
