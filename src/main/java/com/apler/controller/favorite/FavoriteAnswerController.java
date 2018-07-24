package com.apler.controller.favorite;

import com.apler.service.FavoriteService;
import com.apler.vo.favorite.answer.FavoriteMultiAnswer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Apler
 */
@Slf4j
@Controller
public class FavoriteAnswerController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/api/favorite/answer")
    @ResponseBody
    public FavoriteMultiAnswer apiFavoriteAnswer(
            @CookieValue String uid,
            @RequestParam(value="start", required = false) String startId){
        return favoriteService.getFavoriteAnswer(startId, uid);
    }

    @RequestMapping("/favorite/answer")
    public String favoriteHouse(
            @CookieValue String uid,
            ModelMap map){
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteService.getFavoriteAnswer(null, uid);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer";
    }

    @RequestMapping("/ajax/favorite/answer")
    public String ajaxFavoriteHouse(
            @CookieValue String uid,
            ModelMap map,
            @RequestParam(value = "start") String startId){
        FavoriteMultiAnswer favoriteMultiAnswer = favoriteService.getFavoriteAnswer(startId, uid);
        map.addAttribute("answers", favoriteMultiAnswer);
        return "favorite/answer :: answerList";
    }
}
