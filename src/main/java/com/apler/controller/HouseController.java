package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.dao.HouseDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.house.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HouseController {
    @Autowired
    private HouseDao houseDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/house/{houseId}")
    @ResponseBody
    public House apiHouse(@PathVariable String houseId){
        return houseDao.getHouse(houseId);
    }

    @RequestMapping("/house/{houseId}")
    public String house(ModelMap map, @PathVariable String houseId){
        House house = houseDao.getHouse(houseId);
        map.addAttribute("house", house);
        MultiComment comments = commentDao.getMultiComment(houseId);
        HotComment hotComment = commentDao.getHotComment(houseId);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "house";
    }
}
