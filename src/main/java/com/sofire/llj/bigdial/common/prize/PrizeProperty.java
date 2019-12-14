package com.sofire.llj.bigdial.common.prize;

/**
 * 抽奖人信息
 * 包含登录信息，账号密码
 */
public class PrizeProperty {

    private String memCode;//员工工号
    private String memName;//员工名称
    private String randomPize;//随机奖品等级
    private String isFlag;//是否抽奖
    private String memOrigin;//员工组织
    private String loginpassword;//登录指令

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getRandomPize() {
        return randomPize;
    }

    public void setRandomPize(String randomPize) {
        this.randomPize = randomPize;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    public String getMemOrigin() {
        return memOrigin;
    }

    public void setMemOrigin(String memOrigin) {
        this.memOrigin = memOrigin;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    @Override
    public String toString() {
        return "PrizeProperty{" +
                "memCode='" + memCode + '\'' +
                ", memName='" + memName + '\'' +
                ", randomPize='" + randomPize + '\'' +
                ", isFlag='" + isFlag + '\'' +
                ", memOrigin='" + memOrigin + '\'' +
                ", loginpassword='" + loginpassword + '\'' +
                '}';
    }
}
