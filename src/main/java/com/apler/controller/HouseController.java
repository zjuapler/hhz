package com.apler.controller;

import com.apler.service.CommentService;
import com.apler.service.HouseService;
import com.apler.vo.comment.HotComment;
import com.apler.vo.comment.MultiComment;
import com.apler.vo.house.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/api/house/{houseId}")
    @ResponseBody
    public House apiHouse(
            @PathVariable String houseId){
        return houseService.getHouse(houseId);
    }

    @RequestMapping("/house/{houseId}")
    public String house(
            ModelMap map,
            @PathVariable String houseId){
        House house = houseService.getHouse(houseId);
        map.addAttribute("house", house);
        MultiComment comments = commentService.getMultiComment(houseId);
        HotComment hotComment = commentService.getHotComment(houseId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "house";
    }
}
