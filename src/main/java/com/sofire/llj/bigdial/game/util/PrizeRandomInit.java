package com.sofire.llj.bigdial.game.util;

import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeRandom;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 奖品池初始化
 */
public class PrizeRandomInit {
    PrizeRandom prizeRandom = PrizeRandom.getInstance();

    /**
     * 后台一次性人员填充，并乱序获取对应下标奖品
     * @param prizeProperties
     */
    public void prizeRandomStaffInit(List<PrizeProperty> prizeProperties){

        /**
         * 乱序人员信息，获取对应prizeSetProperties中的数据
         */
        Integer inNum = 0;//奖品总数量
        Collections.shuffle(prizeProperties);
        List<Map<String,Object>> list = new ArrayList<>();
        prizeRandom.setPrizeList(prizeProperties);
        System.out.println(prizeProperties);
    }
    /**
     * 后台一次性奖品填充，
     * 此逻辑可支持前台随机获取奖品
     * @param prizeSetProperties
     */
    public void prizeRandomSetInit(List<PrizeSetProperty> prizeSetProperties){
        /**
         * 填充数据
         */
        List<PrizeSetProperty> prizeSetPropertiesTo = new ArrayList<PrizeSetProperty>();
        for(PrizeSetProperty prizeSetProperty:prizeSetProperties){
            Integer in = prizeSetProperty.getPrizeNum();
            for(int i=0;i<in;i++){
                prizeSetPropertiesTo.add(prizeSetProperty);
            }
        }
        prizeRandom.setPrizeSetProperties(prizeSetPropertiesTo);
        System.out.println(prizeSetPropertiesTo);
    }

    public InputStream getPrizemessage(){
        //获取项目中的数据
        return  getClass().getClassLoader().getResourceAsStream("prizemessage.xls");
    }
    public InputStream getPrizeSet(){
        //获取项目中的数据
        return  getClass().getClassLoader().getResourceAsStream("prizeSet.xls");
    }




}
