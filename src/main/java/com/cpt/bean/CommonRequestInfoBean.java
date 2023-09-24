package com.cpt.bean;

public class CommonRequestInfoBean {
    String MchNo;
    long ReqTime;
    String sign;

    public String getMchNo() {
        return MchNo;
    }

    public void setMchNo(String mchNo) {
        MchNo = mchNo;
    }

    public long getReqTime() {
        return ReqTime;
    }

    public void setReqTime(long reqTime) {
        ReqTime = reqTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
