package com.apler.controller;

import com.apler.dao.CommentDao;
import com.apler.dao.HouseDao;
import com.apler.entity.comment.HotComment;
import com.apler.entity.comment.MultiComment;
import com.apler.entity.house.House;
import com.apler.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HouseController {
    @Autowired
    private HouseDao houseDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/api/house/{houseId}")
    @ResponseBody
    public House apiHouse(
            HttpServletRequest request,
            @PathVariable String houseId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        return houseDao.getHouse(houseId, hhzToken);
    }

    @RequestMapping("/house/{houseId}")
    public String house(
            HttpServletRequest request,
            ModelMap map,
            @PathVariable String houseId){
        Cookie[] cookies = request.getCookies();
        String hhzToken = CookieUtil.getHhzToken(cookies);
        if (hhzToken == null){
            return null;
        }
        House house = houseDao.getHouse(houseId, hhzToken);
        map.addAttribute("house", house);
        MultiComment comments = commentDao.getMultiComment(houseId, hhzToken);
        HotComment hotComment = commentDao.getHotComment(houseId, hhzToken);
        map.addAttribute("comments", comments);
        map.addAttribute("hotComment", hotComment);
        return "house";
    }
}
