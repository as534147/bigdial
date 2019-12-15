package com.sofire.llj.bigdial.login.controller;


import com.sofire.llj.bigdial.common.domain.OutObjectParams;
import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeRandom;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
//        for(PrizeProperty prizeProperty:prizeProperties){
        for(int i = 0;i<prizeProperties.size();i++){
            PrizeProperty prizeProperty = prizeProperties.get(i);
            String nc = prizeProperty.getMemCode();
            if(!nameCode.equals(nc)){//非对应Code直接跳过
                continue;
            }
            String pass = prizeProperty.getLoginpassword();
            if(loginpassword.equals(pass)){
                //判断是否以抽奖，如果中奖弹到获奖通知页面
                String isflag = prizeProperty.getIsFlag();
                List<PrizeSetProperty> prizeSetProperties = PrizeRandom.getInstance().getPrizeSetProperties();
                PrizeSetProperty prizeSetProperty = new PrizeSetProperty();
                //填充为获奖信息
                prizeSetProperty.setPrizeCode("0");
                prizeSetProperty.setPrizeName("未获奖！");
                //若获取到奖品，则填充奖品信息
                if(i<prizeSetProperties.size()){
                    prizeSetProperty =prizeSetProperties.get(i);
                }
                outObjectParams.setRespCode("0");
                outObjectParams.setRespDesc("登录成功！");
                if(!"0".equals(isflag)){
                    outObjectParams.setResult(prizeSetProperty);
                }
                //将登陆信息存入到session
                session.setAttribute("loginUser",prizeProperty);
                break;
            }
        }
        return outObjectParams;
    }

    /**
     * 跳转到转盘页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){

        return "html/index";
    }

    /**
     * 跳转到转盘页面
     * @return
     */
    @RequestMapping("/prizeShow")
    public String prizeShow(){

        return "html/prizeShow";
    }


    @RequestMapping("prize")
    @ResponseBody
    public OutObjectParams getPrizeName(HttpSession session){
        OutObjectParams outObjectParams = new OutObjectParams();
        PrizeProperty prizePropertyBy = (PrizeProperty)session.getAttribute("loginUser");
        String nameCode = prizePropertyBy.getMemCode();
        PrizeRandom prizeRandom = PrizeRandom.getInstance();
        List<PrizeProperty> prizeProperties = prizeRandom.getPrizeList();
        List<PrizeSetProperty> prizeSetProperties = prizeRandom.getPrizeSetProperties();
        PrizeSetProperty prizeSetProperty = new PrizeSetProperty();
        prizeSetProperty.setPrizeName("获奖信息异常了！");
        for(int i = 0;i<prizeProperties.size();i++){
            PrizeProperty prizeProperty = prizeProperties.get(i);
            String nc = prizeProperty.getMemCode();
            if(!nameCode.equals(nc)){//非对应Code直接跳过
                continue;
            }
            prizeSetProperty =prizeSetProperties.get(i);
            outObjectParams.setResult(prizeSetProperty);
        }
        outObjectParams.setRespCode("0");
        outObjectParams.setRespDesc("成功！");
        return outObjectParams;
    }

}
