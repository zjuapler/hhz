package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.entity.photo.MultiPhotoWithType;
import com.apler.entity.search.MultiHouseWithType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SearchHouseController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/house")
    @ResponseBody
    public MultiHouseWithType apiSearchHouse(
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        return searchDao.getSearchHouse(keyword, page);
    }

    @RequestMapping("/search/house")
    public String getSearchPhoto(
            ModelMap map,
            @RequestParam String keyword){
        MultiHouseWithType multiHouseWithType = searchDao.getSearchHouse(keyword, "1");
        map.addAttribute("houses", multiHouseWithType);
        map.addAttribute("keyword", keyword);
        return "search/house";
    }

    @RequestMapping("/ajax/search/house")
    public String ajaxSearchHouse(
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        MultiHouseWithType multiHouseWithType = searchDao.getSearchHouse(keyword, page);
        map.addAttribute("houses", multiHouseWithType);
        return "search/house :: houseList";
    }
}
