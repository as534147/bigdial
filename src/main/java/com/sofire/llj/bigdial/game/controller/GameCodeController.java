package com.sofire.llj.bigdial.game.controller;

import com.sofire.llj.bigdial.common.domain.OutObjectParams;
import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/game")
public class GameCodeController {

    @Autowired
    private GameService gameService;

    @ResponseBody
    @RequestMapping("/getcode")
    public OutObjectParams getcode(HttpSession session,@RequestBody Map<String, Object> params){
        //从session中获取抽奖用户信息
        Object loginUser = session.getAttribute("loginUser");
        PrizeProperty prizeProperty = (PrizeProperty)loginUser;
        String nameCode = prizeProperty.getMemCode();
        //创建出参对象
        OutObjectParams outObjectParams = gameService.queryStaffPrize(nameCode);
        return outObjectParams;
    }

    @ResponseBody
    @RequestMapping("/randomcode")
    public OutObjectParams randomCode(String nameCode){
        //创建出参对象
        OutObjectParams outObjectParams = gameService.releasePrizeRandom();
        return outObjectParams;
    }

}
