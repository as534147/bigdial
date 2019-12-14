package com.sofire.llj.bigdial.game.service;

import com.sofire.llj.bigdial.common.domain.OutObjectParams;
import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;

import java.util.List;

public interface GameService {

    //从文件中获取员工数据信息
    public List<PrizeProperty> getStaffByFileExcel();

    //从数据库中获取员工数据信息
    public List<PrizeProperty> getStaffByDataSource();

    //从文件中获取奖品信息
    public List<PrizeSetProperty> getPrizePropertyByFile();

    //从数据库中获取奖品信息
    public List<PrizeSetProperty> getPrizePropertyByDataSource();

    //设置奖品池
    public void setPrizeRandomProperty();

    //获取获奖信息
    public OutObjectParams queryStaffPrize(String staffCode);

    //重置奖品池
    public OutObjectParams releasePrizeRandom();



}
