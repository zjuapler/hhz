package com.apler.controller.search;

import com.apler.dao.SearchDao;
import com.apler.dao.favorite.FavoritePhotoDao;
import com.apler.entity.favorite.photo.FavoriteMultiPhoto;
import com.apler.entity.photo.MultiPhotoWithType;
import com.apler.entity.tag.MultiTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SearchPhotoController {
    @Autowired
    private SearchDao searchDao;

    @RequestMapping("/api/search/photo")
    @ResponseBody
    public MultiPhotoWithType apiSearchPhoto(
            @RequestParam String keyword,
            @RequestParam(value="paged", defaultValue = "1") String page){
        return searchDao.getSearchPhoto(keyword, page);
    }

    @RequestMapping("/search/photo")
    public String getSearchPhoto(
            ModelMap map,
            @RequestParam String keyword){
        MultiPhotoWithType multiPhotoWithType = searchDao.getSearchPhoto(keyword, "1");
        map.addAttribute("photos", multiPhotoWithType);
        map.addAttribute("keyword", keyword);
        return "search/photo";
    }

    @RequestMapping("/ajax/search/photo")
    public String ajaxSearchPhoto(
            ModelMap map,
            @RequestParam String keyword,
            @RequestParam(value="paged") String page){
        MultiPhotoWithType multiPhotoWithType = searchDao.getSearchPhoto(keyword, page);
        map.addAttribute("photos", multiPhotoWithType);
        return "search/photo :: photoList";
    }
}
