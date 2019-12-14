package com.sofire.llj.bigdial.common.prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 奖品池，会在设置后自动进行奖品分配
 */
public class PrizeRandom {

    /**
     * 创建一个私有的构造器，阻止外部通过构造器进行对象创建，为单例提供创建方式
     */
    private PrizeRandom (){}

    //个人奖品信息集合
    private  List<PrizeProperty> prizeList = new ArrayList<PrizeProperty>();
    //奖品信息
    private List<PrizeSetProperty> prizeSetProperties;

    private static class PrizeRandomHolder{
        /**
         * 通过静态初始器，由jvm保证线程安全
         */
        private static PrizeRandom prizeRandom = new PrizeRandom();

    }

    /**
     * 提供给外部获取对象内容
     * @return
     */
    public static PrizeRandom getInstance(){
        return PrizeRandomHolder.prizeRandom;
    }

    //获取奖品
    public List<PrizeProperty> getPrizeList() {
        return prizeList;
    }

    //设置奖品时使用
    public void setPrizeList(List<PrizeProperty> prizeList) {
        this.prizeList = prizeList;
    }

    public List<PrizeSetProperty> getPrizeSetProperties() {
        return prizeSetProperties;
    }

    public void setPrizeSetProperties(List<PrizeSetProperty> prizeSetProperties) {
        this.prizeSetProperties = prizeSetProperties;
    }
}
