package com.sofire.llj.bigdial.common.domain;

/**
 * 业务出参规范
 */
public class OutObjectParams {

    private Object result;//出参结果
    private String respCode;//业务参数
    private String respDesc;//业务描述

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    @Override
    public String toString() {
        return "OutObjectParams{" +
                "result=" + result +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                '}';
    }
}
