package com.sofire.llj.bigdial.common.prize;

/**
 * 奖品设置信息
 */
public class PrizeSetProperty {

    private String prizeCode;//奖品编码
    private String prizeName;//奖品名称
    private String prizeDesc;//奖品描述
    private String prizeImg;//奖品图片
    private Integer prizeNum;//奖品数量

    public String getPrizeCode() {
        return prizeCode;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeImg() {
        return prizeImg;
    }

    public void setPrizeImg(String prizeImg) {
        this.prizeImg = prizeImg;
    }

    public Integer getPrizeNum() {
        return prizeNum;
    }

    public void setPrizeNum(Integer prizeNum) {
        this.prizeNum = prizeNum;
    }

    public String getPrizeDesc() {
        return prizeDesc;
    }

    public void setPrizeDesc(String prizeDesc) {
        this.prizeDesc = prizeDesc;
    }

    @Override
    public String toString() {
        return "PrizeSetProperty{" +
                "prizeCode='" + prizeCode + '\'' +
                ", prizeName='" + prizeName + '\'' +
                ", prizeDesc='" + prizeDesc + '\'' +
                ", prizeImg='" + prizeImg + '\'' +
                ", prizeNum=" + prizeNum +
                '}';
    }
}
