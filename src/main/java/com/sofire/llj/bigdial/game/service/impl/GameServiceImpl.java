package com.sofire.llj.bigdial.game.service.impl;

import com.sofire.llj.bigdial.common.domain.OutObjectParams;
import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeRandom;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;
import com.sofire.llj.bigdial.game.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    PrizeRandom prizeRandom = PrizeRandom.getInstance();

    @Override
    public List<PrizeProperty> getStaffByFileExcel() {
        return null;
    }

    @Override
    public List<PrizeProperty> getStaffByDataSource() {
        return null;
    }

    @Override
    public List<PrizeSetProperty> getPrizePropertyByFile() {

        return null;
    }

    @Override
    public List<PrizeSetProperty> getPrizePropertyByDataSource() {
        return null;
    }

    @Override
    public void setPrizeRandomProperty() {

    }

    /**
     * 通过工号获取获奖信息
     * @param staffCode
     * @return
     */
    @Override
    public OutObjectParams queryStaffPrize(String staffCode) {
        //初始化出参
        OutObjectParams outObjectParams = new OutObjectParams();
        outObjectParams.setRespCode("0");
        outObjectParams.setRespDesc("成功");
        outObjectParams.setResult(null);
        List<PrizeProperty> prizeProperties = prizeRandom.getPrizeList();
        List<PrizeSetProperty> prizeSetPropertyList = prizeRandom.getPrizeSetProperties();

        //遍历获取用户获奖信息
        for(int i=0;i<prizeProperties.size();i++){
            PrizeProperty p = prizeProperties.get(i);
            String prizeCode = p.getMemCode();
            if(!staffCode.equals(prizeCode)){
                continue;//若未对应，跳出此次循环
            }
            String isFlag = p.getIsFlag();
            if(!"0".equals(isFlag)){//表示用户已进行抽奖
                outObjectParams.setResult("-1");//表示用户已进行了抽奖
                break;
            }
//            p.setIsFlag("1");//标记已进行抽奖

            PrizeSetProperty ps = prizeSetPropertyList.get(i);//获取对应的获奖奖品
            if(i<prizeSetPropertyList.size()){
                outObjectParams.setResult(ps.getPrizeCode());//插入奖品编码
                p.setRandomPize(ps.getPrizeCode());//插入奖品编码
            }else{
                outObjectParams.setResult("0");//插入未奖品编码
                p.setRandomPize("0");//插入未奖品编码
            }
            break;
        }

        return outObjectParams;
    }

    /**
     * 重置抽奖系统
     * @return
     */
    @Override
    public OutObjectParams releasePrizeRandom() {
        OutObjectParams outObjectParams = new OutObjectParams();
        List<PrizeProperty> prizeProperties = prizeRandom.getPrizeList();
        Collections.shuffle(prizeProperties);
        for(PrizeProperty prizeProperty:prizeProperties){
            prizeProperty.setIsFlag("0");
        }
        outObjectParams.setRespCode("0");
        outObjectParams.setRespDesc("成功！");
        return outObjectParams;
    }

    //对员工数据进行操作

}
