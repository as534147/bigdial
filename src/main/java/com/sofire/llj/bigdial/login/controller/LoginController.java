package com.sofire.llj.bigdial.login.controller;


import com.sofire.llj.bigdial.common.domain.OutObjectParams;
import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeRandom;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String toLogins(HttpServletRequest request) throws UnknownHostException {
        return "html/login";
    }
    /**
     * 登录
     * @param session
     * @param params
     * @return
     */
    @PostMapping("/toLogin")
    @ResponseBody
    public OutObjectParams toLogin(HttpSession session, @RequestBody Map<String, Object> params) {
        PrizeRandom prizeRandom = PrizeRandom.getInstance();

        OutObjectParams outObjectParams = new OutObjectParams();

        String nameCode = (String)params.get("nameCode");
        String loginpassword = (String)params.get("loginpassword");

        List<PrizeProperty> prizeProperties = prizeRandom.getPrizeList();
        if(CollectionUtils.isEmpty(prizeProperties)){
            outObjectParams.setRespCode("-1");
            outObjectParams.setRespDesc("未初始化人员信息！");
        }
        //遍历内存数据获取信息
        for(PrizeProperty prizeProperty:prizeProperties){
            String nc = prizeProperty.getMemCode();
            if(!nameCode.equals(nc)){//非对应Code直接跳过
                continue;
            }
            String pass = prizeProperty.getLoginpassword();
            if(loginpassword.equals(pass)){
                session.setAttribute("loginUser",prizeProperty);
                outObjectParams.setRespCode("0");
                outObjectParams.setRespDesc("登录成功！");
                break;
            }
        }

        return outObjectParams;
    }

    @RequestMapping("/index")
    public String index(){

        return "html/index";
    }

}
