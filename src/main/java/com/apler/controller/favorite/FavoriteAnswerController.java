package com.apler.controller.favorite;

import com.apler.dao.favorite.FavoriteAnswerDao;
import com.apler.dao.favorite.FavoriteHouseDao;
import com.apler.entity.favorite.answer.FavoriteMultiAnswer;
import com.apler.entity.favorite.house.FavoriteMultiHouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class FavoriteAnswerController {
    @Autowired
    private FavoriteAnswerDao favoriteDao;

    @RequestMapping("/api/favorite/answer")
    @ResponseBody
    public FavoriteMultiAnswer apiFavoriteAnswer(
            @RequestParam(value="start", required = false) String startId){
        log.info("startId:" + startId);
        return favoriteDao.getFavoriteAnswer(startId);
    }

    @RequestMapping("/favorite/answer")
    public String favoriteHouse(
            ModelMap map){
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteDao.getFavoriteAnswer(null);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer";
    }

    @RequestMapping("/ajax/favorite/answer")
    public String ajaxFavoriteHouse(
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteDao.getFavoriteAnswer(startId);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer :: answerList";
    }
}
